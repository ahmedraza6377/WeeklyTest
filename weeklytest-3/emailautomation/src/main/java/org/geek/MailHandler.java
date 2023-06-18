package org.geek;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailHandler {

   public void sendMail(String str){
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
            mailMsg.setSubject("this is my mail using java");
            mailMsg.setText(str);

            Address revermail = new InternetAddress(Mailmetadata.recMail);
            mailMsg.setRecipient(Message.RecipientType.TO, new InternetAddress(Mailmetadata.recMail));
    Transport.send(mailMsg);
        }catch(Exception e){
System.out.println(e.toString());
        }
    }
}
