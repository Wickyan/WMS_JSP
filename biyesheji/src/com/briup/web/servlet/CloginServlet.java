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
import com.briup.bean.Customer;
import com.briup.comment.exception.AdminServiceException;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.impl.AdminDaoImp;
import com.briup.dao.impl.CustomerDaoImp;
import com.briup.serviceImp.AdminService;


@WebServlet("/CloginServlet")
public class CloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      boolean find=false;
	  	String  caccount  = request.getParameter("cin_be");
	  	String  cpassword = request.getParameter("cpass");
	  	HttpSession session = request.getSession();
	  	session.setAttribute("caccount", caccount);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvs_5?user=root&password=12345&useUnicode=true&characterEncoding=UTF8");
			String sql = "select * from customer where account=?";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, caccount);
			ResultSet rs = stat.executeQuery();
			if(!rs.first()){		
				System.out.println("asdeasd");
				response.sendRedirect("CloginFail.html");
			}else{
				System.out.println(rs.getString(2));
				if(cpassword.equals(rs.getString(2))){
					Customer customer = new Customer();
					customer.setAccount(rs.getString(1));

					customer.setPassword(cpassword);
					customer.setName(rs.getString(3));
					customer.setSex(rs.getString(4));

					customer.setAge(rs.getString(5));
					customer.setPhone(rs.getString(6));
					customer.setAddress(rs.getString(7));
					customer.setEmail(rs.getString(8));
				    session.setAttribute("customer", customer);//////////
				    System.out.println("success");
				    response.sendRedirect("CFirstLog.jsp");


				}else{
					response.sendRedirect("CloginFail.html");
				}
			}
			
			
			

			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			
		}
	  	
	  	
	  	//System.out.println("账户为："+account);
	  	//System.out.println("密码为："+password);
	  	//AdminService adminService = new AdminService();
//	  	SqlSession sqlSession = MybatisSessionFactory.getSession();
//	  	CustomerDaoImp customerDaoImp = new CustomerDaoImp();
//	  		try {
//	  		List<Customer> fCustomers =  customerDaoImp.findCustomerByName(caccount);
//	  		sqlSession.clearCache();
//	  		sqlSession.commit();
//	  		//session.close();
//	  		
//	  		//System.out.println("用户名不存在，ADS开始注册"+fCustomers);
//	          for(Customer fCustomer:fCustomers)	
//	          {   
//	  	      if( cpassword.equals(fCustomer.getPassword()))
//	  	      {
//	  	      response.sendRedirect("CFirstLog.jsp");
//	  	      System.out.println("帐号密码正确！");
//	  	      session.setAttribute("customer", fCustomer);
//	  	          find=true;
//	  		  }
//	          }
//	  		 if (fCustomers.size()==0) {
//	  			 System.out.println("用户名不存在，ADS开始注册"+fCustomers);
//	  			 response.sendRedirect("CloginFail.html");
//	  			 throw new AdminServiceException("用户名不存在！");
//	  			}
//	  		 else {
//	  			 if(find==false){
//	  				 response.sendRedirect("CloginFail.html");
//	  				 throw new AdminServiceException("密码错误！");
//	  			 }
//	  		       }
//	  			   
//	  		 } catch (Exception e) {
//	  			// TODO Auto-generated catch block
//	  			e.printStackTrace();
//	  		 }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
