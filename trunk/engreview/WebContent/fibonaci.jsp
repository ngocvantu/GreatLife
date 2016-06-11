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

<title>Fibonaci</title>
<style type="text/css">
table#tuvung {
	font-size: 20px;
	color: blue; 
	
}

a.linktuvung {
	text-decoration: none;
	color: #3b5998;
}

a.linktuvung:HOVER {
	text-decoration: underline;
}

.xoa{
	visibility:hidden
}
.nghia{
	visibility:hidden
}

.display{
	visibility:visible;
}

#hienthixoa{
	width: 100px;
}

#hienthinghia{
	width: 105px;
}
</style>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
		<%List<TuVung> listTuVung = (List<TuVung>)request.getAttribute("listTuVung");
		%>
		Số từ vựng fibonaci: <%=listTuVung.size() %> <br>
	<c:set var="i" value="1" scope="page" />
	<button id="hienthixoa" >Hiển thị xóa</button>
	<button id="hienthinghia" >Hiển thị nghĩa</button> <br>
	<c:forEach items="${listTuVung}"  var="tuvung" >
	 ${tuvung.tuvung } --
	</c:forEach>
	<table id="tuvung" style="width: 100%" >
	<c:forEach items="${listTuVung}"  var="tuvung" >
		<tr>
			<td style="vertical-align: bottom" ><a class="linktuvung" href="<%=request.getContextPath()%>/chitiet?id=${tuvung.id}" >${i}.  ${tuvung.tuvung }</a><hr></td>
			
			<td class="xoa" style="padding-left: 10px" ><a href="#" onclick="xoa(${tuvung.id })"  >Xóa</a><hr></td>
			
			<td class="nghia"   >
				${tuvung.nghia } . ${i} <br>
				Ví dụ 1: ${tuvung.vidu1 } <br>
				Ví dụ 2: ${tuvung.vidu2 }
				<hr>
			
			</td>
		</tr>
		
		<c:set var="i" value="${i + 1}" scope="page"/>
		
	</c:forEach>
	
	</table>
	<hr>
	 <%@ include file="/footer.jsp" %>

<% request.removeAttribute("listTuVung") ;%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#fibonaci").addClass("active");
			 
			$("#hienthinghia").click(function() {
				$(".nghia").toggleClass("display");
				$('#hienthinghia').html()==="Hiển thị nghĩa"?$('#hienthinghia').html("Tắt nghĩa"):$('#hienthinghia').html("Hiển thị nghĩa");
			});
			
			$("#hienthixoa").click(function() {
				$(".xoa").toggleClass("display");
				$('#hienthixoa').html()==="Hiển thị xóa"?$('#hienthixoa').html("Tắt xóa"):$('#hienthixoa').html("Hiển thị xóa");
			});
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