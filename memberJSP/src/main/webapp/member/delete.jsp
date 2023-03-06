<%@ page import="member.dao.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	//데이터
	String id = (String)session.getAttribute("memId");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>삭제되었습니다.</h3>
	
</body>
</html>