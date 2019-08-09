package com.yc.fresh.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.Service.MemberInfoService;
import com.yc.fresh.entiry.MenberInfo;
import com.yc.fresh.util.SendMailUtil;

@Controller
@RequestMapping("/regist")
@ResponseBody
public class RegistController {
	@Autowired
	SendMailUtil send ;
	@Autowired
	private MemberInfoService mservice;
	
	
	@RequestMapping("/code")
	public int sendMail(String name, String email, HttpSession session){
		Random rd = new Random();
		StringBuffer buffer = new StringBuffer("");
		while(buffer.length() <= 5){
			buffer.append(rd.nextInt(10));
		}
		boolean temp = false ;
		try {
			/*send.setPwd("qvikeeyrkvnngadi");
			send.setUserName("1417734497@qq.com");*/
			 temp = send.sendHtmlMail(email, name, buffer.toString());
			 session.setAttribute("yzm", buffer.toString());
			 //¶¨Ê±Æ÷
			 Timer time = new Timer();
			 TimerTask task = new TimerTask() {
				@Override
				public void run() {
					session.removeAttribute("yzm");
					time.cancel();
				}
			};
			 time.schedule(task, 180 * 1000);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		if(temp){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	@RequestMapping("/login")
	public int Login(String nickname, String pwd, HttpSession session){
		System.out.println("nickname :" + nickname);
		System.out.println("pwd :" + pwd);
		MenberInfo men =  mservice.login(nickname, pwd);
		if(men != null){
			session.setAttribute("currentUser", men);
			return 1;
		}
		return -1;
	}
	
	@RequestMapping("/reg")
	public int reg(MenberInfo men, HttpSession session){
		if(session.getAttribute("yzm").equals(men.getRealName())){
			return mservice.addInfo(men);
		}else{
			return -1;
		}
	}
	
	@RequestMapping("/getinfo")
	public MenberInfo getInfo(HttpSession session){
		Object obj = session.getAttribute("currentUser");
		if(obj == null){
			return new MenberInfo();
		}
		return (MenberInfo) obj;
	}
}
