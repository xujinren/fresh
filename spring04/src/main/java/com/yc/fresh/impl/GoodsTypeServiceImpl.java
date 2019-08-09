package com.yc.fresh.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.Service.IGoodsTypeService;
import com.yc.fresh.entiry.GoodsType;
import com.yc.fresh.mapper.GoodsTypeMapper;


@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {
	@Autowired
	private GoodsTypeMapper mapper;

	@Override
	public List<GoodsType> findAll() {
		return mapper.findAll();
	}
}
