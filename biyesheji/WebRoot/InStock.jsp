<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="description" content="入库表单">
		<title>入库表单</title>
		<LINK href="css/main.css" rel=stylesheet>
		<link rel="stylesheet" type="text/css" href="css/test3.css">
		
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function() {
    	if(confirm("确认入库？")){

        	submit();
    	}
    }
});
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#reg").validate({
		    rules: {
		    	goods:{
			        required: true
			     },goodsid: {
			    	required: true,
			    	digits:true,
			    },address:{
			    	
			    },price:{
			    	number:true,
			    },sort:{
			    	
			    },num:{
			    	required: true,
			    	digits:true,
			    }
			  
		    },

		    messages: {
		    	goods:{
			     },goodsid: {
			
			    	digits:"请输入正整数",
			    },address:{
			    	
			    },price:{
			    	number:"请输入正数",
			    },sort:{
			    	
			    },num:{
			    	digits:"请输入正整数",
			    },
		    
		  
			   
			}
		});
	});
</script>
<style>
.error{
	color:red;
}
</style>
		
<body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
		<%@page import="com.briup.bean.Admin"%>
	<%  
     Admin admin = (Admin)session.getAttribute("Admin");
      if(admin  == null){
    	System.out.println("没登录呢");
    	  %><jsp:forward page='Alogin.jsp'/><% 
      }
%>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		  </tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
		</table>
<!--文件体开始-->
<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25      width="100px" valign=middle bgcolor="#E4F3FF" align="center">
                <a href="AddGoods.jsp">返回入库界面</a>        
        </td>
		<td height=25 valign=middle bgcolor="#E4F3FF" align="center">
                                      <b>请输入所要添加商品信息！</b></td>
                </tr>
		</table>
              <br>
<form method="post" name="reg" id="reg"  action="/biyesheji/GoodsSaveServlet">
	<table cellpadding="3" cellspacing="1" align="center" class="tableborder11" id="table1">
		<tr>
			<td valign="middle" colspan="2" align="center" height="25" color="#9999FF">
			<font color="#ffffff"><b>新增商品</b></font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1" align="center"><b>【商品名称】</b>：<br>
			</td>
			<td width="60%" class="tablebody1">
			<input maxLength="32" size="32" name="goods" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1" align="center"><b>【商品编号】</b>：<br>
			</td>
			<td width="60%" class="tablebody1">
			<input maxLength="32" size="32" name="goodsid" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1" align="center"><b>【生产厂商】</b>：<br>
			</td>
			<td width="60%" class="tablebody1">
			<input maxLength="32" size="32" name="address" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		
		<tr>
			<td width="40%" class="tablebody1" align="center"><b>【商品价格】</b>：<br>
			</td>
			<td width="60%" class="tablebody1">
			<input maxLength="32" size="32" name="price" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1" align="center"><b>【商品类别】</b>：<br>
			</td>
			<td width="60%" class="tablebody1">
			<input maxLength="32" size="32" name="sort" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1" align="center"><b>【商品数量】</b>：<br>
			</td>
			<td width="60%" class="tablebody1">
			<input maxLength="32" size="32" name="num" style="font-family: Tahoma,Verdana,宋体; font-size: 12px; line-height: 15px; color: #000000">
			</td>
		</tr>
		<tr>
			<td class="tablebody2" valign="middle" colspan="2" align="center">
			<input type="submit" value="入库" ">&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="清 除"></td>
		</tr>
	</table>
	
</form>
	</body>
</html>