package com.yc.fresh.Service;


import com.yc.fresh.entiry.MenberInfo;

public interface MemberInfoService {
	/**
	 * �����Ϣ
	 * @return
	 */
	public int addInfo(MenberInfo men);
	

	/**
	 * ��¼
	 * @param nickname
	 * @param pwd
	 * @return
	 */
	public MenberInfo login(String nickname, String  pwd);
}
