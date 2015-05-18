package com.sds.icto.mysite.dao;

import java.sql.SQLException;

import com.sds.icto.mysite.vo.MemberVo;

public class daotest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String name = "이은호";
		String email = "0eunse0@hanmail.net";
		String password = "!234";
		String gender = "male";
		
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPassword(password);
		vo.setGender(gender);
		
		MemberDao dao = new MemberDao();
		try {
			dao.insert(vo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
