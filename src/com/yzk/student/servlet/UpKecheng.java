package com.yzk.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.KechengDaoImp;
import com.yzk.student.model.Kecheng;

@WebServlet("/UpKecheng")
public class UpKecheng extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		KechengDaoImp daoImo = new KechengDaoImp();
		Kecheng kecheng = new Kecheng(Integer.parseInt(request.getParameter("id")), request.getParameter("name"));
		daoImo.update(kecheng);
		request.setAttribute("list", daoImo.selectAll());
		request.getRequestDispatcher("/kechenglist.jsp").forward(request, response);
	}

}
