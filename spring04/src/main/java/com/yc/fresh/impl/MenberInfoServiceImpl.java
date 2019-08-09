package com.yc.fresh.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.Service.MemberInfoService;
import com.yc.fresh.entiry.MenberInfo;
import com.yc.fresh.mapper.MenberInfoMapper;


@Service
public class MenberInfoServiceImpl implements MemberInfoService {
	@Autowired
	private MenberInfoMapper mapper;


	@Override
	public int addInfo(MenberInfo men) {
		if(men != null){
			return mapper.addInfo(men);
		}
		return -1;
	}

	@Override
	public MenberInfo login(String nickname, String pwd) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nickname", nickname);
		map.put("pwd", pwd);
		return mapper.login(map);
		
	}
}
