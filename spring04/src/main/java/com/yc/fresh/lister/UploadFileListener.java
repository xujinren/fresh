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
	 * 拦截，用于创建保存图片的文件夹，如果有文件夹，则不做事，如果没有文件夹，则创建文件夹
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    		String filePath = "pics";
    		String path = arg0.getServletContext().getInitParameter("filePath"); //从web.xml配置中获取初始化参数
    		if(path != null){
    			filePath = path; //设置初始化参数
    		}
    		
    		String basePath = arg0.getServletContext().getRealPath("/"); //获取项目的绝对路径
    		filePath = basePath + "../" + filePath; //设置图片的保存路径
    		File fi = new File(filePath);
    		if(!fi.exists()){//如果文件不存在，则创建
    			fi.mkdirs();
    		}
    }
}
