<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js" ></script>
<script type="text/javascript">
$( document ).ready(function(){ 
	$("#anhviet").addClass("active");
}); 
</script>
<title>Anh Việt</title>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
		<%=request.getAttribute("khong") %>
	
	<hr>
	 <%@ include file="/footer.jsp" %>
	  
</body>
</html>