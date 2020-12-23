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

@WebServlet("/UpChengji")
public class UpChengji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ChengjiDaoImp daoImo = new ChengjiDaoImp();
		Chengji chengji = new Chengji();
		chengji.setId(Integer.parseInt(request.getParameter("id")));
		chengji.setFenshu(request.getParameter("fenshu"));
		daoImo.update(chengji);
		int sid = Integer.parseInt((String) request.getSession().getAttribute("sid"));
		ArrayList<Chengji> chengjis = new ArrayList<>();
		for (Chengji temp : daoImo.selectAll()) {
			if (temp.getSid() == sid) {
				chengjis.add(temp);
			}
		}
		request.setAttribute("list", chengjis);
		request.getRequestDispatcher("/studentChengjiList.jsp").forward(request, response);
	}

}
