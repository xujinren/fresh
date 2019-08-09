package com.yc.fresh.Service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;

public interface ICartInfoService {
	/**
	 * ���빺�ﳵ
	 * @param cf
	 * @return
	 */
	public int add(CartInfo cf);
	/**
	 * ���ݻ�Ա��Ż�ȡ�û�Ա�Ĺ��ﳵ��Ϣ
	 * @param mno
	 * @return
	 */
	public List<CartInfo> findByMno(int mno);
	
	/**
	 * ͬʱɾ�������¼
	 * @param gnos
	 * @return
	 */
	public int delete(int[] gnos);
	
	/**
	 * �ӹ��ﳵ���Ƴ���Ʒ
	 * @param cno
	 * @return
	 */
	public int deleteByGno(int cno);
	
	/**
	 * �޸�����
	 * @param cf
	 * @return
	 */
	public int update(CartInfo cf);
	
	/**
	 * ����cno��ѯ����Ʒ
	 * @param cno
	 * @return
	 */
	public CartInfo findByMnoAndGno(int mno, int gno);
	
	/**
	 * ��ȡ���ﳵ����
	 * @param mno
	 * @return
	 */
	public int findCountCno(int mno);
	
	public List<CartInfo> findByCno03(String[] cno);
}
