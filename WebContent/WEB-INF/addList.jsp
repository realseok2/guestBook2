<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.javaex.vo.PersonVo"%>

<%
	List<PersonVo> pList = (List<PersonVo>)request.getAttribute("personList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<body>

	<%--------------------------------------------------------------------------------%>
	<h1>Guestbook List</h1>
	<p>작성된 방명록의 목록입니다.</p>
	<%--------------------------------------------------------------------------------%>

	<form action="/gb2/gbc?action=add" method="post">
		<table border="1" width="565">

			<tbody>
				<tr>
					<td width="45">이름</td>

					<td>	<input type = "text"		name = "name">
							<input type = "hidden"		name = "action"></td>
					
					<td width="70">비밀번호</td>
					
					<td>	<input type = "password"	name = "password"></td>
				</tr>



				<tr>
					<td colspan="4"><textarea rows="11" cols="76" name="content"></textarea></td>
				</tr>

				<tr>
					<td width="45"><button type="submit">확인</button></td>
					<td colspan="3"></td>
				</tr>
			</tbody>

		</table>

	</form>

	<br>

	<form action="" method="post">
		
	<%
		for (PersonVo vo : pList) {
	%>

		<table border="1" width="565">
			<tbody>
				<tr>
					<td width="20"><%=vo.getNo()%></td>
					<td width="80"><%=vo.getName()%></td>
					<td width=auto><%=vo.getDate()%></td>
					<td width="45"><a href="/gb2/gbc?action=pwconfirm&no=<%=vo.getNo()%>&pw=<%=vo.getPw()%>"><button type="button">수정</button></a></td>
					<td width="45"><a href="/gb2/gbc?action=dform&no=<%=vo.getNo()%>"><button type="button">삭제</button></a></td>
				</tr>

				<tr height="120">
					<td colspan="5"><%=vo.getContent()%></td>
				</tr>
			</tbody>

		</table>

	</form>

	<br>

	<%
		}
	%>

</body>
</html>