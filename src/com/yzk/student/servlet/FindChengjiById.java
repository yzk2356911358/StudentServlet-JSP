package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ChengjiDaoImp;

@WebServlet("/FindChengjiById")
public class FindChengjiById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindChengjiById() {
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
		ChengjiDaoImp daoImo = new ChengjiDaoImp();
		request.setAttribute("chengji", daoImo.selectById(Integer.parseInt(request.getParameter("id"))));
		request.getRequestDispatcher("/upchengji.jsp").forward(request, response);
	}

}
