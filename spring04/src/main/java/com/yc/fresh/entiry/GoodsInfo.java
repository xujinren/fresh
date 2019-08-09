package com.yc.fresh.entiry;

import java.io.Serializable;

public class GoodsInfo implements Serializable {

	private static final long serialVersionUID = 1089511799537268135L;
	
	private int gno;
	private String gname;
	private int tno;
	private double price;
	private String intro;
	private int banance;
	private String pics;
	private String unit;
	private String  qperied;
	private String weight;
	private String descr;
	
	private String tname;
	private GoodsType goodsType;
	
	@Override
	public String toString() {
		return "GoodsInfo [gno=" + gno + ", gname=" + gname + ", tno=" + tno + ", price=" + price + ", intro=" + intro
				+ ", banance=" + banance + ", pics=" + pics + ", unit=" + unit + ", qperied=" + qperied + ", weight="
				+ weight + ", descr=" + descr + ", tname=" + tname + ", goodsType=" + goodsType + "]";
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getBanance() {
		return banance;
	}

	public void setBanance(int banance) {
		this.banance = banance;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getQperied() {
		return qperied;
	}

	public void setQperied(String qperied) {
		this.qperied = qperied;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public GoodsInfo(int gno, String gname, int tno, double price, String intro, int banance, String pics, String unit,
			String qperied, String weight, String descr) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.tno = tno;
		this.price = price;
		this.intro = intro;
		this.banance = banance;
		this.pics = pics;
		this.unit = unit;
		this.qperied = qperied;
		this.weight = weight;
		this.descr = descr;
	}

	public GoodsInfo(int gno, String gname, int tno, double price, String intro, int banance, String pics, String unit,
			String qperied, String weight, String descr, String tname, GoodsType goodsType) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.tno = tno;
		this.price = price;
		this.intro = intro;
		this.banance = banance;
		this.pics = pics;
		this.unit = unit;
		this.qperied = qperied;
		this.weight = weight;
		this.descr = descr;
		this.tname = tname;
		this.goodsType = goodsType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + banance;
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + gno;
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((pics == null) ? 0 : pics.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((qperied == null) ? 0 : qperied.hashCode());
		result = prime * result + tno;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoodsInfo other = (GoodsInfo) obj;
		if (banance != other.banance)
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (gname == null) {
			if (other.gname != null)
				return false;
		} else if (!gname.equals(other.gname))
			return false;
		if (gno != other.gno)
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (pics == null) {
			if (other.pics != null)
				return false;
		} else if (!pics.equals(other.pics))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (qperied == null) {
			if (other.qperied != null)
				return false;
		} else if (!qperied.equals(other.qperied))
			return false;
		if (tno != other.tno)
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	public GoodsInfo() {
		super();
	}
	
	
	
	
	
	
}
