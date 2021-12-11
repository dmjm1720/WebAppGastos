package mx.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;

public class correodigibox {

    private Calendar hoy;
    private int dia;
    private int mes;
    private int año;
    //private final String path = "C:\\xampp\\htdocs\\files";

    public void correo(String filename) throws MessagingException {
        // C:\xampp\htdocs\files

        this.hoy = Calendar.getInstance();
        this.dia = this.hoy.get(Calendar.DAY_OF_WEEK);
        this.hoy.add(Calendar.DATE, 10);
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MMMM-yyyy");//Formato para fecha en Español-España SQL Server 2012

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "portal@marubeni.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(false);
        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head><title></title></head>"
                + "<body>"
                + "<table width='678' height='315' border='0' bordercolor='#0000FF' bgcolor='#FFFFFF'>"
                + "<tr>"
                + "<td height='10' colspan='3' bordercolor='#FFFFFF'><img src='cid:azul' width='20%'/></td>"
                + "</tr>"
                + "<tr>"
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
        BodyPart adjunto = new MimeBodyPart();

        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
        String path = ctx.getRealPath("/") + "/resources/upload/";

        adjunto.setDataHandler(new DataHandler(new FileDataSource(path + filename)));
        adjunto.setFileName("Factura.xml");

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
        multiParte.addBodyPart(adjunto);
        multiParte.addBodyPart(imagen);
        multiParte.addBodyPart(imagen2);

        MimeMessage message = new MimeMessage(session);

// Se rellena el From
        message.setFrom(new InternetAddress("portal@marubeni.com.mx"));


        message.addRecipients(Message.RecipientType.TO, "recepcion@digibox.com.mx");
        message.addRecipients(Message.RecipientType.TO, "portal@marubeni.com.mx");


// Se rellena el subject
        message.setSubject("Sistema de Gastos Marubeni");

// Se mete el texto y la foto adjunta.
        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("portal@marubeni.com.mx", "Gastos$0912");
        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }
}
