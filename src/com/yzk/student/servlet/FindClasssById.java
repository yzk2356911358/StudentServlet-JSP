package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ClasssDaoImp;
import com.yzk.student.daoimp.StudentDaoImo;

/**
 * Servlet implementation class FindStudentByname
 */
@WebServlet("/FindClasssById")
public class FindClasssById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindClasssById() {
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
		ClasssDaoImp daoImo = new ClasssDaoImp();
		request.setAttribute("classs", daoImo.selectById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/upclasss.jsp").forward(request, response);

	}

}
