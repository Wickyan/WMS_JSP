package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		session.removeAttribute("goods");

		session.removeAttribute("customer");
		session.removeAttribute("customerlist");
		session.removeAttribute("list");
		session.removeAttribute("Admin");
		session.removeAttribute("goodsid");
		session.removeAttribute("goodslist2");
		session.removeAttribute("goodslist");
		session.removeAttribute("account");
		session.invalidate();
		request.getRequestDispatcher("Alogin.jsp").forward(request, response);
	}

}
