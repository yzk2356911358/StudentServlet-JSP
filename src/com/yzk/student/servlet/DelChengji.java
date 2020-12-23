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

@WebServlet("/DelChengji")
public class DelChengji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelChengji() {
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
		ChengjiDaoImp daoImo = new ChengjiDaoImp();
		daoImo.delete(Integer.parseInt(request.getParameter("id")));
		ChengjiDaoImp chengjiDaoImp = new ChengjiDaoImp();
		ArrayList<Chengji> chengjis = new ArrayList<>();
		int sid =Integer.parseInt((String) request.getSession().getAttribute("sid"));
		for (Chengji chengji : chengjiDaoImp.selectAll()) {
			if (chengji.getSid() == sid) {
				chengjis.add(chengji);
			}
		}
		request.setAttribute("list", chengjis);
		request.getRequestDispatcher("/studentChengjiList.jsp").forward(request, response);
	}

}
