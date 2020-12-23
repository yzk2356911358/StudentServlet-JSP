package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ClasssDaoImp;
import com.yzk.student.daoimp.KechengDaoImp;
import com.yzk.student.daoimp.StudentDaoImo;

/**
 * Servlet implementation class FindStudentByname
 */
@WebServlet("/FindKechengById")
public class FindKechengById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindKechengById() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		KechengDaoImp daoImo = new KechengDaoImp();
		request.setAttribute("kecheng", daoImo.selectById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/upkecheng.jsp").forward(request, response);

	}

}
