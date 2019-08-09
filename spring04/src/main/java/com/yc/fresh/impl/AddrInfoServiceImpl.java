package com.yc.fresh.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.Service.IAddrInfoService;
import com.yc.fresh.Service.IAdminInfoService;
import com.yc.fresh.Service.ICartInfoService;
import com.yc.fresh.entiry.AddrInfo;
import com.yc.fresh.entiry.AdminInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.mapper.CartInfoMapper;
import com.yc.fresh.mapper.IAdminInfoMapper;
import com.yc.fresh.mapper.addrInfoMapper;
import com.yc.fresh.redis.IRedisDao;
import com.yc.fresh.redis.RedisDaoImpl;


@Service
public class AddrInfoServiceImpl implements IAddrInfoService {
	
	@Autowired
	private addrInfoMapper mapper;
	@Autowired
	private IRedisDao redis;

	/**
	 * 添加地址信息
	 * @param af
	 * @return
	 */
	@Override
	public int add(AddrInfo af) {
		int result = -2;
//		result = mapper.update(af.getMno());  //如果新添加的地址不需要设置为默认收货地址，则可以不要这个
		result = mapper.add(af);
		return result;
	}
	
	
	
	/**
	 * 更新默认地址
	 * @param anos
	 * @return
	 */
	@Override
	public int update(String[] anos) {
		if(anos.length < 2){
			return -2;
		}
		return mapper.updates(anos);
	}
	
	/**
	 * 
	 * 查询地址
	 * @return
	 */
	
	@Override
	public List<AddrInfo> findByMno(int mno) {
		//先从redis中取
		List<AddrInfo> temp = redis.listRange(String.valueOf(mno), 0, -1);
		if(temp != null && temp.isEmpty()){
			System.out.println("从Redis中获取");
			System.out.println(temp);
			return temp;
		}else{
			List<AddrInfo> list = mapper.findByMno(mno);
			redis.listLeftPushAll(String.valueOf(mno), list);
			return list;
		}
	}
}
