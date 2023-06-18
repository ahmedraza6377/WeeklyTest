package org.geek;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class UserAuthentication extends Authenticator {
   protected PasswordAuthentication getPasswordAuthentication(){
       return new PasswordAuthentication(Mailmetadata.Usermail,Mailmetadata.Pass);
   }
}
