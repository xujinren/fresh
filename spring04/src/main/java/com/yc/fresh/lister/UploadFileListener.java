package com.yc.fresh.lister;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UploadFileListener
 *
 */
@WebListener
public class UploadFileListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public UploadFileListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
	 * ���أ����ڴ�������ͼƬ���ļ��У�������ļ��У������£����û���ļ��У��򴴽��ļ���
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    		String filePath = "pics";
    		String path = arg0.getServletContext().getInitParameter("filePath"); //��web.xml�����л�ȡ��ʼ������
    		if(path != null){
    			filePath = path; //���ó�ʼ������
    		}
    		
    		String basePath = arg0.getServletContext().getRealPath("/"); //��ȡ��Ŀ�ľ���·��
    		filePath = basePath + "../" + filePath; //����ͼƬ�ı���·��
    		File fi = new File(filePath);
    		if(!fi.exists()){//����ļ������ڣ��򴴽�
    			fi.mkdirs();
    		}
    }
}
