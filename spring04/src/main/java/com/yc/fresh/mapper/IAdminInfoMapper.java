package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entiry.AdminInfo;

public interface IAdminInfoMapper {
	
	/**
	 * ��¼
	 * @param af
	 * @return
	 */
	public AdminInfo login(AdminInfo af);
	
	
	/**
	 * ���
	 * @param as
	 * @return
	 */
	public int add(AdminInfo as);
	
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<AdminInfo>findAll();
	
	
	
	/**
	 * ��������
	 * @param aid
	 * @return
	 */
	public int updatPwd(Integer aid);
	
	
	
	
	
	
	
	
}
