<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


  	 <h3>菜单加载</h3>
  	<form action="dict/index.do" method="post" onSubmit="return inputNull(this)">
  		<table>
	  		<p>
				<span>姓名：</span>
				<input type="text" placeholder="姓名" name="username">
	  		</p>
	  		<p>
				<span>密码：</span>
				<input type="password" placeholder="密码" name="pwd">
	  		</p>
			<input type="submit" value="登录">	  		
  	 </form>
  	 <br>
<!--  
 <select data-placeholder="请选择服务" class="chosen-select form-control" name="id" id ="id" autocomplete="off">
	<option value="">请选择</option>
	<c:forEach items="${dbList }" var="a">
		<option value="${a.id }" label="${a.name }"></option>
	</c:forEach></select>
	-->
</body>
</html>