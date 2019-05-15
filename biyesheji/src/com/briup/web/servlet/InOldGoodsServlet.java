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
 * Servlet implementation class InOldGoodsServlet
 */
@WebServlet("/InOldGoodsServlet")
public class InOldGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setCharacterEncoding("UTF-8");
	      
	      HttpSession  session = request.getSession();
	      
	      String InNum =  request.getParameter("Innum");
	      Integer IntInNum = Integer.valueOf(InNum);//获取的增加数量
	      System.out.println("增加的数量：" + IntInNum);

	      GoodsDaoImp goodsDaoImp = new GoodsDaoImp();
	      int goodsid = Integer.parseInt(session.getAttribute("goodsid").toString());
	      try {
			List<Goods> goodslist = goodsDaoImp.findGoodsById(goodsid);
			for (Goods goods : goodslist) {
				int GoodsNum =  goods.getNum();
				System.out.println("原来货品的个数:"+GoodsNum);
				goods.setNum(GoodsNum + IntInNum);
				System.out.println("更新货品数量");
				goodsDaoImp.updateGoods(goods);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("更新货品数量失败！！！！");
			e.printStackTrace();
		}
	      response.sendRedirect("AddGoods.jsp"); 
			System.out.println("入库成功！");
	    	  
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
