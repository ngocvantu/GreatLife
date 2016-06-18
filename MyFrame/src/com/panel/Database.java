package com.panel;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.object.HoNgheo;
import com.object.TieuChi;
import com.object.ttcoban;

/**
 * Lớp java dùng để kết nối đến scdl mysql và một số phương thức gọi dữ liệu (data) từ 
 * cơ sở dữ liệu ra
 * @author NGOC HOANG
 *
 */
public class Database {
	static Connection conn = null; // Đối tượng connection của java, ta sẽ tạo
									// kết nối và gán cho đối tượng này để sử
									// dụng về sau
	static Statement stmt = null; // Đối tượng để tạo câu lệnh sql (select .......)

	/**
	 * Phương thức khởi tạo đối tượng
	 * Khi người dùng khởi tạo đối tượng, ta sẽ tạo kết nối và gán cho đối tượng conn.
	 */
	public Database() {
		try {
			
			// tạo kết nối đến cơ sở dữ liệu có tên là qlhn với tài khoản rôt và không có mật khẩu
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/qlhn?useUnicode=true&characterEncoding=UTF-8","root","root");
			
			// in ra kết nôí
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	// tiêu chí
		public static ResultSet getAllTieuchi(String nam){
			ResultSet result = null;
			try {
				stmt  = conn.prepareStatement("select * from tieuchi where Maxa = '"+nam +"'");//??
				// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
				  result = stmt.executeQuery("select * from tieuchi where NamAD = '"+ nam +"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	
	/**
	 * Phưng thức lấy dữ liệu từ bảng taikhoan
	 * @param args
	 */
	
	
	
	public void taikhoan() {
		try {
			//tạo câu lệnh
			stmt  = conn.prepareStatement("select * from taikhoan");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			ResultSet result = stmt.executeQuery("select * from taikhoan");
			// in rra kết quả
		while (result.next()) {    // duyệt kết quả từ 0ầu chí cuối
			System.out.println(result.getString("User") + ": " + result.getString("Quyen"));
			
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet gettaikhoan(String username) {
		ResultSet result  = null;
		try {
			//tạo câu lệnh
			stmt  = conn.prepareStatement("select * from taikhoan");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from taikhoan where User = '" + username + "'");
			// in rra kết quả
		while (result.next()) {    // duyệt kết quả từ 0ầu chí cuối
			System.out.println(result.getString("User") + ": " + result.getString("Quyen"));
			
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * Đêm số hộ với loại hộ và năm truyền vào
	 * @param loaiho
	 * @param nam
	 * @return
	 */
	public static int getSoHo(int loaiho, String nam) {
		ResultSet result = null;
		int total = 0;
		String sql = "SELECT COUNT(MaHN) AS total FROM hongheo WHERE Ngaynhap = '" +nam + "' AND Maloaiho = '" + loaiho + "'";
		try {
			stmt  = conn.prepareStatement("select DISTINCT  Huyen from diaphuong");
			  result = stmt.executeQuery(sql);
			  while (result.next()) { 
				  total = result.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public static int getSoHoByHuyen(String huyen, String nam) {
		ResultSet result = null;
		int total = 0;
		String sql = "SELECT COUNT(Maho) AS total FROM ttcoban WHERE Ngaynhap = '" +nam + "' AND Huyen = '" + huyen + "'";
		if(huyen == null){
			sql = "SELECT COUNT(Maho) AS total FROM ttcoban WHERE Ngaynhap = '" +nam + "'";
		}
		try {
			stmt  = conn.prepareStatement("select DISTINCT  Huyen from diaphuong");
			  result = stmt.executeQuery(sql);
			  while (result.next()) { 
				  total = result.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	public static int getSoHo(int loaiho, String nam, String xa) {
		ResultSet result = null;
		int total = 0;
		String sql = "SELECT COUNT(MaHN) AS total FROM hongheo WHERE Ngaynhap = '" +nam + "' AND Maloaiho = '" + loaiho + "'" + "AND Maxa = '" + xa + "'";
		try {
			stmt  = conn.prepareStatement("select DISTINCT  Huyen from diaphuong");
			  result = stmt.executeQuery(sql);
			  while (result.next()) { 
				  total = result.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	 
	/**
	 * 
	 * @param uname
	 * @param pass
	 * @return true neu dang nhap dung, false neu dang nhap sai
	 */
	public static boolean dangnhapok(String uname, String pass) {
		try {
			//tạo câu lệnh
			stmt  = conn.prepareStatement("select * from taikhoan");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			ResultSet result = stmt.executeQuery("select * from taikhoan");
			// in rra kết quả
		while (result.next()) {    // duyệt kết quả từ 0ầu chí cuối, neu ton tai username va passs nhu truyen vao thi ok, neu ko thif return false
			System.out.println(result.getString("User") + ": " + result.getString("Quyen"));
			if(result.getString("User").equals(uname) && result.getString("Pass").equals(pass)){
				// dang nhap dung, tra ve true
				return true;
				
			}
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static ResultSet getAllxa()
	{ 
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select  * from xa");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from xa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static ResultSet getHoNgheoByNam(String nam)
	{ 
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select  * from xa");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("SELECT hongheo.*, diaphuong.Huyen FROM hongheo, diaphuong where hongheo.Maxa = diaphuong.Maxa AND hongheo.Ngaynhap = '" + nam + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static ResultSet getHoNgheoByNamAndXaHuyen(String huyen, String xa, String nam)
	{ 
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select  * from xa");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("SELECT hongheo.*, diaphuong.Huyen FROM hongheo, diaphuong where "
			  		+ "hongheo.Maxa = diaphuong.Maxa AND hongheo.Ngaynhap = '" + nam + "' AND "
			  				+ "hongheo.Maxa = '" + xa + "' AND diaphuong.Huyen = '" + huyen + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public static ResultSet getAllxa(String huyen)
	{ 
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select  * from xa");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select Maxa from diaphuong where Huyen = '" + huyen + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public static ResultSet getAllHuyen()
	{ 
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select DISTINCT  Huyen from diaphuong");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select  DISTINCT  Huyen  from diaphuong");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	// Bước 1: Viết phương thúc lấy toàn bộ hộ nghèo trong bảng hộ nghèo
	public static ResultSet getAllHoNgheo(String maxa){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from hongheo where Maxa = '"+ maxa +"'");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from hongheo where Maxa = '"+ maxa +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// phuong thuc tim kiem
	 
	public static ResultSet gettimkiem(String txt ){
		ResultSet result = null;
		try {
			
			stmt  = conn.prepareStatement("select * from hongheo ");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from hongheo where MaHN like  '"+ txt+"' or Chuho like '"+txt+"' "); // *  xong thi phai cach ra
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// Bước 1: Viết phương thúc lấy toàn bộ hộ nghèo trong bảng hộ nghèo
		public static ResultSet getAllThongTin( ){
			ResultSet result = null;
			try {
				stmt  = conn.prepareStatement("select * from hongheo ");//??
				// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
				  result = stmt.executeQuery("select hongheo.Maxa, hongheo.MaHN, hongheo.Chuho,hongheo.B1,hongheo.B2,hongheo.MaKV,hongheo.Maloaiho,"
				  		+ "hongheo.Thunhap,hongheo.MaTTNhaO,hongheo.MaTT,hongheo.ManuocSH,"
				  		+ "hongheo.Mahocvan,hongheo.MaYT,hongheo.Ngaynhap,ttcoban.TTCapthe from hongheo, ttcoban where hongheo.MaHN=ttcoban.Maho");
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
	
	public static ResultSet getAllHoNgheo( ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from hongheo" );  //??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from hongheo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet getTable(String table ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from hongheo" );  //??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from " + table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet getAllTTCoBan( ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from ttcoban" );  //??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from ttcoban");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet getAllTieuChi( ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from tieuchi" );  //??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select DISTINCT NamAD  from tieuchi ORDER BY NamAD DESC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static ResultSet getAllTieuChi2( ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from tieuchi" );  //??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from tieuchi ORDER BY NamAD");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
  
	public static void nhapHoNgheo(HoNgheo hongheo){
		Statement stm = null;
		String sql  = "INSERT INTO hongheo   VALUES ('" + hongheo.getMaHN() + "','" +
		hongheo.getMaxa()  + "','" + hongheo.getMaloaiho() + "','" + hongheo.getThunhap() + "','" + 
		hongheo.getMattNhao() + "','" + hongheo.getMaTT() + "','" + hongheo.getManuocSH() + "','" + 
		hongheo.getNgaynhap()+ "','"+ hongheo.getMahocvan() + "','" + hongheo.getB1() + "','"+
		hongheo.getB2() + "','" + hongheo.getChuho() + "','" + hongheo.getNhankhau() + "','" +
		hongheo.getMaKV() + "','"+ hongheo.getMaYte()+ "');"
		;
		
		if(Database.tontai(hongheo.getMaHN(), hongheo.getNgaynhap())){
			sql = "UPDATE  hongheo  SET `Maxa`='"+hongheo.getMaxa()+"',`Maloaiho`="+hongheo.getMaloaiho()+","+
					"`Thunhap`='"+hongheo.getThunhap()+"',`MaTTNhaO`='"+hongheo.getMattNhao()+"',"+
					"`MaTT`='"+hongheo.getMaTT()+"',`ManuocSH`='"+hongheo.getManuocSH()+"',"+
					 "`Mahocvan`='"+hongheo.getMahocvan()+"',"+
					"`B1`='"+hongheo.getB1()+"',`B2`='"+hongheo.getB2()+"',"+
					"`Chuho`='"+hongheo.getChuho()+"',`Nhankhau`='"+hongheo.getNhankhau()+"',"+
					"`MaKV`='"+hongheo.getMaKV()+"',`MaYT`='"+hongheo.getMaYte()+"' WHERE `MaHN` = '" + hongheo.getMaHN() + 
					"' AND `Ngaynhap` = '"+ hongheo.getNgaynhap() + "';";
		}
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static boolean tontai(String maHN, String ngaynhap) {
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from tieuchi" );  //??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select * from hongheo "
			  		+ "where MaHN = '" + maHN + "' AND Ngaynhap = '" + ngaynhap + "'");
			  int i = 0;
			  while (result.next()) {
				i++;
			}
			  if(i>0){
				  System.out.println("ton tai ho ngheo " + maHN);
				  return true;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
	}

	public static void addttcoban(ttcoban thongtincoban){
		Statement stm = null;
		String sql  = "INSERT INTO ttcoban   VALUES ('"+thongtincoban.getstt()+"','" + thongtincoban.gethuyen() + "','" +
				thongtincoban.getMaxa()  + "','" +thongtincoban.Chuho() + "','" + thongtincoban.getMaHN() + "','" + 
				thongtincoban.getttcapthe()+ "','"+thongtincoban.getNgaynhap()+"');"
		;
		
		
		try { 
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void addDiaPhuong(ttcoban thongtincoban){
		Statement stm = null;
		String sql  = "INSERT INTO ttcoban   VALUES ('"+thongtincoban.getstt()+"','" + thongtincoban.gethuyen() + "','" +
				thongtincoban.getMaxa()  + "','" +thongtincoban.Chuho() + "','" + thongtincoban.getMaHN() + "','" + 
				thongtincoban.getttcapthe()+ "','"+thongtincoban.getNgaynhap()+"');"
		;
		
		
		try { 
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public static void addTieuChi(TieuChi tieuChi){
		Statement stm = null;
		String sql = "INSERT INTO tieuchi   VALUES ('" + tieuChi.getNamAD()
				+ "','" + tieuChi.getCQBH() + "','" + tieuChi.getDiemB1()
				+ "','" + tieuChi.getDiemB12() + "','" + tieuChi.getDiemB13() 
				+ "','" + tieuChi.getDiemB2() + "','" + tieuChi.getDiemB22()
				+ "','" + tieuChi.getDiemB23() + "','" + tieuChi.getMaKV()
				+ "','" + tieuChi.getLoaiHo() + "');";
		try { 
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet getAllttcoban( ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("select * from ttcoban ");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			  result = stmt.executeQuery("select ttcoban.STT,  ttcoban.Huyen,  ttcoban.Xa, ttcoban.Chuho, ttcoban.Maho, ttcoban.TTCapthe, ttcoban.Ngaynhap from ttcoban"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet delttcoban(String maho ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("delete  from ttcoban where Maho =  '" + maho + "';");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			 stmt.executeUpdate("delete  from ttcoban where Maho =  '" + maho + "';"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet delTieuChi(String maho ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("delete  from tieuchi where MaKV =  '" + maho + "';");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			 stmt.executeUpdate("delete  from tieuchi where NamAD =  '" + maho + "';"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet updatettcoban(ttcoban ttcoban ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement(" ");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			 stmt.executeUpdate("update ttcoban set STT = '" + ttcoban.getstt() + "', Huyen = '" + ttcoban.gethuyen() + 
					 "', Xa = '" + ttcoban.getMaxa() + "', Chuho = '" + ttcoban.getChuho() + "', Maho = '" + ttcoban.getMaHN() + 
					 "', TTCapthe = '" + ttcoban.getttcapthe() + "'" + "where Maho = '" +ttcoban.getMaHN() + "';"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet updateTieuchi(TieuChi ttcoban ){
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement(" ");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			 stmt.executeUpdate("update tieuchi set NamAD = '" + ttcoban.getNamAD() + "', 	CQBH = '" + ttcoban.getCQBH() + 
					 "', DiemB1 = '" + ttcoban.getDiemB1() +"', DiemB12 = '" + ttcoban.getDiemB12() +"', DiemB13 = '" + ttcoban.getDiemB13() 
					 + "', DiemB2 = '" + ttcoban.getDiemB2() + "', DiemB22 = '" + ttcoban.getDiemB22() + "', DiemB23 = '" + ttcoban.getDiemB23()
					 + "', LoaiHo = '" + ttcoban.getLoaiHo() + 
					 "'" + "where MaKV = '" +ttcoban.getMaKV()+ "';"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	
	public void thongtin() {
		try {
			//tạo câu lệnh
			stmt  = conn.prepareStatement("select * from thongtinnguoidung");
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			ResultSet result = stmt.executeQuery("select * from thongtinnguoidung");
			// in ra kết quả
		while (result.next()) {    // duyệt kết quả từ đầu chí cuối
			System.out.println( result.getString("Hoten")+ ": " + result.getString("Chucvu")+ ": " + result.getString("SDT")+ ": " + result.getString("Email")+ ": " + result.getString("User")+ ": " + result.getString("Pass"));
			
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// Chạy thử
		Database db = new Database();
		db.taikhoan();
		// như vậy là tạo kết nối thành công
		// in kết quả thành công
		
	}

	public static void deleteTaiKhoan(String text, String text2) { 
		ResultSet result = null;
		try {
			stmt  = conn.prepareStatement("delete  from ttcoban where Maho =  '" + "kk" + "';");//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			 stmt.executeUpdate("delete  from taikhoan where User =  '" + text + "' AND Pass = '" + text2 +"'"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void themTaiKhoan(String text, String text2) { 
		ResultSet result = null;
		try {
			stmt  = conn.createStatement();//??
			// thực hiện câu lệnh và gán kết quả vào đối tượng  ResultSet của java
			 stmt.executeUpdate("INSERT INTO taikhoan VALUES ('" + text + "','" + text2 + "','" + "4');"
			  		);
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
