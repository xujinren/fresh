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
	 * ��ӵ�ַ��Ϣ
	 * @param af
	 * @return
	 */
	@Override
	public int add(AddrInfo af) {
		int result = -2;
//		result = mapper.update(af.getMno());  //�������ӵĵ�ַ����Ҫ����ΪĬ���ջ���ַ������Բ�Ҫ���
		result = mapper.add(af);
		return result;
	}
	
	
	
	/**
	 * ����Ĭ�ϵ�ַ
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
	 * ��ѯ��ַ
	 * @return
	 */
	
	@Override
	public List<AddrInfo> findByMno(int mno) {
		//�ȴ�redis��ȡ
		List<AddrInfo> temp = redis.listRange(String.valueOf(mno), 0, -1);
		if(temp != null && temp.isEmpty()){
			System.out.println("��Redis�л�ȡ");
			System.out.println(temp);
			return temp;
		}else{
			List<AddrInfo> list = mapper.findByMno(mno);
			redis.listLeftPushAll(String.valueOf(mno), list);
			return list;
		}
	}
}
