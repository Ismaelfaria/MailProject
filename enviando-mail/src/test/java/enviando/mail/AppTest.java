package enviando.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private final String username = "limaismael8901@gmail.com";
	private final String password = "lyjk ukqp xrvr ksyg";
	
	@org.junit.Test
    public void testMail() {
    	
		
		try {
			
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true"); //Autorização
		properties.put("mail.smtp.starttls", "true"); //Authenticação
		properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor do Gmail
		properties.put("mail.smtp.port", "465"); //Porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465"); //Especificar a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Classe socket de conexão ao SMTP
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		Address[] toUser = InternetAddress.parse("limaismael4444@gmail.com, devprogramador53@gmail.com");
		
		Message message = new MimeMessage(session);
		
		message.setFrom(new InternetAddress(username)); //Quem esta enviando
		message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
		message.setSubject("Chegou e-mail enviado com java");/*Assunto do e-mail*/
		message.setText("Olá programador, vc acaba de receber um e-mail enviado com Java do curso Formação Java Web do Alex");
		
		
		Transport.send(message);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
    }
}
