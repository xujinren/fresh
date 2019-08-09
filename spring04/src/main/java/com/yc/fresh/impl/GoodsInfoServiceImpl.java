package com.yc.fresh.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.Service.IGoodsInfoService;
import com.yc.fresh.entiry.GoodsInfo;
import com.yc.fresh.entiry.GoodsType;
import com.yc.fresh.mapper.GoodsInfoMapper;
import com.yc.fresh.mapper.GoodsTypeMapper;


@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService {
	@Autowired
	private GoodsInfoMapper infoMapper;

	@Autowired
	private GoodsTypeMapper typeMapper;
	
	@Override
	public int add(GoodsInfo goodsInfo) {
		
		return infoMapper.add(goodsInfo);
	}

	@Override
	public GoodsInfo findByGno(int gno) {
		
		return infoMapper.findByGno(gno);
	}

	@Override
	public List<GoodsInfo> findByType(Map<String, Integer> map) {
		int page = map.get("page");
		int rows = map.get("rows");
		map.put("page", (page - 1) * rows);
		return infoMapper.findByType(map);
	}

	@Override
	public Map<String, Object> finds() {
		
		//准备每种类型的前三条数据
		List<GoodsInfo> goods = infoMapper.finds();
		
		//所有商品类型
		List<GoodsType> types = typeMapper.findAll();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("types", types);
		map.put("goods", goods);
		
		return map;
	}

	@Override
	public int ftotal(int tno) {
		return infoMapper.total(tno);
	}
}







