package com.yc.fresh.entiry;

public class GoodsType {
	private int tno;
	private String tname;
	private int status ;
	private String pic;
	
	
	@Override
	public String toString() {
		return "GoodsType [tno=" + tno + ", tname=" + tname + ", status=" + status + ", pic=" + pic + "]";
	}


	public int getTno() {
		return tno;
	}


	public void setTno(int tno) {
		this.tno = tno;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public GoodsType(int tno, String tname, int status, String pic) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.status = status;
		this.pic = pic;
	}


	public GoodsType() {
		super();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + status;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + tno;
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
		GoodsType other = (GoodsType) obj;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (status != other.status)
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno != other.tno)
			return false;
		return true;
	}
	
}
