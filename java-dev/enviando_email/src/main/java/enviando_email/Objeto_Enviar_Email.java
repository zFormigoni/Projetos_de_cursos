package enviando_email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class Objeto_Enviar_Email {
	private static String email = "testejava2003@gmail.com";
	private static String senha = "joZtfo,}9|<x";
	
	String assunto_email = "";
	String texto_email = "";
	String remetente = "";
	String lista_Destino = "";
	
	public  Objeto_Enviar_Email(String assunto, String remetente, String listaDestino, String textoEmail) {
	this.assunto_email = assunto;
	this.texto_email = textoEmail;
	this.remetente = remetente;
	this.lista_Destino = listaDestino;
		
	}
	
	public void enviar_email(boolean EnvioHTML) throws Exception{	
		
// olhar as configuragoes do smtp do email
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
		
			Address [] toUser = InternetAddress.parse(lista_Destino);
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email, remetente));		//	Quem está enviando o email, apos a virgula mostra o nome de quem enviou o email
			message.setRecipients(Message.RecipientType.TO, toUser);	// 	Email de destino
			message.setSubject(assunto_email);							// 	Assunto do email
			
			if (EnvioHTML == true) {
				message.setContent(texto_email, "text/html; charset=utf-8");								//	corpo do email
				
			}else {
				message.setText(texto_email);								//	corpo do email	
			}
			
			
			
			Transport.send(message);									//	enviar email	
	}
	
	public void enviar_email_anexo(boolean EnvioHTML) throws Exception{	
		
		// olhar as configuragoes do smtp do email
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
				
					Address [] toUser = InternetAddress.parse(lista_Destino);
					
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(email, remetente));		//	Quem está enviando o email, apos a virgula mostra o nome de quem enviou o email
					message.setRecipients(Message.RecipientType.TO, toUser);	// 	Email de destino
					message.setSubject(assunto_email);							// 	Assunto do email
					
					MimeBodyPart corpoEmail = new MimeBodyPart();

					if (EnvioHTML == true) {
						corpoEmail.setContent(texto_email, "text/html; charset=utf-8");								//	texto do email
						
					}else {
						corpoEmail.setText(texto_email);								//	texto do email	
					}
					
					
					MimeBodyPart anexo_email = new MimeBodyPart();	//anexo do email em pdf
					
					
					anexo_email.setDataHandler(new DataHandler(new ByteArrayDataSource(simularPDF(), "application/pdf")));	//aqui entraria o arquivo salvo do banco de daodos
					anexo_email.setFileName("arquivo.pdf");

					Multipart multipart = new MimeMultipart();		//aqui vai juntar o corpo do email com o anexo
					multipart.addBodyPart(corpoEmail);
					multipart.addBodyPart(anexo_email);

					message.setContent(multipart);

					Transport.send(message);									//	enviar email	
			}
			

	public void enviar_email_lista_anexo(boolean EnvioHTML) throws Exception{	
		
		// olhar as configuragoes do smtp do email
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
				
					Address [] toUser = InternetAddress.parse(lista_Destino);
					
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress(email, remetente));		//	Quem está enviando o email, apos a virgula mostra o nome de quem enviou o email
					message.setRecipients(Message.RecipientType.TO, toUser);	// 	Email de destino
					message.setSubject(assunto_email);							// 	Assunto do email
					
					MimeBodyPart corpoEmail = new MimeBodyPart();

					if (EnvioHTML == true) {
						corpoEmail.setContent(texto_email, "text/html; charset=utf-8");								//	texto do email
						
					}else {
						corpoEmail.setText(texto_email);								//	texto do email	
					}
					
					//criando lista da arquivos 
					List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
					arquivos.add(simularPDF());	//	aqui o arquivo entra para a lista,
					arquivos.add(simularPDF());	//	poderiam ser diversos arquivos diferentes
					arquivos.add(simularPDF());	//	como imagens, documentos de um banco de dados 
					arquivos.add(simularPDF());	//	entre outros
					
					
					Multipart multipart = new MimeMultipart();		//aqui vai juntar o corpo do email com o anexo
					multipart.addBodyPart(corpoEmail);
					int index = 0;
					
					for (FileInputStream fileInputStream : arquivos) {
						index++;
						MimeBodyPart anexo_email = new MimeBodyPart();	//anexo do email em pdf
						anexo_email.setDataHandler(new DataHandler(new ByteArrayDataSource(simularPDF(), "application/pdf")));	//aqui entraria o arquivo salvo do banco de daodos
						anexo_email.setFileName("arquivo"+ index +".pdf");
						
						multipart.addBodyPart(anexo_email);
	
					}
					message.setContent(multipart);

					Transport.send(message);									//	enviar email	
			}

	private FileInputStream simularPDF() throws Exception {
	/*
	esse metodo simula o pdf ou qualquer outro arquivo que possa ser enviado como anexo no email
	retorna um pdf em branco somente com o paragrafo de teste nele
	*/ 
		Document document = new Document();
		File file = new File("Arquivo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("PDF criado em java e enviado como anexo"));
		document.close();
		return new FileInputStream(file);

	}
	
}
