<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js" ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js" ></script>
<link  rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css" >
<script type="text/javascript">
$( document ).ready(function(){
	$("#btntest").click(function(){
		alert("asdf");
		$.ajax({
		    url: '<%=request.getContextPath()%>/listvocal',
		    data: "kjh",
		    type: 'post',
		    dataType:'text',
		    success: function(data){ 
		        console.log(data);
		        alert(data);
		    }
		});
	});
});

</script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<hr>
	hello review
	<a href="<%=request.getContextPath()%>/nhaptuvung" >list vocal</a>
	<div id="divtest" ></div>
	<button id="btntest" >Test ajax</button>
	
	<!-- FORM NHAP TU VUNG -->
	<form action="<%=request.getContextPath()%>/nhaptuvung" method="post" >
		<table>
			<tr>
				<td>Từ vựng:</td>
				<td><input id="tuvung" name="tuvung" type="text" size="50" autofocus ></td>
			</tr>
			<tr>
				<td>Nghĩa:</td>
				<td><input id="nghia" name="nghia" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ví dụ 1:</td>
				<td><input id="vidu1" name="vidu1" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ví dụ 2:</td>
				<td><input id="vidu2" name="vidu2" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Từ loại:</td>
				<td><input id="tuloai" name="tuloai" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Nơi học:</td>
				<td><input id="noihoc" name="noihoc" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Từ đồng nghĩa:</td>
				<td><input id="tudongnghia" name="tudongnghia" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Từ trái nghĩa:</td>
				<td><input id="tutrainghia" name="tutrainghia" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ngày nhập:</td>
				<td><input id="ngaynhap" name="ngaynhap" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ghi chú:</td>
				<td><input id="ghichu" name="ghichu" type="text" size="50"></td>
			</tr>
		</table> 
		<input type="submit" value="Nhập" >
	</form>


	<hr>
	 <%@ include file="/footer.jsp" %>
</body>
</html>

