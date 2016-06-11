package com.object;

public class TieuChi {
	private String NamAD;
	private String CQBH;
	private double DiemB1;
	private double DiemB12;
	private double DiemB13;
	private double DiemB2;
	private double DiemB22;
	private double DiemB23;
	private String MaKV;
	private String LoaiHo;
	
	
	
	public TieuChi(String namAD, String cQBH, double diemB1, double diemB2,
			String maKV, String loaiHo) {
		super();
		NamAD = namAD;
		CQBH = cQBH;
		DiemB1 = diemB1;
		DiemB2 = diemB2;
		MaKV = maKV;
		LoaiHo = loaiHo;
	}
	
	
	
	
	
	public TieuChi(String namAD, String cQBH, double diemB1, double diemB12,
			double diemB13, double diemB2, double diemB22, double diemB23,
			String maKV, String loaiHo) {
		super();
		NamAD = namAD;
		CQBH = cQBH;
		DiemB1 = diemB1;
		DiemB12 = diemB12;
		DiemB13 = diemB13;
		DiemB2 = diemB2;
		DiemB22 = diemB22;
		DiemB23 = diemB23;
		MaKV = maKV;
		LoaiHo = loaiHo;
	}





	public double getDiemB12() {
		return DiemB12;
	}



	public void setDiemB12(double diemB12) {
		DiemB12 = diemB12;
	}



	public double getDiemB13() {
		return DiemB13;
	}



	public void setDiemB13(double diemB13) {
		DiemB13 = diemB13;
	}



	public double getDiemB22() {
		return DiemB22;
	}



	public void setDiemB22(double diemB22) {
		DiemB22 = diemB22;
	}



	public double getDiemB23() {
		return DiemB23;
	}



	public void setDiemB23(double diemB23) {
		DiemB23 = diemB23;
	}



	public String getLoaiHo() {
		return LoaiHo;
	}
	public void setLoaiHo(String loaiHo) {
		LoaiHo = loaiHo;
	}
	 
	public String getNamAD() {
		return NamAD;
	}
	public void setNamAD(String namAD) {
		NamAD = namAD;
	}
	public String getCQBH() {
		return CQBH;
	}
	public void setCQBH(String cQBH) {
		CQBH = cQBH;
	}
	public double getDiemB1() {
		return DiemB1;
	}
	public void setDiemB1(double diemB1) {
		DiemB1 = diemB1;
	}
	public double getDiemB2() {
		return DiemB2;
	}
	public void setDiemB2(double diemB2) {
		DiemB2 = diemB2;
	}
	public String getMaKV() {
		return MaKV;
	}
	public void setMaKV(String maKV) {
		MaKV = maKV;
	}
	
	
	
}
