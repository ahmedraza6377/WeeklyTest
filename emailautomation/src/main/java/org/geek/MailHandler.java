package org.geek;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
    void sendMail(){
        Properties sysProp = System.getProperties();

        System.out.println(sysProp);

        sysProp.put("mail.smtp.host",Mailmetadata.HostServer);
        sysProp.put("mail.smtp.port",Mailmetadata.port);
        sysProp.put(Mailmetadata.sslprop,"True");
        sysProp.put(Mailmetadata.authperm,"True");
        Authenticator mailAuthentication=new UserAuthentication();
        Session session=Session.getInstance(sysProp,mailAuthentication);
try{
            MimeMessage mailMsg = new MimeMessage(session);

            mailMsg.setFrom(Mailmetadata.Usermail);
            mailMsg.setSubject("this is my first mail using java");
            mailMsg.setText("hy this java using mail");

            Address revermail = new InternetAddress(Mailmetadata.recMail);
            mailMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(Mailmetadata.recMail));
    Transport.send(mailMsg);
        }catch(Exception e){
System.out.println(e.toString());
        }
    }
}
