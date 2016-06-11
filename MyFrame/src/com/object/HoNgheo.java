package com.object;

import java.util.Date;


public class HoNgheo {
	private String MaHN; // đầu tiên là mã hn  ( phải string)
	private String Maxa;  // rồi mã xã  ( phải string)
	private String Chuho;
	private float Thunhap;
	private int  MaKV;
	private int  MaTT;   
	private int MattNhao;
	
	
	private int ManuocSH;
	private int Maloaiho;
	private String Ngaynhap;
	private int Nhankhau;
	private int MaYte;
	private int Mahocvan;
	private int B1;
	private int B2;
	public HoNgheo(String maHN, String chuho, int maTT,  
			int mattNhao, float thunhap, int maKV, int manuocSH,
			int maloaiho, int nhankhau, String string, int hocvan, String maxa,
			int maYte, int b1, int b2) {     // theo phương thúc này, hai cái này là 1 nên phải khớp nhau
		
		super();
		MaHN = maHN;
		Chuho = chuho;
		Maxa= maxa;
		MaTT = maTT;
		MattNhao = mattNhao;
		Thunhap = thunhap;
	    Mahocvan= hocvan;
		MaKV = maKV;
		ManuocSH = manuocSH;
		Maloaiho = maloaiho;
		Ngaynhap = string;
	    
		 
		Nhankhau = nhankhau;
		MaYte = maYte;
		B1 = b1;
		B2 = b2;
	}
	public String getMaHN() {
		return MaHN;
	}
	public void setMaHN(String maHN) {
		MaHN = maHN;
	}
	public String getMaxa() {
		return Maxa;
	}
	public void setMaxa(String maxa) {
		MaHN = maxa;
	}
	public String getChuho() {
		return Chuho;
	}
	public void setChuho(String chuho) {
		Chuho = chuho;
	}
	public int getMaTT() {
		return MaTT;
	}
	public void setMaTT(int maTT) {
		MaTT = maTT;
	}
	public int getMahocvan() {
		return Mahocvan;
	}
	public void setMahocvan(int hocvan) {
		MaTT = hocvan;
	}
	public int getMattNhao() {
		return MattNhao;
	}
	public void setMattNhao(int mattNhao) {
		MattNhao = mattNhao;
	}
	public float getThunhap() {
		return Thunhap;
	}
	public void setThunhap(float thunhap) {
		Thunhap = thunhap;
	}
	public int getMaKV() {
		return MaKV;
	}
	public void setMaKV(int maKV) {
		MaKV = maKV;
	}
	public int getManuocSH() {
		return ManuocSH;
	}
	public void setManuocSH(int manuocSH) {
		ManuocSH = manuocSH;
	}
	public int getMaloaiho() {
		return Maloaiho;
	}
	public void setMaloaiho(int maloaiho) {
		Maloaiho = maloaiho;
	}
	public String getNgaynhap() {
		return Ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		Ngaynhap = ngaynhap;
	}
	public int getNhankhau() {
		return Nhankhau;
	}
	public void setNhankhau(int nhankhau) {
		Nhankhau = nhankhau;
	}
	public int getMaYte() {
		return MaYte;
	}
	public void setMaYte(int maYte) {
		MaYte = maYte;
	}
	public int getB1() {
		return B1;
	}
	public void setB1(int b1) {
		B1 = b1;
	}
	public int getB2() {
		return B2;
	}
	public void setB2(int b2) {
		B2 = b2;
	}
	
	
	
	
	
	

}
