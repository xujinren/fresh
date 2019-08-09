package com.yc.fresh.mapper;

import java.util.List;

import com.yc.fresh.entiry.AdminInfo;

public interface IAdminInfoMapper {
	
	/**
	 * 登录
	 * @param af
	 * @return
	 */
	public AdminInfo login(AdminInfo af);
	
	
	/**
	 * 添加
	 * @param as
	 * @return
	 */
	public int add(AdminInfo as);
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<AdminInfo>findAll();
	
	
	
	/**
	 * 更改密码
	 * @param aid
	 * @return
	 */
	public int updatPwd(Integer aid);
	
	
	
	
	
	
	
	
}
