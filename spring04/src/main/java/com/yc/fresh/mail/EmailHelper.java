package com.yc.fresh.mail;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class EmailHelper {
	private static final ResourceBundle bunlde = ResourceBundle.getBundle("mail");
	private static final  String sendFrom =bunlde.getString("email.host");
	private static final  String username =bunlde.getString("username");
	private static final  String password =bunlde.getString("password");
	private static final  String host =bunlde.getString("email.host");
	
	
	public static void sendMessage(String someone, String subObject, String content){
		
		System.out.println(username);
		System.out.println(password);
		Properties properties = new Properties();
		properties.setProperty("mail.host", host);
		properties.setProperty("mail.smtp.auth", "true");
		
		Authenticator authenticator  = new Authenticator (){
			
			@Override
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
			
		};
		Session session = Session.getDefaultInstance(properties,authenticator);
		session.setDebug(true);
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(sendFrom));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(someone));
			message.setSubject(subObject);
			message.setContent(content, "text/html;charset=utf-8");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EmailHelper.sendMessage("1417734497@qq.com", "测试", "测试");
	}
}
