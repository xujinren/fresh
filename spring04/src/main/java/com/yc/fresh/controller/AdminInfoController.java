package com.yc.fresh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.Service.IAdminInfoService;
import com.yc.fresh.entiry.AdminInfo;

@Controller
@RequestMapping("/back")
public class AdminInfoController {
	
	@Autowired
	private IAdminInfoService service;
	
	@RequestMapping("/login")
	@ResponseBody
	public int login(AdminInfo af, HttpSession session){
		AdminInfo adminInfo = service.login(af);
		if(adminInfo == null){
			return 0;
		}
		session.setAttribute("currentAdminInfo", adminInfo);
		return 1;
	}
	
	@RequestMapping("/tomanager")
	public String successLogin(){
		return "index";
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public int add(AdminInfo as){
		
		if(as == null){
			return -1;
		}
		return service.add(as);
	}
	
	

	@RequestMapping("/findAll01")
	@ResponseBody
	public List<AdminInfo> findAll01(){
		return service.findAll();	
	}
	
	
	@RequestMapping("/rechongzhi")
	@ResponseBody
	public int  rechongzhi(int aid){
		return service.updatPwd(aid);
	}
}
