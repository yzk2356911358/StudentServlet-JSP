package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.StudentDaoImo;
import com.yzk.student.model.Student;

@WebServlet("/UpStudent")
public class UpStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StudentDaoImo daoImo = new StudentDaoImo();
		Student student = new Student(Integer.parseInt(request.getParameter("number")), request.getParameter("name"),
				request.getParameter("gender"), Integer.parseInt(request.getParameter("age")),
				request.getParameter("classs"), request.getParameter("major"));
		daoImo.updateStudent(student);
		request.setAttribute("list", daoImo.selectAllStudent());
		request.getRequestDispatcher("/studentlist.jsp").forward(request, response);
	}

}
