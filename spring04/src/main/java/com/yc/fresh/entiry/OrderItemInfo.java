package com.yc.fresh.entiry;

import java.io.Serializable;

public class OrderItemInfo implements Serializable {
	private static final long serialVersionUID = -1323659975857777619L;
	
	private int ino; 
	private String ono; //�������
	private int gno; //��Ʒ���
	private int nums; //��������
	private double price; //���򵥼�
	private int status;
	
	
	@Override
	public String toString() {
		return "OrderItemInfo [ino=" + ino + ", ono=" + ono + ", gno=" + gno + ", nums=" + nums + ", price=" + price
				+ ", status=" + status + "]";
	}


	public OrderItemInfo(int ino, String ono, int gno, int nums, double price, int status) {
		super();
		this.ino = ino;
		this.ono = ono;
		this.gno = gno;
		this.nums = nums;
		this.price = price;
		this.status = status;
	}


	public OrderItemInfo() {
		super();
	}


	public int getIno() {
		return ino;
	}


	public void setIno(int ino) {
		this.ino = ino;
	}


	public String getOno() {
		return ono;
	}


	public void setOno(String ono) {
		this.ono = ono;
	}


	public int getGno() {
		return gno;
	}


	public void setGno(int gno) {
		this.gno = gno;
	}


	public int getNums() {
		return nums;
	}


	public void setNums(int nums) {
		this.nums = nums;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStatus() {
		return status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gno;
		result = prime * result + ino;
		result = prime * result + nums;
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + status;
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
		OrderItemInfo other = (OrderItemInfo) obj;
		if (gno != other.gno)
			return false;
		if (ino != other.ino)
			return false;
		if (nums != other.nums)
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
