package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
	
	public static List<TuVung> getAllTuVungToeic() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM TuVung where noihoc = :xxx ");
		query.setParameter("xxx", "600");
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
		Query query = session.createQuery("FROM TuVung where id >= :mid ");
		query.setParameter("mid", id);
		query.setMaxResults(1);
		TuVung tuvung = null;
		try {
			  tuvung = (TuVung) query.list().get(0);
		} catch (Exception e) { 
			return null;
		}
		
		session.getTransaction().commit();
		session.close();
		return tuvung;
	}
	
	public static TuVung getTuVungLast( ) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session =  sessionFactory.openSession();
		session.beginTransaction();  
		Query query = session.createQuery("from TuVung order by id DESC");
		query.setMaxResults(1);
		TuVung tuvung = (TuVung) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return tuvung;
	}
	
	public static void updateTuVung(String id_, String tuvung, String nghia, String vidu1, 
			String vidu2, String tuloai, String noihoc, String tudongnghia, String tutrainghia,
			String ngaynhap_, String ghichu, String dathuoc_, String solanon_){
		int id = Integer.valueOf(id_);
		int solanon = Integer.valueOf(solanon_);
		boolean dathuoc = Boolean.valueOf(dathuoc_);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date ngaynhap = new Date() ;
		try {
			  ngaynhap = format.parse(ngaynhap_);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction tx = null;
	    try{
	         tx = session.beginTransaction();
	         TuVung tuVung = 
	                    (TuVung)session.get(TuVung.class, id); 
	         tuVung.setTuvung(tuvung);
	         tuVung.setNghia(nghia);
	         tuVung.setVidu1(vidu1);
	         tuVung.setVidu2(vidu2);
	         tuVung.setTuloai(tuloai);
	         tuVung.setNoihoc(noihoc);
	         tuVung.setTudongnghia(tudongnghia);
	         tuVung.setTutrainghia(tutrainghia);
	         tuVung.setNgaynhap(ngaynhap);
	         tuVung.setGhichu(ghichu);
	         tuVung.setDathuoc(dathuoc);
	         tuVung.setSolanon(solanon);
	         
			 session.update(tuVung); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
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
