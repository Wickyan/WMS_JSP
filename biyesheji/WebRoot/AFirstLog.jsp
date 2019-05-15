<%@page import="com.briup.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员控制台</title>
<style type="text/css">
	.flex{display: flex;margin: 5% 10% 10% 10%;}
	#letf{width: 50%;height: 100%;}
	#right{width: 50%;height:100%;}
	.flex-item1{display: flex;flex-wrap: wrap;padding-top:30%;}
	.flex-item {width:50%;height: 100%;padding-top: 10%;}
	a{color:#00801A; font-family: '华文新魏', cursive;font-size:2em}
</style>
<link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />	
<link href="https://fonts.googleapis.com/css?family=Pacifico|Sofia" rel="stylesheet">
</head>

<body background="images/2.png" style="background-repeat: no-repeat;background-size:100% auto">
<%   
     Admin admin = (Admin)session.getAttribute("Admin");
      if(admin  == null){
    	System.out.println("没登录呢");
    	  %><jsp:forward page='Alogin.jsp'/><% 
      }
%>
欢迎管理员：<%=admin.getAccount() %>
<div class="flex">
<div id="letf">
	<div align="center"> <img src="images/logo.png" alt=""></div>
	<div align="center" style="padding-top: 10%"> <img src="images/1.png" alt=""></div>
</div>
<div id="right">
	
	<div class="flex-item1" >	
	<div class="flex-item" align="center"><i class="fa fas fa-paint-brush">&nbsp;<a href="AInf.jsp">修改信息</a></i></div>	
	<div class="flex-item" align="center"><i class="fa fas fa-paint-brush">&nbsp;<a href="logout.do">退出登录</a></i></div>	
	<div class="flex-item" align="center"><i class="fa fas fa-paint-brush">&nbsp;<a href="CSInf.jsp">查看用户</a></i></div>	
	<div class="flex-item" align="center"><i class="fa fas fa-paint-brush">&nbsp;<a href="GoodsInf.jsp">查看库存</a></i></div>	
	<div class="flex-item" align="center"><i class="fa fas fa-paint-brush">&nbsp;<a href="AddGoods.jsp">入库</a></i></div>	
	<div class="flex-item" align="center"><i class="fa fas fa-paint-brush">&nbsp;<a href="Goods.jsp">出库</a></i></div>	
	</div>	

</div>


</div>

</body>

</html>
