package com.object;

import java.util.Date;


public class ttcoban {
	private int STT;
	private String MaHN;
	private String Huyen;
	private String Maxa;
	private String Chuho;
	private int TTCapthe;
	private String Ngaynhap;
	
	
	public ttcoban(int stt,String huyen, String maxa, String chuho,String maHN, int ttcapthe,String ngaynhap)
{
		super();
		STT= stt;
		TTCapthe= ttcapthe;
		MaHN = maHN;
		Huyen= huyen;
		Maxa = maxa;
		Chuho = chuho;
		Ngaynhap= ngaynhap;
		  }
	public int  getstt() {
		return STT;
	}
	public void setstt(int stt) {
		TTCapthe = stt;
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
		Maxa = maxa;
	}
	public String Chuho() {
		return Chuho;
	}
	public void setChuho(String chuho) {
		Chuho = chuho;
	}
	
	public String gethuyen() {
		return Huyen;
	}
	public void sethuyen(String huyen) {
		Huyen = huyen;
	}
	
	public int  getttcapthe() {
		return TTCapthe;
	}
	public void setttcapthe(int ttcapthe) {
		TTCapthe = ttcapthe;
	}
	public String getNgaynhap() {
		return Ngaynhap;
	}
	public void setNgaynhap(String ngaynhap) {
		MaHN =ngaynhap;
	}
	public int getSTT() {
		return STT;
	}
	public void setSTT(int sTT) {
		STT = sTT;
	}
	public String getHuyen() {
		return Huyen;
	}
	public void setHuyen(String huyen) {
		Huyen = huyen;
	}
	public int getTTCapthe() {
		return TTCapthe;
	}
	public void setTTCapthe(int tTCapthe) {
		TTCapthe = tTCapthe;
	}
	public String getChuho() {
		return Chuho;
	}
	
}
	