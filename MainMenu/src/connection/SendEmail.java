/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author dewang
 */
// Java program to send email 
import Jobs.Job;
import worker.Worker;
import java.security.Security;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail 
{ 

public static void sendMail(String emailID, Job assigned,Worker newbie) {

    final String username = "testdewang@gmail.com";
    final String password = "quick#brown#fox";
    
//    System.setProperty("mail.https.proxyHost", "172.16.2.30");
//    System.setProperty("mail.https.proxyPort", "8080");

    Properties props = System.getProperties();
    props.setProperty("mail.socks.host", "localhost");
    props.setProperty("mail.socks.port", "8085");
    props.put("mail.smtp.auth", "true");
    props.put("mail.debug", "true");
    props.put("mail.store.protocol", "pop3");
    props.put("mail.transport.protocol", "smtp");   
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
    try {
        System.out.println(new InternetAddress(username));
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("WorkManagementSystem@gmail.com"));
        //message.setRecipient(new InternetAddress("bajarusashank@gmail.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("mailtodewang@gmail.com"));
        message.setSubject("Work Assignment");
       // message.setText("Dear "+newbie.getName()
         //       + "\nYou have been assigned to a work.\nPlease reach at location\nLatitude - "+assigned.getLatitude()+"\nLongitude - "+assigned.getLongitude()
           //      +"The Description of the job(as provided) is : \n"+assigned.getJobDescription()+"\nPlease be there on time."+
             //            "\n\nThis is system generated mail. Please do not reply to it!");
        message.setText("Yo");
        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}

    public static void main(String[] args)
    {
        sendMail("mailtodewang@gmail.com",new Job(),new Worker());
    }
} 

/*
public class SendEmail
{
    public static void main(String[] args)
    {
        Email email = EmailBuilder.startingBlank()
    .from("Awesome Man", "mailtodewang@gmail.com")
    .to("me", "mailtodewang@rediffmail.com")
    .withSubject("Yo Boy!")
    .withPlainText("HAHAHA!!!!")
    .buildEmail();

MailerBuilder
  .withSMTPServer("smtp.gmail.com",465, "testdewang@gmail.com", "quick#brown#fox")
  .withTransportStrategy(TransportStrategy.SMTPS)
  //.withProxy("172.16.2.30", 8080)
  .withDebugLogging(true)
  .buildMailer()
  .sendMail(email);
   
    }
}
*/