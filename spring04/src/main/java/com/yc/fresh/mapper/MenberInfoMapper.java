package com.yc.fresh.mapper;

import java.util.Map;

import com.yc.fresh.entiry.MenberInfo;

public interface MenberInfoMapper {
	
	/**
	 * ��ӻ�Ա��Ϣ
	 * @param men
	 * @return
	 */
	public int addInfo(MenberInfo men);
	
	
	/**
	 * ��¼
	 * @param nickname
	 * @param pwd
	 * @return
	 */
	public MenberInfo login(Map<String, String> map);
}
