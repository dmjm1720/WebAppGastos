package mx.bean;

import java.io.IOException;

import mx.model.Viaje;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import mx.model.Usuario;
import mx.dao.ConceptoDao;
import mx.dao.xmlDao;
import mx.impl.ConceptoDaoImpl;
import mx.impl.xmlDaoImpl;
import mx.model.xml;

public class verificarcorreo {

    private List<xml> listaxml;

    public int verificarcorreo(Viaje viaje) throws MessagingException, NoSuchProviderException, IOException, InterruptedException {
        int retorno = 0;
        String uuid = null;
        String usu = viaje.getFolioUsuario();
        String ususat = viaje.getNombreViajero();
        xmlDao cDao = new xmlDaoImpl();
        this.listaxml = cDao.selectviaje(usu, ususat);
        if (listaxml.size() == 0) {

            return 1;
        }
        Properties prop = new Properties();
        prop.setProperty("mail.pop3.port", "110");
        prop.setProperty("mail.pop3.socketFactory.port", "110");

        Session sesion = Session.getInstance(prop);
        sesion.setDebug(true);
        Store store = sesion.getStore("pop3");
        store.connect("mail.grupocomercialtria.com.mx", "validaciones@grupocomercialtria.com.mx", "WK4iaKFhAj");
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        Message[] mensajes = folder.getMessages();
        for (int p = 0; p < listaxml.size(); p++) {
            int datos = listaxml.get(p).getEstatus();
            if (datos == 3) {
                uuid = listaxml.get(p).getuuid();
                ArrayList array = new ArrayList();
                array.add(uuid);

                // Puerto 995 para conectarse.
                int i = 0;
                for (i = mensajes.length - 1; i >= 1; i--) {
                    if (mensajes[i].isMimeType("text/*")) {
                        Multipart mp = (Multipart) mensajes[i].getContent();
                        BodyPart bp = mp.getBodyPart(0);
                        String html = bp.getContent().toString();
                        String result = org.jsoup.Jsoup.parse(html).text();
                        System.out.println(result);
                    }
                    // mensaje de texto simple
                    if (mensajes[i].isMimeType("multipart/*")) {
                        String result = null;
                        MimeMultipart mimeMultipart = (MimeMultipart) mensajes[i].getContent();
                        result = getTextFromMimeMultipart(mimeMultipart);
                        System.out.println(result);
                        int intindex = result.indexOf(uuid.toLowerCase());
                        if (intindex >= 1) {
                            int intindex1 = result.indexOf("Comprobante obtenido satisfactoriamente.");
                            if (intindex1 >= 1) {
                                array.add("XML Correcto");
                                array.add("1");
                                break;
                            } else {
                                if (result.contains("El XML proporcionado está mal formado o es inválido.") == true) {
                                    array.add("El XML proporcionado está mal formado o es inválido.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("La versión del comprobante está fuera de vigencia.") == true) {
                                    array.add("La versión del comprobante está fuera de vigencia.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("La estructura del comprobante es incorrecta.") == true) {
                                    array.add("La estructura del comprobante es incorrecta.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El sello del emisor no es válido.") == true) {
                                    array.add("El sello del emisor no es válido.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El RFC del CSD del Emisor no corresponde al RFC que viene como Emisor en el Comprobante.") == true) {
                                    array.add("El RFC del CSD del Emisor no corresponde al RFC que viene como Emisor en el Comprobante.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El CSD del Emisor ha sido revocado.") == true) {
                                    array.add("El CSD del Emisor ha sido revocado.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("La fecha de emisión no está dentro de la vigencia del CSD del Emisor.") == true) {
                                    array.add("La fecha de emisión no está dentro de la vigencia del CSD del Emisor.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("La llave utilizada para sellar debe ser un CSD.") == true) {
                                    array.add("La llave utilizada para sellar debe ser un CSD.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El comprobante contiene un timbre previo.") == true) {
                                    array.add("El comprobante contiene un timbre previo.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El CSD del Emisor no ha sido firmado por uno de los Certificados de Autoridad de SAT.") == true) {
                                    array.add("El CSD del Emisor no ha sido firmado por uno de los Certificados de Autoridad de SAT.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El rango de la fecha de generación no debe de ser mayor a 72 horas para la emisión del timbre.") == true) {
                                    array.add("El rango de la fecha de generación no debe de ser mayor a 72 horas para la emisión del timbre.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("RFC del emisor no se encuentra en el régimen de contribuyentes (Lista de validación de régimen) LCO.") == true) {
                                    array.add("RFC del emisor no se encuentra en el régimen de contribuyentes (Lista de validación de régimen) LCO.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("La fecha de emisión del comprobante debe de ser posterior") == true) {
                                    array.add("La fecha de emisión del comprobante debe de ser posterior");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("No fue posible generar el timbre fiscal digital, por favor inténtelo más tarde, si el problema persiste contacte a soporte técnico.") == true) {
                                    array.add("La fecha de emisión del comprobante debe de ser posterior");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("No fue posible generar el timbre fiscal digital, por favor inténtelo más tarde, si el problema persiste contacte a soporte técnico.") == true) {
                                    array.add("No fue posible generar el timbre fiscal digital, por favor inténtelo más tarde, si el problema persiste contacte a soporte técnico.");
                                    array.add("0");
                                    break;
                                }
                                if (result.contains("El rfc con ese certificado no existe en la LCO") == true) {
                                    array.add(" El rfc con ese certificado no existe en la LCO.");
                                    array.add("0");
                                    break;
                                }

                                if (result.contains("No cumple con estatus del certificado 'A'.") == true) {
                                    array.add("No cumple con estatus del certificado 'A'.");
                                    array.add("0");
                                    break;
                                }

                                if (result.contains("No cumple con la fecha de Vigencia del CSD.") == true) {
                                    array.add("No cumple con la fecha de Vigencia del CSD.");
                                    array.add("0");
                                    break;
                                }

                                if (result.contains("El TipoDeComprobante NO es I,E o N, y un concepto incluye el campo descuento.") == true) {
                                    array.add("El TipoDeComprobante NO es I,E o N, y un concepto incluye el campo descuento.");
                                    array.add("0");
                                    break;
                                }

                                if (result.contains("El campo MetodoPago, no contiene un valor del catálogo c_MetodoPago.") == true) {
                                    array.add("El campo MetodoPago, no contiene un valor del catálogo c_MetodoPago.");
                                    array.add("0");
                                    break;
                                }

                                array.add("El XML esta mal.");
                                array.add("0");
                                break;

                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (i == 1) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Aun no se valida el XML con UUID: " + uuid + " por favor intentarlo de nuevo."));
                    array.clear();
                    return 2;
                } else {
                    cDao.updatexml(uuid, usu, Integer.parseInt(array.get(2).toString()), ususat, array.get(1).toString());
                }

                if (array.get(2) == "0") {
                    enviocorreo(array);
                    String usup = usu + "-x";
                    ConceptoDao cDaop = new ConceptoDaoImpl();
                    cDaop.updateConcepto(uuid, usu, ususat, usup);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "XML esta mal, se te enviara un correo con detalles."));
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Porfavor de cerrar el viaje hasta tener el XML correcto."));
                    array.clear();
                    return 0;
                }
                retorno = 1;
                array.clear();
            }

        }
        return retorno;
    }

    private static void enviocorreo(ArrayList array) throws MessagingException {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nombre");
        String correo = us.getCorreo();
        String nombre = us.getNombre();
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "portal@marubeni.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        BodyPart texto = new MimeBodyPart();
        String uuidserror = "";
        for (int i = 0; i <= array.size();) {
            if (array.get(i + 2) == "0") {
                uuidserror = uuidserror + "  El UUID: " + array.get(i) + ", Estatus: " + array.get(i + 1) + ".\n";
            }
            i = i + 3;
            if (i >= array.size()) {
                break;
            }
        }

        texto.setContent("<html><head><title></title></head>"
                + "<body>"
                + "<table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'>"
                + "<tr>"
                + "<td height='10' colspan='3' bordercolor='#FFFFFF'><img src='cid:azul' width='20%'/></td>"
                + "</tr>"
                + "<tr>"
                + "<td> Estimad@ " + nombre + " Porfavor de revisar el XML  </td>"
                + "<tr>"
                + "</tr>"
                + "<td>" + uuidserror + " </td>"
                + "<td> Por favor de volver a subir el XML incorrecto.  </td>"
                + "<tr>"
                + "</tr>"
                + "<td width='425' bordercolor='#FFFFFF'><p align='left' style='font-family:calibri; font-size:17px'><br><font color='#17202a'>Sistema de Pagos | </font><font color='#E60013'>Marubeni M&eacute;xico, S.A. de C.V.</font><br>"
                + "<a href='http://gastos.marubeni.com.mx' target='_blank'><img src='cid:image' width='45%'/></a></td>"
                + "<td width='122' bordercolor='#FFFFFF'></td>"
                + "<td width='222' rowspan='2' bordercolor='#FFFFFF'></td>"
                + "</tr>"
                + "<tr>"
                + "<td colspan='2' bordercolor='#17202a'><br><br><p align='center' style='font-family:calibri; font-size:15px'><font color='#086A87'><br> Mensaje enviado desde el Sistema de Pagos Marubeni.</font></p></td>"
                + "</tr>"
                + "</table>"
                + "</body></html>", "text/html");
        MimeMultipart multiParte = new MimeMultipart();
        BodyPart imagen = new MimeBodyPart();
        BodyPart imagen2 = new MimeBodyPart();
        DataSource fds = new FileDataSource("C:\\img\\marubeni-logo.png");
        DataSource fds1 = new FileDataSource("C:\\img\\azul.png");
        imagen.setDataHandler(new DataHandler(fds));
        imagen2.setDataHandler(new DataHandler(fds1));
        imagen.setHeader("Content-ID", "<image>");
        imagen2.setHeader("Content-ID", "<azul>");

        multiParte.addBodyPart(texto);
        multiParte.addBodyPart(imagen);
        multiParte.addBodyPart(imagen2);

        MimeMessage message = new MimeMessage(session);

// Se rellena el From
        message.setFrom(new InternetAddress("portal@marubeni.com.mx"));

//recepcion@digibox.com.mx
        message.addRecipients(Message.RecipientType.TO, correo);
        message.addRecipients(Message.RecipientType.CC, "Martinez-R@marubeni.com");
        message.addRecipients(Message.RecipientType.CC, "portal@marubeni.com.mx");

// Se rellena el subject
        message.setSubject("Sistema de Gastos Marubeni");

// Se mete el texto y la foto adjunta.
        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("portal@marubeni.com.mx", "Gastos$0914");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests 
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

}
