<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.object.TuVung"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<%@ include file="/import.jsp" %> 
<title>Chi tiết từ vựng</title>
</head>
<body>

<%@ include file="/header.jsp" %> <hr>
		<br>
		
		Từ vựng: <c:out value="${listTuVung.tuvung }"/><br>
		Nghĩa: <c:out value="${listTuVung.nghia }"/><br>

	<%
// 		request.removeAttribute("listTuVung");
	%>
 
<hr>

<%@ include file="/footer.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#chitiet").addClass("active");
		});
	</script>
</body>
</html>