package model;

public class SanPham {
	
	public static int stt = 0;
	public static int id = 100000 ;
	String tenSp;
	//loại hàng
	int soLuong;
	Date ngayNhap;
	
	public SanPham(int id,String tenSp, int soLuong, Date ngayNhap) {
		super();
		this.id = id;
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.ngayNhap = ngayNhap;
	}

	public SanPham() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}


	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	
	
}
