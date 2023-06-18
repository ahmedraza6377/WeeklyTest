package com.ahmd.ahmedraza;


import org.geek.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    //autowire will basically act as a connector and will help refernce variable connect to object of same type
    @Autowired
    public Car myObject;


//    public static Sub email;

    //getmapping will be search for get type of search on post man and basically will get the output for us
    @GetMapping("objects")
    public String getObjects() {
        // Use the created objects
        String myObjectAsString = myObject.toString();

        // Send the objects as strings via email
//        email.setsub(myObjectAsString);

        MailHandler MailHandler = new MailHandler();

        MailHandler.sendMail(myObjectAsString);
        return myObjectAsString;
    }
}