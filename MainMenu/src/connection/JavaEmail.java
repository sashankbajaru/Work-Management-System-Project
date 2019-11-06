package connection;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import worker.Worker;
import Jobs.Job;
public class JavaEmail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
        Worker worker;
        Job job;

       

	public JavaEmail(Worker worker, Job job) {

		String emailPort = "587";//gmail's smtp port
                this.worker = worker;
                this.job = job;
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}

	public void createEmailMessage() 
        {		try{
		String[] toEmails = { worker.getEmailID() };
		String emailSubject = "Job Assignment";
		String emailBody = "Greetings "+worker.getName()+",\nYou have to come at location \nLatitude - "+job.getLatitude()+"\nLongitude - "+job.getLongitude()+"\nThe description of the job (as provided) is : \n"+job.getJobDescription()
                        +"\n\nThis is system generated message. Please don't reply!\n\nFrom\nWork Management System";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");//for a html email
		//emailMessage.setText(emailBody);// for a text email
            }
        catch(Exception e)
        {}

	}

	public void sendEmail()
        {
            try{
		String emailHost = "smtp.gmail.com";
		String fromUser = "testdewang@gmail.com";//just the id alone without @gmail.com
		String fromUserEmailPassword = "quick#brown#fox";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
            }
            catch(Exception e)
            {}
	}

}