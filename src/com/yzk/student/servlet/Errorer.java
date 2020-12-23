package com.yzk.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Error
 */
@WebServlet("/Errorer")
public class Errorer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Error</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2 align=center>" + request.getAttribute("err") + "</h2>");
			response.setHeader("refresh", "3;url='login.jsp'");
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("请登录！页面将在3秒后自动跳转，如果没有，请点击<a href='login.jsp'>回到登录页面</a>");
			out.println("</body>");
			out.println("</html>");

		} finally {
			out.close();

		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}