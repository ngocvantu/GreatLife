<%@page import="java.util.List"%>
<%@page import="com.object.TuVung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/import.jsp" %> 

<title>Anh Việt</title>
<style type="text/css">
	table#tuvung {
	font-size: 20px;
	color: blue;
}

</style>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
		<%List<TuVung> listTuVung = (List<TuVung>)request.getAttribute("listTuVung"); %>
	<table id="tuvung" >
	<c:forEach items="${listTuVung}"  var="tuvung" >
		<tr>
			<td>${tuvung.tuvung }</td>
			<td style="padding-left: 30px" ><a href="" onclick="xoa(${tuvung.id })"  >Xóa</a></td>
		</tr>
	</c:forEach>
	</table>
	<hr>
	 <%@ include file="/footer.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#anhviet").addClass("active");
		});
		function xoa(id) {
			$.ajax({
			    url: '<%=request.getContextPath()%>/anhviet',
			    data: "ma=xoa&&id="+ id,
			    type: 'post',
			    dataType:'text',
			    success: function(data){ 
			    }
			});	
		}
	</script>
</body>
</html>