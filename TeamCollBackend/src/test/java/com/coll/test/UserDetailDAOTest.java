package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDetailDAO;
import com.coll.model.UserDetail;

public class UserDetailDAOTest {
	static UserDetailDAO userdetailDAO;

	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
	
	
	@Test
	public void addusertest() 
	{
		UserDetail user=new UserDetail();
		user.setUsername("Saravana");
		user.setFirstname("saran");
		user.setLastname("shan");
		user.setPassword("saran*487");
		user.setEmailId("saran@gmail.com");
		
		assertTrue("problem in adding user",userdetailDAO.addUser(user));
	}
	
	@Ignore
	@Test
	public void getusertest() {
		assertNotNull("problem in getting user",userdetailDAO.getUser("pavithra"));
	}
	@Ignore
	@Test
	public void updateusertest() {
		UserDetail user=userdetailDAO.getUser("saran");
		user.setRole("ROLE_ADMIN");
		assertTrue("problem in updating user",userdetailDAO.updateUser(user));
	}
	@Ignore
	@Test
	public void listusertest() {
		List<UserDetail> listUsers=userdetailDAO.getUsers();
		for(UserDetail user:listUsers) {
			System.out.println("username:"+user.getUsername());
		}
	}
	@Ignore
	@Test
	public void checkusertest() {
		assertTrue("problem in checking user",userdetailDAO.checkUser("pavi","pavi"));
	}

}
