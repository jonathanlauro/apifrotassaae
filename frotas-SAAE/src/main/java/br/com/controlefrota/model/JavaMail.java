package br.com.controlefrota.model;

import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {

    private Session session = null;
    private Store store = null;

    public void enviarEmail(String destinatario, String assunto, String corpo) throws Exception {
        Properties props = new Properties();

        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        String remetente = "frotassaaesistem@gmail.com";
        String senha = "!@#$1234";

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente,senha);
            }
        });

        Message message = prepareMessage(session, remetente, destinatario);
        Transport.send(message);
    }
    private static Message prepareMessage(Session session,String myAccountEmail, String recipient){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
            message.setSubject("Reembolso aqui!");
            message.setText("voce foi reembolsado");
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
