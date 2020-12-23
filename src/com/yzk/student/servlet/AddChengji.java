package com.yzk.student.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzk.student.daoimp.ChengjiDaoImp;
import com.yzk.student.daoimp.KechengDaoImp;
import com.yzk.student.daoimp.TeacherDaoImo;
import com.yzk.student.model.Chengji;
import com.yzk.student.model.Kecheng;
import com.yzk.student.model.Teacher;

@WebServlet("/AddChengji")
public class AddChengji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDaoImo teacherDaoImo = new TeacherDaoImo();
		ChengjiDaoImp daoImo = new ChengjiDaoImp();
		int sid = Integer.parseInt((String) request.getSession().getAttribute("sid"));
		Chengji chengji2 = new Chengji(0, sid, request.getParameter("kname"), request.getParameter("fenshu"), null);
		for (Teacher temp : teacherDaoImo.selectAllTeacher()) {
			if (temp.getKname().equals(request.getParameter("kname"))) {
				chengji2.setTeacher(temp.getName());
			}
		}
		System.out.println(chengji2);
		daoImo.insert(chengji2);
		ChengjiDaoImp chengjiDaoImp = new ChengjiDaoImp();
		ArrayList<Chengji> chengjis = new ArrayList<>();
		for (Chengji chengji : chengjiDaoImp.selectAll()) {
			if (chengji.getSid() == sid) {
				chengjis.add(chengji);
			}
		}
		request.setAttribute("list", chengjis);
		request.getRequestDispatcher("/studentChengjiList.jsp").forward(request, response);
	}

}
