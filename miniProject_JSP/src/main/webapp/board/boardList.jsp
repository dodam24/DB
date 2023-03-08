<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<% 
	//데이터
	 
	
	//페이징 처리
	int pg = Integer.parseInt(request.getParameter("pg"));

	int endNum = pg*5;
	int startNum = endNum-4;
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> list = boardDAO.boardList(startNum, endNum); //부모=자식(다형성)
	//ArrayList<BoardDTO> list = boardDAO.boardList(); 1:1관계 
	
	
	//총 글수
	int totalA = boardDAO.getTotalA();
	
	
	//총 페이지수
	int totalP = (totalA+4) / 5;
	//1페이지당 5개의 게시글 : totalPage = (총 글수+4)/5
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.subjectA:link { color: black; text-decoration: none; }
.subjectA:visited { color: black; text-decoration: none; }
.subjectA:hover { color: green; text-decoration: underline; }
.subjectA:active { color: black; text-decoration: none; }
</style>
</head>
<body>
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th> <!--   링크 -> 글 확인   -->
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>
	
	<%if(list != null){ %>
		<%for(BoardDTO boardDTO : list) { %>
			<tr>
				<td align="center"><%=boardDTO.getSeq() %></td>
				<td><a class="subjectA" href=""><%=boardDTO.getSubject() %></a></td>
				<td align="center"><%=boardDTO.getId() %></td>
				<td align="center"><%=boardDTO.getHit() %></td>
				<td align="center">
					<%=new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime())%></td>
			</tr>
		<%} //for %>
	<%} //for %>
</table>
<img src="../image/img.jpeg" width="50" height="50" alt="라인" 
onclick="location.href='../index.jsp'" style="cursor: pointer;">
</body>
</html>