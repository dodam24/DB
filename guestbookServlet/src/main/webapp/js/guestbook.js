function createContent(){
	document.getElementById("nameDiv").innerText = "";
	document.getElementById("emailDiv").innerText = "";
	document.getElementById("subjectDiv").innerText = "";
	document.getElementById("contentDiv").innerText = "";
	
	if(document.getElementById("name").value == ""){
		document.getElementById("nameDiv").innerText = "작성자를 입력하세요"
	}else if(document.getElementById("email").value == ""){
		document.getElementById("emailDiv").innerText = "이메일을 입력하세요"		
	}else if(document.getElementById("subject").value == ""){
		document.getElementById("subjectDiv").vinnerText = "제목을 입력하세요"
	}else if(document.getElementById("content").value == ""){
		document.getElementById("contentDiv").innerText = "내용을 입력하세요"
	}else
		document.guestbookWriteForm.submit();
}