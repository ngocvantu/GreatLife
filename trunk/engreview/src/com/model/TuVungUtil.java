package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.HibernateUtil;
import com.object.TuVung;

public class TuVungUtil {
	Connection connection;
	PreparedStatement statement;
	
	public static List getAllTuVung() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<TuVung> list = session.createCriteria(TuVung.class).list();
		session.close();
		return list;
	}
	
	public static void addTuVung(TuVung tuvung){
		PreparedStatement statement ;
		Connection connection;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		connection = Database.getConnection();
		try {
			statement = connection
					.prepareStatement("INSERT INTO `engreview`.`tuvung`  VALUES (NULL, '"+
			
							tuvung.getTuvung() + "', '" + tuvung.getNghia() +"', '"+ tuvung.getVidu1() + "', '"+
							tuvung.getVidu2()+"', '"+tuvung.getTuloai()+"', '"+tuvung.getNoihoc()+"', '"+
							tuvung.getTudongnghia()+"', '"+tuvung.getTutrainghia()+"', '"+format.format(tuvung.getNgaynhap())+"', '"+
							tuvung.getGhichu()+"', '"+(tuvung.isDathuoc()==true?1:0)+"', '"+tuvung.getSolanon()+"') ");
			statement.execute();
			
			connection.close();
			Database.closeConnection();
			System.out.println(Database.conn.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) { 

	}

}
