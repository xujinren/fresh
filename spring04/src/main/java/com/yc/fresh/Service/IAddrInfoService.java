package com.yc.fresh.Service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.AddrInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;

public interface IAddrInfoService {
	
	/**
	 * 添加地址信息
	 * @param af
	 * @return
	 */
	public int add(AddrInfo af);
	
	
	/**
	 * 修改默认地址
	 * @param anos
	 * @return
	 */
	public int update(String[] anos);
	
	
	
	
	/**
	 * 查询指定会员的地址信息
	 * @return
	 */
	public List<AddrInfo> findByMno(int mno);
}
