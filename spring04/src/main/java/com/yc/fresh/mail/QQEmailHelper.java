package com.yc.fresh.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class QQEmailHelper {
	
	//��ʼ������
	public QQEmailHelper(){
		 //������ǰ��׼������  Ҳ���ǲ�����ʼ��
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host","smtp.qq.com");//�������������
        properties.setProperty("mail.smtp.port","465");//���Ͷ˿�
        properties.setProperty("mail.smtp.auth","true");//�Ƿ���Ȩ�޿���
        properties.setProperty("mail.debug","true");//true ��ӡ��Ϣ������̨
        properties.setProperty("mail.transport","smtp");//���͵�Э���Ǽ򵥵��ʼ�����Э��
        properties.setProperty("mail.smtp.ssl.enable","true");
        
        //�������ߵ�����
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1417734497@qq.com","qvikeeyrkvnngadi");
            }
        });

        //�����ʼ�����
        Message message = new MimeMessage(session);
        //���÷�����
        try {
            message.setFrom(new InternetAddress("1417734497@qq.com"));

        //�����ռ���
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("1417734497@qq.com"));//�ռ���
        //��������
        message.setSubject("��֤��");
        //�����ʼ�����  �ڶ����������ʼ����͵�����
        message.setContent("2569658","text/html;charset=UTF-8");
        //����һ���ʼ�
            Transport transport = session.getTransport();
            transport.connect("1417734497@qq.com","qvikeeyrkvnngadi");
            Transport.send(message);
            System.out.println("ִ�����");
    } catch (MessagingException e) {
        e.printStackTrace();
    }finally {

        }

		
	}
	
	
	public static void main(String[] args) {
		QQEmailHelper qqe = new QQEmailHelper();
	}
	
}
