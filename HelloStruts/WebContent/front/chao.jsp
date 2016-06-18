<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	pass: <s:property value="password" />
 <s:actionerror/>
	chào bạn <span style="color:red" ><s:property value="string" /></span> nhe
	<div id="date"></div>
	<form action="radio.html" method="post">
		<input name="id" type="text" >
		<input type="submit" >
	</form>
	
	
	<script type="text/javascript">
	console.log("chao");
		document.title = "tiêu đề"
		var pathArray = window.location.pathname.split("/");
		var path = pathArray[1];
		document.body.style.background = "#f3f3f3 url('"+ window.location.protocol + "/" + path  +"/image/n6.jpg') ";
	
		var now = new Date();
		var date_str = now.toLocaleDateString();
		var cho = "con cho";
		document.getElementById("date").innerHTML = "hôm nay là: " + date_str;
		document.getElementById("date").innerHTML += "<br>chiều dài của chuỗi 'con chó'" + " là " + cho.length;
	</script>
</body>
</html>