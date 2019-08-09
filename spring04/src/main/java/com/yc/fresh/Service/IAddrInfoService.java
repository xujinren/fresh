package com.yc.fresh.Service;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.AddrInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;

public interface IAddrInfoService {
	
	/**
	 * ��ӵ�ַ��Ϣ
	 * @param af
	 * @return
	 */
	public int add(AddrInfo af);
	
	
	/**
	 * �޸�Ĭ�ϵ�ַ
	 * @param anos
	 * @return
	 */
	public int update(String[] anos);
	
	
	
	
	/**
	 * ��ѯָ����Ա�ĵ�ַ��Ϣ
	 * @return
	 */
	public List<AddrInfo> findByMno(int mno);
}
