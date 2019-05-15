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
 * Servlet implementation class GoodsDel
 */
@WebServlet("/GoodsDel")
public class GoodsDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
 @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 request.setCharacterEncoding("UTF-8");
	   response.setCharacterEncoding("UTF-8");
	   
	   HttpSession session = request.getSession();

       List<Goods> goodslist =(List<Goods>) session.getAttribute("goodslist2");
       Goods goods = goodslist.get(0);

       System.out.println(goods);
       SqlSession sqlSession = MybatisSessionFactory.getSession();
	   GoodsDaoImp goodsDaoImp = new GoodsDaoImp();
//	   
//	   PrinterWrite out = response.getPinterWrite();
//	   out.println("<script> alert('XXXXX');</script>");
	   
		try {
			goodsDaoImp.deleteGoods(goods);
			sqlSession.commit();

			System.out.println("删除成功");
			response.sendRedirect("GoodsInf.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
 }

}
