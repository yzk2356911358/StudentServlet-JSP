package com.yzk.student.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ChengjiDaoImp;
import com.yzk.student.model.Chengji;

/**
 * Servlet implementation class FindStudentByname
 */
@WebServlet("/FindStudentChengji")
public class FindStudentChengji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindStudentChengji() {
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
		ChengjiDaoImp chengjiDaoImp = new ChengjiDaoImp();
		ArrayList<Chengji> chengjis = new ArrayList<>();
		request.getSession().setAttribute("sid",request.getParameter("id"));
		int sid =Integer.parseInt((String) request.getSession().getAttribute("sid"));
		System.out.println(sid);
		for (Chengji chengji : chengjiDaoImp.selectAll()) {
			if (chengji.getSid() == sid) {
				chengjis.add(chengji);
			}
		}
		request.setAttribute("list", chengjis);
		request.getRequestDispatcher("/studentChengjiList.jsp").forward(request, response);

	}

}
