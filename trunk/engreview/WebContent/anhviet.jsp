<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/import.jsp" %> 

<title>Anh Việt</title>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
		<%=request.getAttribute("sizeTuVung") %>
	
	<hr>
	 <%@ include file="/footer.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#anhviet").addClass("active");
		});
	</script>
</body>
</html>