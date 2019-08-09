package com.yc.fresh.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.fresh.Service.IGoodsInfoService;
import com.yc.fresh.entiry.GoodsInfo;

@Controller
@RequestMapping("/goods")
@ResponseBody
public class GoodsInfoController {

	@Autowired
	private IGoodsInfoService service;
	
	
	
	private String savePath = "pics";

	/**
	 * �������������ϴ��ļ�
	 * @param pic
	 * @param request
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody                                       //MultipartFile��spring�ж��ļ��ϴ�����   ��@RequestParam("upload")MultipartFile pic��������������
	public Map<String, Object> upload(@RequestParam("upload")MultipartFile pic, HttpServletRequest request){

		Map<String ,Object> map = new HashMap<String ,Object>();

		if(!pic.isEmpty()){
			try {
				String path = request.getServletContext().getRealPath("");//��ȡ��Ŀ�ľ���·����
				String temp = request.getServletContext().getInitParameter("filePath");//��ȡxml�еĳ�ʼ������
				if(temp != null){
					savePath = temp;
				}
				savePath += "/" + new Date().getTime() + "_ "+ pic.getOriginalFilename(); //�ļ��ı���·���ĺ���һ��
				File dest = new File(new File(path).getParentFile(), savePath);//�����ļ�
				pic.transferTo(dest); //��ͼƬ���浽��������
				map.put("fileName", pic.getOriginalFilename());
				map.put("uploaded", 1);
				map.put("url", "../../../" + savePath); //�ӵ�ǰҳ����������������Ӧ��ҳ��
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public int add(@RequestParam("upload")MultipartFile pic, HttpServletRequest request, GoodsInfo gf){

		Map<String ,Object> map = new HashMap<String ,Object>();

		if(!pic.isEmpty()){
			try {
				String path = request.getServletContext().getRealPath("");//��ȡ��Ŀ�ľ���·����
				String temp = request.getServletContext().getInitParameter("filePath");//��ȡxml�еĳ�ʼ������
				if(temp != null){
					savePath = temp;
				}
				savePath += "/" + new Date().getTime() + "_ "+ pic.getOriginalFilename(); //�ļ��ı���·���ĺ���һ��
				File dest = new File(new File(path).getParentFile(), savePath);//�����ļ�
				pic.transferTo(dest); //��ͼƬ���浽��������
				map.put("fileName", pic.getOriginalFilename());
				map.put("uploaded", 1);
				map.put("url", "../../../" + savePath); //�ӵ�ǰҳ����������������Ӧ��ҳ��
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}	
			
		}
		return service.add(gf);
	}

	@RequestMapping("finds")
	public Map<String, Object> finds(){
		return service.finds();
	}
	
	@RequestMapping("findByFirst")
	public Map<String, Object> findByFirst(String tno, String page, String rows){
		//��һ�β�ѯ��Ҫ��ȡ����
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("tno", Integer.parseInt(tno));
		map2.put("page", Integer.parseInt(page));
		map2.put("rows", Integer.parseInt(rows));
		List<GoodsInfo> list1 =service.findByType(map2);
		map.put("total", service.ftotal(Integer.parseInt(tno)));
		map.put("goods", list1);
		
		return map;
	}
	@RequestMapping("findByPage")
	public List<GoodsInfo> findBypage(String tno,String page, String rows){
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("tno", Integer.parseInt(tno));
		map2.put("page", Integer.parseInt(page));
		map2.put("rows", Integer.parseInt(rows));
		List<GoodsInfo> list1 =service.findByType(map2);
		return list1;
	}
	
}