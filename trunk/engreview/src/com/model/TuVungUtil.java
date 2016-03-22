package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import com.hibernate.HibernateUtil;
import com.object.TuVung;

public class TuVungUtil {
	Connection connection;
	PreparedStatement statement;
	
	public static void xoa(String id) {
		int id1 = Integer.parseInt(id);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session =   sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete TuVung where id = :id");
//		query.setCacheable(false);
		System.out.println(id1);
		query.setParameter("id", id1);
		query.executeUpdate();
		session.getTransaction().commit();
		
		session.close();
	}
	
	public static List<TuVung> getAllTuVung() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM TuVung");
//		query.setFirstResult(1);
//		query.setMaxResults(1);
//		query.setCacheable(false);
		List<TuVung> list = query.list(); 
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public static List<TuVung> getTuVungByOrder(int order) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM TuVung");
		query.setFirstResult(order);
		query.setMaxResults(1);
//		query.setCacheable(false);
		List<TuVung> list = query.list(); 
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public static TuVung getTuVungById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =  sessionFactory.openSession();
		session.beginTransaction();  
		TuVung tuvung = (TuVung) session.get(TuVung.class, id);
		session.getTransaction().commit();
		session.close();
		return tuvung;
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
