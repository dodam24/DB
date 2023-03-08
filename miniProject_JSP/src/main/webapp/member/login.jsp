<%@ page import="member.dao.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>

<%
	//데이터
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(memberDTO == null) {
	//페이지 이동
	response.sendRedirect("loginFail.jsp");
	
}else { 	
	//세션 (쿠키보다 세션을 더 많이 이용)
	//HttpSession session = request.getSession(); //JSP는 세션이 이미 내장객체로 존재하므로, session을 또 생성할 필요 없음
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);
	session.setAttribute("memPwd", pwd);
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2()); //login.jsp는 set으로 세션 만들기
	
	//페이지 이동
	response.sendRedirect("loginOk.jsp");
} %>
</body>
</html>