package com.yc.fresh.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fresh.Service.IAdminInfoService;
import com.yc.fresh.entiry.AdminInfo;
import com.yc.fresh.mapper.IAdminInfoMapper;


@Service
public class AdminInfoServiceImpl implements IAdminInfoService {
	
	
	@Autowired
	private IAdminInfoMapper mapper;
	@Override
	public AdminInfo login(AdminInfo af) {
		if(af.getAname() == null || af.getAname().length() <= 0 || af.getPwd() == null || af.getPwd().length() <= 0){
			return null;
		}
		
		return mapper.login(af);
	}

	@Override
	public int add(AdminInfo af) {
		if(af.getAname() == null || af.getAname().length() <= 0 || af.getPwd() == null || af.getPwd().length() <= 0 || af.getTel() == null || af.getTel().length() <= 0){
			return -1;
		}
		return mapper.add(af);
	}

	@Override
	public List<AdminInfo> findAll() {
		return mapper.findAll();
	}

	@Override
	public int updatPwd(Integer aid) {
		if(aid == null){
			return -1;
		}
		return  mapper.updatPwd(aid);
	}

}
