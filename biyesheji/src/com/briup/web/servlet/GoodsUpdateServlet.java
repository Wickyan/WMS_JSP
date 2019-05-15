package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Goods;
import com.briup.common.MybatisSessionFactory;
import com.briup.dao.impl.GoodsDaoImp;

/**
 * Servlet implementation class GoodsUpdateServlet
 */
@WebServlet("/GoodsUpdateServlet")
public class GoodsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(request, response);
		
		 request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");
		    

			   HttpSession session = request.getSession();
			   

		       List<Goods> goodslist =(List<Goods>) session.getAttribute("goodslist2");
		       int goodsid = goodslist.get(0).getGoodsid();
		       String goodsname = goodslist.get(0).getName();
		  	  // int  goodsid = (int) session.getAttribute("goodsid");
		  	   String  address = request.getParameter("address"); 
		  	   String  price = request.getParameter("price");
		  	   String  sort = request.getParameter("sort");
		  	   int  num = Integer.parseInt(request.getParameter("num"));

		  	   Goods goods = new Goods();

		  	   goods.setName(goodsname);
		  	   goods.setAddress(address);
		  	   goods.setGoodsid(goodsid);
		  	   goods.setPrice(price);
		  	   goods.setSort(sort);
		  	   goods.setNum(num);
		  	   
		  	   
			   System.out.println("GoodsUpdateServlet获取的信息:"+goods.toString());
			   SqlSession sqlSession = MybatisSessionFactory.getSession();
			   GoodsDaoImp goodsDaoImp = new GoodsDaoImp();
				try {
					goodsDaoImp.updateGoodsAll(goods);
					sqlSession.commit();

					//System.out.println(customer.toString());
					session.setAttribute("goods",goods);
					response.sendRedirect("GoodsInf.jsp");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	

}
