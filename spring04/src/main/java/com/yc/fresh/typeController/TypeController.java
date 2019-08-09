package com.yc.fresh.typeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fresh.Service.IGoodsTypeService;
import com.yc.fresh.entiry.GoodsType;

@Service
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private IGoodsTypeService service;
	
	@RequestMapping("/findAll")
	@ResponseBody
	public List<GoodsType> findAll(){
		return service.findAll();
	}
}
