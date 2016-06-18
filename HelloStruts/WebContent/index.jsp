<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.tdLabel {
	text-align: right;
}

body {
	width: 700px;
	margin: 0px auto;
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<s:form action="getchao" >
		<s:textfield name="name" id="name" placeholder="tunguyen" label="Tên của bạn" ></s:textfield> 
		<s:password  name="password" label="Mật khẩu của pạn" ></s:password>
		<s:submit></s:submit>
	</s:form>  
</body>
</html>