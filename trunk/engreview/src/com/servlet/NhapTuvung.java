package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.TuVungUtil;
import com.object.TuVung;

/**
 * Servlet implementation class NhapTuvung
 */
@WebServlet("/nhaptuvung")
public class NhapTuvung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhapTuvung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		String tuvung = request.getParameter("tuvung");
		String nghia = request.getParameter("nghia");
		String vidu1 = request.getParameter("vidu1");
		String vidu2 = request.getParameter("vidu2");
		String tuloai = request.getParameter("tuloai");
		String noihoc = request.getParameter("noihoc");
		String tudongnghia = request.getParameter("tudongnghia");
		String tutrainghia = request.getParameter("tutrainghia");
		String ngaynhap = request.getParameter("ngaynhap");
		String ghichu = request.getParameter("ghichu");
		
		if(tuvung!=null && nghia!= null && !tuvung.equals("") && !nghia.equals("")){
			TuVung tuVung2 = new TuVung(tuvung, nghia, vidu1, vidu2, tuloai, noihoc, tudongnghia, tutrainghia, new Date(), ghichu, false, 0);
			TuVungUtil.addTuVung(tuVung2);
		}
		System.out.println(tuvung);
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
//		rd.forward(request, response);
		response.sendRedirect(request.getContextPath() + "");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tuvung = request.getParameter("tuvung");
		System.out.println(tuvung);
	}

}
