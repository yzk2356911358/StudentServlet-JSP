package com.yzk.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.StudentDaoImo;
import com.yzk.student.daoimp.TeacherDaoImo;
import com.yzk.student.model.Student;
import com.yzk.student.model.Teacher;

@WebServlet("/AddTeacher")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDaoImo daoImo = new TeacherDaoImo();
		Teacher teacher = new Teacher(0, request.getParameter("name"), request.getParameter("gender"),
				Integer.parseInt(request.getParameter("age")), request.getParameter("kname"));
		daoImo.insertTeacher(teacher);
		request.setAttribute("list", daoImo.selectAllTeacher());
		request.getRequestDispatcher("/teacherlist.jsp").forward(request, response);
	}

}
