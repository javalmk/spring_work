<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>views/fortune.jsp</title>
</head>
<body>
<%
	//request 영역에 담긴 오늘의 운세 얻어오기
	String fortuneToday=(String)request.getAttribute("fortuneToday");
%>
<p> 오늘의 운세 : <strong><%=fortuneToday %></strong></p>
</body>
</html>









