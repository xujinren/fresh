package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.GoodsInfo;

public interface GoodsInfoMapper {
	
	/**
	 * �����Ϣ
	 * @param goodsInfo
	 * @return
	 */
	public int add(GoodsInfo goodsInfo);
	
	
	/**
	 * ���ݱ������ѯ��Ʒ��Ϣ
	 * @param gno
	 * @return
	 */
	public GoodsInfo findByGno(int gno);
	
	
	
	
	/**
	 * ���������ҳ��ѯ
	 * @param map
	 * @return
	 */
	public List<GoodsInfo> findByType(Map<String, Integer> map);
	
	
	/**
	 * ��ѯÿ�����͵�ǰ������Ϣ
	 * @return
	 */
	public List<GoodsInfo> finds();
	
	
	/**
	 * ��ȡ�����ķ���
	 * @param tno
	 * @return
	 */
	public int total(int tno);
}
