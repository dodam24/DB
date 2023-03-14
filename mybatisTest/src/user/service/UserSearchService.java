package user.service;

import java.util.Scanner;

import user.dao.UserDAO;

public class UserSearchService implements UserService  {

	@Override
	public void execute() {
	
	Scanner scan = new Scanner(System.in);
	System.out.print("이름 검색");
	String name =scan.next();
	
	UserDAO userDAO = UserDAO.getInstance();


		
	}



}

/*
1. 이름 검색
2. 아이디 검색
번호 입력 : 1

1번인 경우
찾고자 하는 이름 입력 : 홍

이름		아이디	비밀번호
홍길동
홍당무

1번인 경우
찾고자 하는 아이디 입력 : n

이름		아이디	비밀번호
		hong
		conan
		
이름으로 검색하건 또는 아이디로 검색하건 무조건 userDAO.search(~~)를 호출한다.
*/