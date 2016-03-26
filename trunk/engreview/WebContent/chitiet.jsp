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
<link  rel="stylesheet" href="<%=request.getContextPath()%>/css/chitiet/chitiet.css" >
<title>Chi tiết từ vựng --</title>
</head>
<body>

<%@ include file="/header.jsp" %> <hr> 
<!-- ===============================BODY==================================== -->
		Từ vựng: <c:out value="${listTuVung.tuvung }"/><br>
		Nghĩa: <c:out value="${listTuVung.nghia }"/><br>
		<div id="chitiet_div_vocal" class="div_all all chitiet_div" >
			<button id="chitiet_btn_back" class="btn_all all chitiet_btn" onclick="back(${listTuVung.id })"  >Back</button>
			<span id="chitiet_span_vocal" class="span_all all chitiet_span" ><c:out value="${listTuVung.tuvung }"/></span>
			<button id="chitiet_btn_next" class="btn_all all chitiet_btn" onclick="next(${listTuVung.id })" >Next</button>
		</div>
		<div id="chitiet_div_stuff" class="div_all all chitiet_div" >
		<table>
			<tr>
				<td  >Ví dụ 1:</td>
				<td  ><span><c:out value="${listTuVung.vidu1 }"/></span></td>
			</tr>
			<tr>
				<td>Ví dụ 2:</td><td><span><c:out value="${listTuVung.vidu2 }"/></span></td>
			</tr>
			<tr>
				<td>Từ loại:</td><td><span><c:out value="${listTuVung.tuloai }"/></span></td>
			</tr>
			<tr>
				<td>Nơi học:</td><td><span><c:out value="${listTuVung.noihoc }"/></span></td>
			</tr>
			<tr>
				<td>Từ đồng nghĩa:</td><td><span><c:out value="${listTuVung.tudongnghia }"/></span></td>
			</tr>
			<tr>
				<td>Từ trái nghĩa:</td><td><span><c:out value="${listTuVung.tutrainghia }"/></span></td>
			</tr>
			<tr>
				<td>Ngày nhập:</td><td><span><c:out value="${listTuVung.ngaynhap }"/></span></td>
			</tr>
			<tr>
				<td>Ghi chú:</td><td><span><c:out value="${listTuVung.ghichu }"/></span></td>
			</tr>
		</table>
		</div>
		
		
<!-- ===============================BODY==================================== -->
<hr>

<%@ include file="/footer.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#chitiet").addClass("active");
		});
		
		function next(id) {
			window.location.href="<%=request.getContextPath()%>" + "/chitiet?id=" + (id + 1) ;
		}
		
		function back(id) {
			window.location.href="<%=request.getContextPath()%>" + "/chitiet?id=" + (id - 1) ;
		}
	</script>
</body>
</html>