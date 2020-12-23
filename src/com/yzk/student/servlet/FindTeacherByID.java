package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.TeacherDaoImo;

/**
 * Servlet implementation class FindStudentByname
 */
@WebServlet("/FindTeacherByID")
public class FindTeacherByID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindTeacherByID() {
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
		TeacherDaoImo daoImo = new TeacherDaoImo();
		request.setAttribute("teacher", daoImo.selectTeacherById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/upTeacher.jsp").forward(request, response);

	}

}
