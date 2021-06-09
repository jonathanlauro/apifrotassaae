package br.com.controlefrota.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {


    public void enviarEmail(String destinatario, String assunto, String corpo) throws MessagingException {
        String remetente = "frotassaaesistem@gmail.com";
        String senha = "!@#$1234";

        Properties props = new Properties();
        props.put("email.smtp.protocol","smtp");
        props.put("email.host","smtp.gmail.com");
        props.put("email.smtp.auth","true");
        props.put("email.smtp.port","587");
        props.put("email.smtp.user",remetente);
        props.put("email.smtp.starttls.enable","true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente,senha);
            }
        });
        try{

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(remetente));
            msg.setRecipients(Message.RecipientType.TO, destinatario);
            msg.setSubject(assunto);
            msg.setText(corpo);

            Transport t = session.getTransport("smtp");
            t.connect("smtp.gmail.com","frotassaaesistem@gmail.com","!@#$1234");
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();



//            Transport.send(msg);
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
