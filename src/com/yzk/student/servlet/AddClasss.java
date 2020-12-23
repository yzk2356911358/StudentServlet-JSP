package com.yzk.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ClasssDaoImp;
import com.yzk.student.model.Classs;

@WebServlet("/AddClasss")
public class AddClasss extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ClasssDaoImp daoImo = new ClasssDaoImp();
		Classs classs = new Classs(0, request.getParameter("name"));
		daoImo.insert(classs);
		request.setAttribute("list", daoImo.selectAll());
		request.getRequestDispatcher("/classslist.jsp").forward(request, response);
	}

}
