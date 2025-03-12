
package mx.util;

import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class EnviarCorreoToken {
    
    public static void correoToken(String correo, String token) throws MessagingException{
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "portal@marubeni.com.mx");
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props, null);
        session.setDebug(true);
        BodyPart texto = new MimeBodyPart();
        texto.setContent("<html><head></head><body><table style='border: 1px solid #dededf; height: 20px; width: 300px; table-layout: fixed; border-collapse: collapse; border-spacing: 1px; text-align: center;'><br> </br>"
                + "<caption style='caption-side: top; text-align: center; font-size: 20px;'>Su token es:</caption><thead>"
                + "<tr>"
                + "<th style='border: 1px solid #dededf; background-color: #dededf; color: #000000; padding: 5px; font-size: 30px;'>"+ token +"</th>"
                + "</tr></thead></table><br></br><br></br>"
                + "<p>Mensaje enviado desde el Sistema de Gastos</p>"
                + "</body></html>", "text/html");

        MimeMultipart multiParte = new MimeMultipart();


        multiParte.addBodyPart(texto);


        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress("portal@marubeni.com.mx"));

        message.addRecipients(Message.RecipientType.TO, correo);

        message.setSubject("Marubeni México");

        message.setContent(multiParte);

        Transport t = session.getTransport("smtp");
        t.connect("portal@marubeni.com.mx", "2023Sgyc$1959");//2023Sgyc$1959
        t.sendMessage(message, message.getAllRecipients());
  
        t.close();
    }
}
