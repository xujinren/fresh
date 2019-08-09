package com.yc.fresh.Service;


import com.yc.fresh.entiry.MenberInfo;

public interface MemberInfoService {
	/**
	 * Ìí¼ÓÐÅÏ¢
	 * @return
	 */
	public int addInfo(MenberInfo men);
	

	/**
	 * µÇÂ¼
	 * @param nickname
	 * @param pwd
	 * @return
	 */
	public MenberInfo login(String nickname, String  pwd);
}
