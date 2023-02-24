function select(){
				document.writeForm.email2.value = documnet.writeForm.email3.value
}

function checkWrite(){
	//if(document.writeForm.name.value == "")) alert("이름을 입력하세요");
	//if(document.getElementById("name").value == "" alert("이름을 입력하세요");
	
	document.getElementById("nameDiv").innerText = "";
	document.getElementById("idDiv").innerText = "";
	document.getElementById("pwdDiv").innertext = "";
	
	if(document.getElementById("name").value == "")
			document.getElementById("nameDiv").innerText = "이름 입력";
	else if(document.getElementById("id").value == "")
			document.getElementById("idDiv").innerText = "아이디 입력";
	else if(document.getElementById("pwd").value == "")
			document.getElementById("pwdDiv").innerText = "비밀번호 입력";
	else if(document.getElementById("pwd").vlue != document.getElementById("repwd").value)
			document.getElementById("pwdDiv").innerText = "비밀번호가 맞지 않습니다.";
	else	
			document.writeForm.submit();
	
}