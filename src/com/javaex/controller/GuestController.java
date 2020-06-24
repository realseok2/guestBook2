package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;

@WebServlet("/gbc") // 주소창에 들어 갈 이름
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		System.out.println("/pbc --> doGet()"); // 중간 확인용 코드

//-----------------------------------------------------------------------------------------------

		String action = request.getParameter("action");

		// 리스트 출력 요청시--------------------------------------------------------------------------
		if ("addList".equals(action)) {
			System.out.println("addList"); // 중간 확인용 코드

			GuestbookDao dao = new GuestbookDao();
			List<PersonVo> pList = dao.getPersonList();

			// 포워드 작업
			// 데이터를 request에 추가
			request.setAttribute("personList", pList);

			// forword하는 방법
			WebUtil.forword(request, response, "/WEB-INF/addList.jsp");

			// 신규 등록 요청시------------------------------------------------------------------------

		} else if ("add".equals(action)) {
			System.out.println("새 게시물 등록");

			String name		= request.getParameter("name");
			String pw		= request.getParameter("password");
			String content	= request.getParameter("content");

			PersonVo vo = new PersonVo(name, pw, content);
			System.out.println(vo);

			GuestbookDao dao = new GuestbookDao();
			dao.guestBookInsert(vo);

			// reDirect
			WebUtil.redirect(request, response, "/gb2/gbc?action=addList");

			
			// 게시물 수정 요청시-----------------------------------------------------------------------
		} else if ("pwconfirm".equals(action)) {
			System.out.println("방명록 수정 비밀번호 확인폼");
			
			WebUtil.forword(request, response, "/WEB-INF/pwconfirm.jsp");
			
		} else if ("uform".equals(action)) {
			System.out.println("방명록 수정폼");
//			int id = Integer.parseInt(request.getParameter("no"));
//			String pw = request.getParameter("pw");
			WebUtil.forword(request, response, "/WEB-INF/updateForm.jsp");
			
		} else if ("update".equals(action)) {	

			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			String pw = request.getParameter("password");
			String content = request.getParameter("content");
			
			PersonVo vo = new PersonVo(no, name, pw, content);
			System.out.println(vo.toString());
			
			GuestbookDao dao = new GuestbookDao();
			dao.guestBookUpdate(vo);
			
			WebUtil.redirect(request, response, "/gb2/gbc?action=addList");
			
			// 게시물 삭제 요청시----------------------------------------------------------------------

		} else if ("dform".equals(action)) {
			System.out.println("방명록 삭제폼");

			WebUtil.forword(request, response, "/WEB-INF/deleteForm.jsp");

		} else if ("delete".equals(action)) {
			int no = Integer.parseInt(request.getParameter("no"));
			String pw = request.getParameter("password");

			GuestbookDao dao = new GuestbookDao();
			dao.guestBookDelete(no, pw);

			WebUtil.redirect(request, response, "/gb2/gbc?action=addList");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
