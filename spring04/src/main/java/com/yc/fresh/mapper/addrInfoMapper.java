package com.yc.fresh.mapper;

import java.util.List;
import java.util.Map;

import com.yc.fresh.entiry.AddrInfo;
import com.yc.fresh.entiry.CartInfo;
import com.yc.fresh.entiry.GoodsInfo;

public interface addrInfoMapper {
	
	/**
	 * ��ӵ�ַ��Ϣ
	 * @param af
	 * @return
	 */
	public int add(AddrInfo af);
	
	
	/**
	 * �޸�Ĭ�ϵ�ַ
	 * @param mno
	 * @return
	 */
	public int update(int mno);
	
	
	/**
	 * �޸�Ĭ�ϵ�ַ
	 * @param anos
	 * @return
	 */
	public int updates(String[] anos);
	
	/**
	 * ��ѯָ���Ļ�Ա��ַ��Ϣ
	 * @param mno
	 * @return
	 */
	public List<AddrInfo> findByMno(int mno);
	
	
}
