package com.javaex.dao;

import com.javaex.vo.PersonVo;

public class PhoneTest {

	public static void main(String[] args) {

		GuestbookDao dao = new GuestbookDao();
		/*
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());
		*/
		
		/*
		PersonVo personVo = new PersonVo("김범수", "010-1111-1111", "02-2222-2222");
		phoneDao.personInsert(personVo);
		*/
		
		PersonVo vo = new PersonVo(5, "ㄴㅁㅇㅁㄴ", "123", "123123");
		
		dao.guestBookUpdate(vo);
		
		
	}

}
