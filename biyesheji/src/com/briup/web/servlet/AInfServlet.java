package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Admin;
import com.briup.bean.SHA1;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.impl.AdminDaoImp;

/**
 * Servlet implementation class AInfServlet
 */
@WebServlet("/AInfServlet")
public class AInfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
  	   response.setCharacterEncoding("UTF-8");
  	   
	   HttpSession session = request.getSession();

       Admin admin = (Admin)session.getAttribute("Admin");

       String  password = request.getParameter("password"); 
  	   String  name = request.getParameter("name"); 
  	   String  sex = request.getParameter("sex");
  	   String  age = request.getParameter("age");
  	   String  phone = request.getParameter("phone");
  	   String  email = request.getParameter("email");
  	   String  address = request.getParameter("address");
  	   
  	  if(name != null) {
  		  	System.out.println("修改信息");
  		  admin.setName(name);
	 	   admin.setSex(sex);
	 	   admin.setAge(age);
	 	   admin.setPhone(phone);
	 	   admin.setEmail(email);
	 	   admin.setAddress(address);
  	  }
  	  else {
  		  System.out.println("修改密码");
	  		try {
	 		  password = SHA1.shaEncode(password);
	 		} catch (Exception e1) {
	 			e1.printStackTrace();
	 		}
	  		admin.setPassword(password);
  	  }
	   
	   System.out.println("AInfServlet获取的信息:"+admin);
	   SqlSession sqlSession = MybatisSessionFactory.getSession();

	   AdminDaoImp aDaoImp = new AdminDaoImp();
		try {
			aDaoImp.updateAdmin(admin);
			sqlSession.commit();
			//System.out.println(admin.toString());
			session.setAttribute("Admin", admin);
			response.sendRedirect("AInf.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}