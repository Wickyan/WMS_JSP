<%@page import="com.briup.bean.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--文件头开始-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="description" content="管理员密码修改界面">
		<title>管理管理员信息</title>
<LINK href="css/main.css" rel=stylesheet>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function() {
    	if(confirm("是否修改？")) {
    		submit();
    	}
    }
});
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#regAInf").validate({
		    rules: {
			    password: {
			    	required: true,
			        minlength: 5,
			        maxlength: 15
			    },
			    password2: {
			        required: true,
			        minlength: 5,
			        equalTo: "#password"
			    },
		    },
			    password: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 5 个字母"
			    },
			    password2: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 5 个字母",
			        equalTo: "两次密码输入不一致"
			    },
			
		});
	});
</script>
<style>
.error{
	color:red;
}
</style>
</head>
	<body onLoad="MM_preloadImages('images/index_on.gif','images/reg_on.gif','images/order_on.gif','../images/top/topxmas/jp_on.gif','../images/top/topxmas/download_on.gif','../images/top/topxmas/bbs_on.gif','../images/top/topxmas/designwz_on.gif')" topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		      <table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
		         </table>
		    </td>
		  </tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
		</table>
<!--文件体开始-->
<table width="80%" cellspacing=1 cellpadding=3 align=center class=tableBorder4>
		<tr>
		<td height=25      width="100px" valign=middle bgcolor="#E4F3FF" align="center">
		
		
<a href="javascript:window.history.back()">返回修改页面</a>     
        </td><td height=25  valign=middle bgcolor="#E4F3FF" align="center">
                                     欢迎访问 <b>管理员密码修改界面</b>
        </td> </tr>
		</table>
		<br>
              
              <% 
               Admin admin = (Admin)session.getAttribute("Admin");
                if(admin  == null){
              	System.out.println("没登录呢");
              	  %><jsp:forward page='Alogin.jsp'/><% 
                }
              %>
              
<form method="post" name="regAInf" id="regAInf" action="AInfServlet">

	<table   cellpadding="3" cellspacing="1" align="center" class="tableborder3" id="table1">
<tr>
			<td valign="middle" colspan="2" align="center" height="25" color="#9999FF">
			<font color="#ffffff"><b>修改密码</b></font></td>
		</tr>
			<tr>
			<td width="40%" class="tablebody1"><b>密码(至多15位)</b>：<br>
			<br>
			
			</td>
			<td width="60%" class="tablebody1">
			<input type="password"  size="32" name="password" id="password" ><font color="#FF0000">*</font></td>
		</tr>
		<tr>
			<td width="40%" class="tablebody1"><b>确认密码(至多15位)</b>：<br>
			请再输一遍确认</td>
			<td class="tablebody1">
			<input type="password"  size="32" name="password2" ><font color="#FF0000">*</font></td>
		
		</tr>
			<tr>
			<td class="tablebody2" valign="middle" colspan="2" align="center">
			<input type="submit" value="修 改"  class="submit">&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="重置"></td>
		</tr>
	</table>
</form>	
		
	</body>
</html>