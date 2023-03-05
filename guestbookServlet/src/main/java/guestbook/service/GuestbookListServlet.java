package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;


@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//페이징 처리 - 1페이지당 2개씩
		/*
		 	   startNum	 endNum
		 PG=1	RN>=1 AND RM<=2
		 PG=2	RN>=3 AND RM<=4
		 PG=3	RN>=5 AND RM<=6
		 */
		int endNum = pg*2;
		int startNum = endNum-1;
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		ArrayList<GuestbookDTO> list = guestbookDAO.guestbookList(startNum, endNum);
		
		//총 글수
		int totalA = guestbookDAO.getTotalA();
		
		//총 페이지수
		int totalP = (totalA+1) / 2;
		/*
		 총 글수: 7
		 총 페이지 수 : 4
		 
		 총 글수 : 8
		 총 페이지 수 : 4
		 
		 1페이지당 10개의 게시글 : totalPage = (총 글수+9)/10
		 */
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<style>");
		out.println("div { float:left; width:20px; height:20px; margin-left:5px; text-align:center;}");
		out.println("#cpDiv { border:1px red solid; color:red;}");
		out.println("a {text-decoration:none;}");
		out.println("#currentPaging { color:red; }");
		out.println("#paging { color:black; }");
		out.println("</style>");
		out.println("<body>");
		
		//페이지 번호
		for(int i=1; i<=totalP; i++) {
			if(i == pg) {
				out.println("<div id='cpDiv'><a id='currentPaging' href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a></div>");
			} else {
				out.println("<div id='pDiv'><a id='paging' href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a></div>");
			}
		}
		out.println("<br><br>");
		
		if(list != null) {
			for(GuestbookDTO guestbookDTO : list) {
				out.println("<table border='1' cellpadding='5' cellspacing='0'>");
				
				out.println("<tr>"
						+ "<th width='150'>작성자</th>"
						+ "<td width='150'>"+guestbookDTO.getName()+"</td>"
						+ "<th width='150'>작성일</th>"
						+ "<td width='150'>"+guestbookDTO.getLogtime()+"</td>"
						+ "</tr>");
				
				out.println("<tr>"
						+ "<th>이메일</th>"
						+ "<td colspan=3>"+guestbookDTO.getEmail()+"</td>"
						+ "</tr>");
				
				out.println("<tr>"
						+ "<th>홈페이지</th>"
						+ "<td colspan=3>"+guestbookDTO.getHomepage()+"</td>"
						+ "</tr>");
				
				out.println("<tr>"
						+ "<th>제목</th>"
						+ "<td colspan=3>"+guestbookDTO.getSubject()+"</td>"
						+ "</tr>");
				
				out.println("<tr>"
						+ "<td colspan=4 height='150'><pre>"+guestbookDTO.getContent()+"</pre></td>"
						+ "</tr>");
				
				out.println("</table>");
				out.println("<hr style='border-color:red; width:700px; margin:10px 0;'>");
			} //for
		} //if
		
		out.println("</body>");
		out.println("</html>");
	}

}
