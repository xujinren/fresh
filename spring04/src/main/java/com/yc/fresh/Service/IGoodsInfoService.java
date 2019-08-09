package com.yc.fresh.Service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.GoodsInfo;

public interface IGoodsInfoService {
	
	
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
	public Map<String, Object> finds();

	/**
	 * ��ȡ�����ķ���
	 * @param tno
	 * @return
	 */
	public int ftotal(int tno);


	
}
