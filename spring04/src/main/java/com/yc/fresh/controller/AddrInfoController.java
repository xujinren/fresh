package com.yc.fresh.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.fresh.Service.IGoodsInfoService;
import com.yc.fresh.entiry.AddrInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;
import com.yc.fresh.entiry.MenberInfo;
import com.yc.fresh.impl.AddrInfoServiceImpl;
import com.yc.fresh.impl.CartInfoServiceImpl;
@Controller
@RequestMapping("/addr")
@ResponseBody
public class AddrInfoController {
	
	@Autowired
	private AddrInfoServiceImpl service;
	
	
	/**
	 * 添加地址的方法
	 * @param session
	 * @param af
	 * @return
	 */
	@RequestMapping("/add")
	public int add(HttpSession session, AddrInfo af){
		//先校验用户是否登录，其实不需要校验，因为没登录的用户压根进不来
		Object obj = session.getAttribute("currentUser");
		if(obj == null){
			return -2;
		}
		MenberInfo mf = (MenberInfo)obj;
		af.setMno(mf.getMno());
		System.out.println(af);
		
		return service.add(af);
	}
	
	
	
	/**
	 * 更新默认地址的方法
	 * @param addrs
	 * @return
	 */
	@RequestMapping("/update")
	public int update(String addrs){
		
		if(addrs == null || "".equals(addrs)){
			return -2;
		}
		return service.update(addrs.split(","));
	}
	
	
	/**
	 * 查询对应的地址信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/findByMno")
	public List<AddrInfo> findByMno(HttpSession session){
		Object obj = session.getAttribute("currentUser");
		if(obj == null){
			return null;
		}
		MenberInfo men = (MenberInfo) obj;
		return service.findByMno(men.getMno());
	}
}