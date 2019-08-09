package com.yc.fresh.entiry;

import java.io.Serializable;

public class OrderInfo  implements Serializable{

	private static final long serialVersionUID = -4523405252948280400L;
	
	private String ono;
	private String odate;
	private int ano;
	private String sdate;
	private String rdate;
	private int status;
	private double price;
	private int invoice;
	
	@Override
	public String toString() {
		return "OrderInfo [ono=" + ono + ", odate=" + odate + ", ano=" + ano + ", sdate=" + sdate + ", rdate=" + rdate
				+ ", status=" + status + ", price=" + price + ", invoice=" + invoice + "]";
	}

	public OrderInfo(String ono, String odate, int ano, String sdate, String rdate, int status, double price,
			int invoice) {
		super();
		this.ono = ono;
		this.odate = odate;
		this.ano = ano;
		this.sdate = sdate;
		this.rdate = rdate;
		this.status = status;
		this.price = price;
		this.invoice = invoice;
	}

	public OrderInfo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + invoice;
		result = prime * result + ((odate == null) ? 0 : odate.hashCode());
		result = prime * result + ((ono == null) ? 0 : ono.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rdate == null) ? 0 : rdate.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
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
		OrderInfo other = (OrderInfo) obj;
		if (ano != other.ano)
			return false;
		if (invoice != other.invoice)
			return false;
		if (odate == null) {
			if (other.odate != null)
				return false;
		} else if (!odate.equals(other.odate))
			return false;
		if (ono == null) {
			if (other.ono != null)
				return false;
		} else if (!ono.equals(other.ono))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (rdate == null) {
			if (other.rdate != null)
				return false;
		} else if (!rdate.equals(other.rdate))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public String getOno() {
		return ono;
	}

	public void setOno(String ono) {
		this.ono = ono;
	}

	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
