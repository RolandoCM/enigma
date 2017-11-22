/*
 * clase que define metodos sobrecargados para enviar diferentes tipos de email
  * unicast, multicast, broadcast asi como email con archivos adjuntos
 */
package service.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author rolando
 */
public class Email {
    private static final String FROM = "sigecu0";
    private static final String PASSWORD = "proyectosigecu";
    
    /*metodo estatico para enviar correo a un destinatario
    * */
    public static void send(String toMail, String subject, String body) throws AddressException, MessagingException
    {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", FROM);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(FROM));

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));

        message.setSubject(subject);
        message.setText(body);
        try (Transport transport = session.getTransport("smtp")) {
            transport.connect(host, FROM, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
        }
    }  //fin del metodo
    
    /* metodo para enviar email a mas de un destinatario*/
     public static void send(List<String> toMail, String subject, String body) throws AddressException, MessagingException
    {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", FROM);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
       
        message.setFrom(new InternetAddress(FROM));
        List<InternetAddress> toAddress = new ArrayList<>();
        
        
        for (String to : toMail) {
            toAddress.add(new InternetAddress(to));
        }
        for(InternetAddress mail: toAddress)
        {
            message.addRecipient(Message.RecipientType.TO, mail);
        }
        message.setSubject(subject);
        message.setText(body);
        try (Transport transport = session.getTransport("smtp")) {
            transport.connect(host, FROM, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
        }
    }//fin del metodo send
}

