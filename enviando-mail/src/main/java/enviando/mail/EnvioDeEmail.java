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

public class EnvioDeEmail {

	private final String username = "limaismael8901@gmail.com";
	private final String password = "lyjk ukqp xrvr ksyg";
	private final String messagemDeEnvio = "Mensagem enviada";
	
	private String assuntoMail;
	private String conteudo;
	private String tituloEnvio;
	private String listaDestinatario;

	
	public EnvioDeEmail(String assuntoMail, String conteudo, String tituloEnvio, String listaDestinatario) {
		this.assuntoMail = assuntoMail;
		this.conteudo = conteudo;
		this.tituloEnvio = tituloEnvio;
		this.listaDestinatario = listaDestinatario;
	}

	public String EnviarEmail() {
		
		try {
			
			Properties properties = new Properties();
			
			properties.put("mail.smtp.ssl.trust", "*"); //Autenticar com segurança ssl
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
			
			Address[] toUser = InternetAddress.parse(listaDestinatario);
			
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(username, tituloEnvio)); //Quem esta enviando
			message.setRecipients(Message.RecipientType.TO, toUser);/*Email de destino*/
			message.setSubject(assuntoMail);/*Assunto do e-mail*/
			message.setText(conteudo);
			
			
			Transport.send(message);
					
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				return messagemDeEnvio;
			}
	}
}
