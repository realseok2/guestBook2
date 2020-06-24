<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int no = Integer.parseInt(request.getParameter("no"));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Confirm</title>
</head>
<body>

	<h4>방명록 수정</h4>

	<p>
		방명록을 수정하려면 작성시 사용하였던 비밀번호를 입력하세요. <br>
		비밀번호를 입력 후 "확인" 버튼을 클릭하세요.
	</p>
	
	<form action = "/gb2/gbc?action=uform" method = "post">
		비밀번호(Password)	:	<input type = "password"	name = "password">
							<input type = "hidden"		name = "no"			value = "<%=no %>">
							<input type = "hidden"		name = "actionn"	value = "uform">
		<button type = "submit">확인</button><br>

	</form>

	<a href="/gb2/gbc?action=addList">메인으로 돌아가기</a>


</body>
</html>