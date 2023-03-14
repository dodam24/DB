package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService  {

	@Override
	public void execute() {
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("찾고자 하는 아이디를 입력 : ");
		String id = scan.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 없습니다.");
			return;
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		
		userDAO.delete(map);
		
		System.out.println("데이터를 삭제하였습니다.");

	}



}

/*
찾고자 하는 아이디를 입력 : angel
아이디가 없습니다.

찾고자 하는 아이디를 입력 : hhh
데이터를 삭제하였습니다.
*/
