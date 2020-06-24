package com.javaex.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WebUtil {

//----------------------------------------------------------------------	필드

//----------------------------------------------------------------------	생성자

//----------------------------------------------------------------------	getter, setter

//----------------------------------------------------------------------	toString()

//----------------------------------------------------------------------	일반 메소드

	// 포워드
	public static void forword(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response); // request가 response를 앞으로 부를 이름, response가 가져갈 목록의 이름
	}

	// 리다이렉트
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		response.sendRedirect(url);
	}

}
