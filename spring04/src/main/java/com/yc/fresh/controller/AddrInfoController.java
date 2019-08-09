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
	 * ��ӵ�ַ�ķ���
	 * @param session
	 * @param af
	 * @return
	 */
	@RequestMapping("/add")
	public int add(HttpSession session, AddrInfo af){
		//��У���û��Ƿ��¼����ʵ����ҪУ�飬��Ϊû��¼���û�ѹ��������
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
	 * ����Ĭ�ϵ�ַ�ķ���
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
	 * ��ѯ��Ӧ�ĵ�ַ��Ϣ
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