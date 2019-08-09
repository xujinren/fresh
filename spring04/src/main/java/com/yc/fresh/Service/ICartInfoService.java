package com.yc.fresh.Service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;

public interface ICartInfoService {
	/**
	 * 加入购物车
	 * @param cf
	 * @return
	 */
	public int add(CartInfo cf);
	/**
	 * 根据会员编号获取该会员的购物车信息
	 * @param mno
	 * @return
	 */
	public List<CartInfo> findByMno(int mno);
	
	/**
	 * 同时删除多个记录
	 * @param gnos
	 * @return
	 */
	public int delete(int[] gnos);
	
	/**
	 * 从购物车中移除商品
	 * @param cno
	 * @return
	 */
	public int deleteByGno(int cno);
	
	/**
	 * 修改数量
	 * @param cf
	 * @return
	 */
	public int update(CartInfo cf);
	
	/**
	 * 根据cno查询该商品
	 * @param cno
	 * @return
	 */
	public CartInfo findByMnoAndGno(int mno, int gno);
	
	/**
	 * 获取购物车总数
	 * @param mno
	 * @return
	 */
	public int findCountCno(int mno);
	
	public List<CartInfo> findByCno03(String[] cno);
}
