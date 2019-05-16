package com.briup.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Admin;
import com.briup.bean.SHA1;
import com.briup.comment.exception.AdminServiceException;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.AdminDao;
import com.briup.dao.impl.AdminDaoImp;
import com.briup.serviceImp.AdminService;


@WebServlet("/AloginServlet")
public class AloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
    boolean find=false;
	String  account  = request.getParameter("in_be");
	String  password = request.getParameter("pass");
	try {
		   password = SHA1.shaEncode(password);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
	HttpSession session = request.getSession();
	session.setAttribute("account", account);
	//System.out.println("账户为："+account);
	//System.out.println("密码为："+password);
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvs_5?user=root&password=12345&useUnicode=true&characterEncoding=UTF8");
		String sql = "select * from admin where account=?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, account);
		ResultSet rs = stat.executeQuery();
		if(!rs.first()){		
			System.out.println("asdeasd");
			response.sendRedirect("AloginFail.html");
		}else{
			System.out.println(rs.getString(2));
			if(password.equals(rs.getString(2))){
				Admin admin = new Admin();
				admin.setAccount(rs.getString(1));

			 	admin.setPassword(password);
				admin.setName(rs.getString(3));
			 	admin.setSex(rs.getString(4));

			 	admin.setAge(rs.getString(5));
			 	admin.setPhone(rs.getString(6));
			 	admin.setAddress(rs.getString(7));
			 	admin.setEmail(rs.getString(8));
			    session.setAttribute("Admin", admin);
			    System.out.println("success");
			    response.sendRedirect("AFirstLog.jsp");


			}else{
				response.sendRedirect("AloginFail.html");
			}
		}
		
		
		

		rs.close();
		stat.close();
		conn.close();
		
		
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}finally{
		
	}
	
	
	
//	AdminService adminService = new AdminService();
//	SqlSession sqlSession = MybatisSessionFactory.getSession();
//	AdminDaoImp aDaoImp = new AdminDaoImp();
//		try {
//		   List<Admin> fadmin = aDaoImp.findAdminByName(account);
//		    sqlSession.clearCache();
//		    sqlSession.commit();
//		//session.close();
//		
//		System.out.println("下面开始比较账号和密码"+fadmin);
//        for(Admin fAdmin2:fadmin)	
//        {   
//	      if( password.equals(fAdmin2.getPassword()))
//	      {
//		      response.sendRedirect("AFirstLog.jsp");
//		      session.setAttribute("Admin", fAdmin2);
//		      System.out.println("帐号密码正确！");
//	          find=true;
//		  }
//        }
//		 if (fadmin.size()==0) {
//			 System.out.println("用户名不存在"+fadmin);
//			 response.sendRedirect("AloginFail.html");
//			 throw new AdminServiceException("用户名不存在！");
//			}
//		 else {
//			 if(find==false){
//				 response.sendRedirect("AloginFail.html");
//				 throw new AdminServiceException("密码错误！");
//			 }
//		       }
//			   
//		 } catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		 }
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
