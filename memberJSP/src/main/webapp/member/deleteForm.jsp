<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
<title>Insert title here</title>
div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="deleteForm" method="post" action="delete.jsp">
<table>
	<tr>
		<th>비밀번호 입력 : </th>
		<td>
			<input type="password" name="pwd" id="pwd">
			<input type="button" value="검색" onclick="checkPwd()">
			<div id="pwdDiv"></div>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
function checkPwd(){
	if(pwd != memberDTO.getPwd()){
		document.getElementById("pwd").
		else{
			document.deleteForm.submit();
		}
	}
}
</script>
</body>
</html>