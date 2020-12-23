package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.StudentDaoImo;
import com.yzk.student.daoimp.TeacherDaoImo;

@WebServlet("/DelTeacher")
public class DelTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TeacherDaoImo daoImo = new TeacherDaoImo();
		daoImo.deleteTeacher(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("list", daoImo.selectAllTeacher());
		request.getRequestDispatcher("/teacherlist.jsp").forward(request, response);
	}

}
