package br.com.controlefrota.model;

import com.sun.mail.pop3.POP3SSLStore;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMail {

    private Session session = null;
    private Store store = null;

    public void enviarEmail(String destinatario, String assunto, String corpo) throws MessagingException {
        String remetente = "frotassaaesistem@gmail.com";
        String senha = "!@#$1234";

        Properties props = new Properties();
        props.put("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.pop3.socketFactory.fallback", "false");
        props.put("mail.pop3.port",  "995");
        props.put("mail.pop3.socketFactory.port", "995");

        URLName url = new URLName("pop3", "pop.gmail.com", 995, "",
                remetente, senha);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("frotassaaesistem@gmail.com", "!@#$1234");
            }
        });
        session.setDebug(true);
        store = new POP3SSLStore(session, url);
        store.connect();


        try{

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(remetente));
            msg.setRecipients(Message.RecipientType.TO, destinatario);
            msg.setSubject(assunto);
            msg.setText(corpo);

//            Transport t = session.getTransport("smtp");
//            t.connect("smtp.gmail.com",587,"frotassaaesistem@gmail.com","!@#$1234");
//            t.sendMessage(msg, msg.getAllRecipients());
//            t.close();



            Transport.send(msg);
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
