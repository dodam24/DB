package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class UpdateMain {
	private Connection conn; // 접속
	private PreparedStatement pstmt; // 가이드
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##jAVA";
	private String password = "1234";
	
	
	public UpdateMain() { // 드라이버 로딩
		try {
			Class.forName(driver);
//			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void getConnection() { // 접속
		try {
			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void UpdateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름 입력 : ");
		String name = scan.next();
		//------------------------------------ 데이터 입력 받는 것은 여기까지!
		
		this.getConnection(); // 접속
		
		String sql = "UPDATE DBTEST SET AGE=AGE+1, HEIGHT=HEIGHT+1 WHERE NAME LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			int su = pstmt.executeUpdate();
			System.out.println(su + "행 이(가) 업데이트 되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		UpdateMain um = new UpdateMain();
		um.UpdateArticle();

	}

}

/*
검색 할 이름 입력 : 홍

이름에 홍이 들어간 레코드를 나이 1 증가, 키도 1 증가 하시오
*/