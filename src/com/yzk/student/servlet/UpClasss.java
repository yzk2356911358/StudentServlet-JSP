package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ClasssDaoImp;
import com.yzk.student.daoimp.StudentDaoImo;
import com.yzk.student.model.Classs;
import com.yzk.student.model.Student;

@WebServlet("/UpClasss")
public class UpClasss extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ClasssDaoImp daoImo = new ClasssDaoImp();
		Classs classs = new Classs(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
		daoImo.update(classs);
		request.setAttribute("list", daoImo.selectAll());
		request.getRequestDispatcher("/classslist.jsp").forward(request, response);
	}

}
