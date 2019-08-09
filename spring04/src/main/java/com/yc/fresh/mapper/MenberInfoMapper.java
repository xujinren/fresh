package com.yc.fresh.mapper;

import java.util.Map;

import com.yc.fresh.entiry.MenberInfo;

public interface MenberInfoMapper {
	
	/**
	 * 添加会员信息
	 * @param men
	 * @return
	 */
	public int addInfo(MenberInfo men);
	
	
	/**
	 * 登录
	 * @param nickname
	 * @param pwd
	 * @return
	 */
	public MenberInfo login(Map<String, String> map);
}
