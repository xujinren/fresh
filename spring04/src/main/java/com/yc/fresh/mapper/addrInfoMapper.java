package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.AddrInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;

public interface addrInfoMapper {
	
	/**
	 * 添加地址信息
	 * @param af
	 * @return
	 */
	public int add(AddrInfo af);
	
	
	/**
	 * 修改默认地址
	 * @param mno
	 * @return
	 */
	public int update(int mno);
	
	
	/**
	 * 修改默认地址
	 * @param anos
	 * @return
	 */
	public int updates(String[] anos);
	
	/**
	 * 查询指定的会员地址信息
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findByMno(int mno);
	
	
}
