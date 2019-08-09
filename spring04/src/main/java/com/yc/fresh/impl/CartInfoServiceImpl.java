package com.yc.fresh.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.Service.IAdminInfoService;
import com.yc.fresh.Service.ICartInfoService;
import com.yc.fresh.entiry.AdminInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.mapper.CartInfoMapper;
import com.yc.fresh.mapper.IAdminInfoMapper;


@Service
public class CartInfoServiceImpl implements ICartInfoService {
	@Autowired
	private CartInfoMapper mapper;
	@Override
	public int add(CartInfo cf) {
		return  mapper.add(cf);
	}

	@Override
	public List<CartInfo> findByMno(int mno) {
		// TODO Auto-generated method stub
		return mapper.findByMno(mno);
	}

	@Override
	public int delete(int[] gnos) {
		// TODO Auto-generated method stub
		return mapper.delete(gnos);
	}

	@Override
	public int deleteByGno(int cno) {
		// TODO Auto-generated method stub
		return mapper.deleteByGno(cno);
	}

	@Override
	public int update(CartInfo cf) {
		return mapper.update(cf);
	}

	@Override
	public CartInfo findByMnoAndGno(int mno, int gno) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("mno",mno);
		map.put("gno",gno);
		return mapper.findByMnoAndGno(map);
	}

	@Override
	public int findCountCno(int mno) {
		// TODO Auto-generated method stub
		return mapper.findCountCno(mno);
	}

	@Override
	public List<CartInfo> findByCno03(String[] cno) {
		
		return mapper.findByCno03(cno);
	}
	
	
	
	
	

}
