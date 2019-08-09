package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.GoodsInfo;

public interface GoodsInfoMapper {
	
	/**
	 * 添加信息
	 * @param goodsInfo
	 * @return
	 */
	public int add(GoodsInfo goodsInfo);
	
	
	/**
	 * 根据编号来查询商品信息
	 * @param gno
	 * @return
	 */
	public GoodsInfo findByGno(int gno);
	
	
	
	
	/**
	 * 根据种类分页查询
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByType(Map<String, Integer> map);
	
	
	/**
	 * 查询每种类型的前三条信息
	 * @return
	 */
	public List<GoodsInfo> finds();
	
	
	/**
	 * 获取总数的方法
	 * @param tno
	 * @return
	 */
	public int total(int tno);
}
