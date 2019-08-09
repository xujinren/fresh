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
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;
import com.yc.fresh.entiry.MenberInfo;
import com.yc.fresh.impl.CartInfoServiceImpl;
@Controller
@RequestMapping("/cart")
@ResponseBody
public class CartInfoController {
	
	@Autowired
	private CartInfoServiceImpl service;
	
	@RequestMapping("join")
	public int join(int gno, HttpSession session){
		Object obj = session.getAttribute("currentUser");
		if(obj == null){ //说明没有登录
			return -1;
		}else{  //如果登录了，
			//在添加数据前要判断是否已有此商品的信息，如果有，则num加1
			MenberInfo men = (MenberInfo) obj;
			CartInfo re = service.findByMnoAndGno(men.getMno(), gno);
			if(re != null){
				int cno = re.getCno();
				CartInfo rf2 = new CartInfo();
				rf2.setCno(cno);
				rf2.setNum(1);
				System.out.println("a1");
				return service.update(rf2);
			}else{
				CartInfo cf = new CartInfo();
				
				cf.setGno(gno);
				cf.setMno(men.getMno());
				cf.setNum(1);
				int result = 0;
				result = service.add(cf);
				return result;
			}
		
		}
	}
	
	@RequestMapping("findAll")
	public List<CartInfo> findAll(HttpSession session){
		List<CartInfo> cs = new ArrayList<CartInfo>();
		MenberInfo men = (MenberInfo) session.getAttribute("currentUser");
		cs = service.findByMno(men.getMno());
		return cs;
	}
	
	@RequestMapping("delete01")
	public int delete01(int cno){
		int[] arr = new int[]{cno};
		 return service.delete(arr);
	}
	
	@RequestMapping("update02")
	public int update02(int cno, int num){
		CartInfo cf = new CartInfo();
		cf.setCno(cno);
		cf.setNum(num);
		return service.update(cf);
	}
	
	@RequestMapping("findCountCno")
	public int findCountCno(HttpSession session){
		int mno = ((MenberInfo)session.getAttribute("currentUser")).getMno();
		return service.findCountCno(mno);
	}
	
	
	@RequestMapping("findByCno03")
	public List<CartInfo> findByCno03(String cno, HttpSession session){
		String[] cnos = cno.split(",");
		return  service.findByCno03(cnos);
	}
}