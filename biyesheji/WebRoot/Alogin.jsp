<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>仓库管理员登录</title>
<link rel="stylesheet" type="text/css" href="css/test3.css">


<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function() {
     // alert("提交事件!");
     submit();
    }
});
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#Alogin").validate({
		    rules: {
		    	in_be: {
			        required: true,
			        minlength: 3,
			     },
			    pass: {
			    	required: true,
			        minlength: 5,
			        maxlength: 15
			    }
			  
		    },

		    messages: {
		    	in_be:{
			        required: "请输入用户名",
			        minlength: "用户名不小于三个字符",

			    },
			    pass: {
			        required: "&nbsp&nbsp&nbsp&nbsp请输入密码",
			        minlength: "&nbsp&nbsp&nbsp&nbsp密码长度不能小于 5 个字母"
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
</head>
<body >
   <div class="di" >
   <form method="post" name="Alogin" id ="Alogin"action="/biyesheji/AloginServlet">
	   <table>
		   <tr>
			   <div class="d0">
			   		<p align="center">管理员登录</p>
			   </div>
		      
			  	<div class="d1">
			        <input name="in_be" value="" placeholder="&nbsp&nbsp&nbsp请输入管理员帐号">
			   </div>
			   
			    <div class="d2"> 
			           <input name="pass" value="" type="password" placeholder="&nbsp&nbsp&nbsp请输入管理员密码">
			    </div>
			    
			    <div class="d4">
			  
			        <button class="but" type="submit" >登录</button>
			    </div>
			    
		      	<div class="d5">
		             <span class="hui"></span>
		        	<a href="Aregister.jsp">立即注册 </a>  
		     	 </div>
		     </tr>
	     </table> 
     </form>
   </div>
   
</body>
</html>