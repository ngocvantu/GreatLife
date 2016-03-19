<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<style>
ul {
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
    list-style: none;
    margin-top: 10px;
}

li {
 	float: left; 
}

li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #ddd;
}

li a.active {
    color: white;
    background-color: #4CAF50;
}
</style>
</head>
<body>
	<ul>
  <li><a id="home"  href="<%=request.getContextPath()%>">Home</a></li> 
  <li><a id="anhviet" href="<%=request.getContextPath()%>/anhviet">Anh-Việt</a></li>
  <li><a id="vietanh" href="<%=request.getContextPath()%>/vietanh">Việt-Anh</a></li>
  <li><a id="dathuoc" href="<%=request.getContextPath()%>/dathuoc">Đã thuộc</a></li>
</ul>
</body>
</html>