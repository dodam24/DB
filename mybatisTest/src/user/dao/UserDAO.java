package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;
import user.service.ArrayList;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	private static UserDAO userDAO = new UserDAO();
	
	public static UserDAO getInstance() {
		return userDAO;
	}
	
	public UserDAO() {	
			try {
				//Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
				InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();
		return list;
	}

	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();	
		return userDTO;
	}

	public void update(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //생성
		sqlSession.update("", map);
		sqlSession.commit();
		sqlSession.close();
	}


}
