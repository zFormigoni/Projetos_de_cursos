package enviando_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarDireto {
	
	private static String email = "testejava2003@gmail.com";
	private static String senha = "joZtfo,}9|<x";
	
	public static void main(String[] args) throws Exception {		
		
		try {
			
			Properties properties = new Properties();
			
			
			properties.put("mail.smtp.ssl.trust" , "*" ); 											
			properties.put("mail.smtp.auth" , "true" ); 											//	autenticaçao
			properties.put("mail.smtp.starttls", "true" ); 											//	autorizaçao
			properties.put("mail.smtp.host", "smtp.gmail.com" );									// 	servidor gmail do google
			properties.put("mail.smtp.port" , "465" ); 												//	porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465" ); 								//	Especifica a porta a ser conectada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory" ); 	//	classe socket de conexao ao smtp
		
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email, senha);
				}
			});
		
			Address [] toUser = InternetAddress.parse("testejava2003@gmail.com, vitor.formigoni@gmail.com, vitorformigoni2003@gmail.com");
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email, "java -teste"));		//	Quem está enviando o email, apos a virgula mostra o nome de quem enviou o email
			message.setRecipients(Message.RecipientType.TO, toUser);	// 	Email de destino
			message.setSubject("assunto_email");							// 	Assunto do email
			message.setText("corpo_email");								//	corpo do email
			Transport.send(message);									//	enviar email	
		} catch (Exception e) {		}
		System.out.println("enviado");
	}    
}
