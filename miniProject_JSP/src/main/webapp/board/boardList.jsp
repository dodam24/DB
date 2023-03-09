<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardPaging" %>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<% 
	//데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	 
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	List<BoardDTO> list = boardDAO.boardList(); //부모=자식(다형성)
	
	//페이징 처리
	int totalA = boardDAO.getTotalA(); //총 글수
	BoardPaging boardPaging = new BoardPaging();
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalA(totalA);
	boardPaging.makePagingHTML();
	

		
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

#currentPaging{
	color: red;
	border: 1px solid red;
	padding: 5px 8px; /* top & bottom, left & right */
	margin: 5px; /* top, right, bottom, left */
	cursor: pointer;
}

#paging{
	color: black;
	tpaddiing: 5px;
	margin: 5px;
	cursor: pointer;
	/* border: 1px solid black; */
}

</style>
</head>
<body>
<h3>
<img src="">
</h3>
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
<div style="margin-top: 15px; width: 850px; text-align: center;">
	<%=boardPaging.getPagingHTML() %>
</div>

<script type="text/javascript">
function boardPaging(pg){
	location.href="boardList.jsp?pg=" + pg;
}
</script>
</body>
</html>