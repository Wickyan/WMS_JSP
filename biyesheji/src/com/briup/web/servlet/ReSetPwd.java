package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.common.MybatisSessionFactory;
import com.briup.dao.impl.CustomerDaoImp;

/**
 * Servlet implementation class ReSetPwd
 */
@WebServlet("/ReSetPwd")
public class ReSetPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  	//HttpSession session = request.getSession();
	    String aa = (String) request.getParameter("caccount");//////////
	    System.out.println(aa);
	    
	    SqlSession sqlSession = MybatisSessionFactory.getSession();
		   HttpSession session = request.getSession();
		   CustomerDaoImp customerDaoImp = new CustomerDaoImp();
			try {
				customerDaoImp.updateCPwd(aa);
				sqlSession.commit();

				//System.out.println(customer.toString());
				response.sendRedirect("CSInf.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		//session.removeAttribute("caccount");
	}

}
