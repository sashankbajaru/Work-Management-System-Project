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
public class TestEmail {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
        Worker worker;
        Job job;

       

	public TestEmail(Worker worker, Job job) {

		String emailPort = "587";//gmail's smtp port
                this.worker = worker;
                this.job = job;
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");

	}

	public void createEmailMessage() throws AddressException,
			MessagingException {
		String[] toEmails = { "mailtodewang@gmail.com" };
		String emailSubject = "Job Assignment";
		String emailBody = "Greetings "+"Dewang"+",\nYou have to come at location \nLatitude - "+"25"+"\nLongitude - "+"75"+"\nThe description of the job (as provided) is : \n"+"None"
                        +"\n\nThis is system generated message. Please don't reply!";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		for (int i = 0; i < toEmails.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
		}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");//for a html email
		//emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "testdewang@gmail.com";//just the id alone without @gmail.com
		String fromUserEmailPassword = "quick#brown#fox";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}
        
        public static void main(String[] args)
        {
            TestEmail test = new TestEmail(new Worker(),new Job());
            try{
            test.createEmailMessage();
            test.sendEmail();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
}