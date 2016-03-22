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

	a.linktuvung{
	text-decoration: none;
	color: #3b5998;
	}
	
	a.linktuvung:HOVER {
	text-decoration: underline;	
}
</style>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
		<%List<TuVung> listTuVung = (List<TuVung>)request.getAttribute("listTuVung"); %>
		Số từ vựng: <%=listTuVung.size() %>
	<table id="tuvung" style="width: 100%" >
	<c:forEach items="${listTuVung}"  var="tuvung" >
		<tr>
			<td><a class="linktuvung" href="<%=request.getContextPath()%>/chitiet?id=${tuvung.id}" > ${tuvung.tuvung }</a></td>
			<td style="padding-left: 30px" ><a href="#" onclick="xoa(${tuvung.id })"  >Xóa</a></td>
			<td style="text-align: right;" >${tuvung.nghia }</td>
		</tr>
	</c:forEach>
	</table>
	<hr>
	 <%@ include file="/footer.jsp" %>

<% request.removeAttribute("listTuVung") ;%>
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
			    	window.location.href = "/engreview/anhviet"; 
			    }
			});	
		}
	</script>
	
	
</body>
</html>