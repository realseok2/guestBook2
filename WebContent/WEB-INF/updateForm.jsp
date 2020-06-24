<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.javaex.dao.GuestbookDao" %>
<%@	page import="com.javaex.vo.PersonVo" %>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	System.out.println(no);
	
	GuestbookDao dao = new GuestbookDao();
	PersonVo vo = dao.getGuest(no);
	System.out.println(vo.toString());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>

	<h4>전화번호 수정폼</h4>
	
	<p>
		방명록의 아래 항목들을 수정하고 "수정" 버튼을 클릭하세요.
	</p>
	
	<form action = "/gb2/gbc?action=update" method = "GET">


		<table border="1" width="565">

			<tbody>
				<tr>
					<td width="45">이름</td>

					<td>	<input type = "text"		name = "name"				value	= "<%=vo.getName() %>">
							<input type = "hidden"		name = "action" 			value 	= "update">
							<input type = "hidden" 		name = "no"					value 	= "<%=no %>"></td>
					
					<td width="70">비밀번호</td>
					
					<td>	<input type = "password"	name = "password" 			value	= "<%=vo.getPw() %>"></td>
				</tr>



				<tr>
					<td colspan="4"><textarea rows="11" cols="76" name="content" ><%=vo.getContent() %></textarea></td>
				</tr>

				<tr>
					<td width="45"><button type="submit">확인</button></td>
					<td colspan="3"></td>
				</tr>
			</tbody>

		</table>
			
	</form>
	
	<h5><a href = "/gb2/gbc?action=addList">리스트 바로가기</a></h5>


</body>
</html>