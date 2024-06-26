<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

wrap {
	display: grid;
	grid-template-rows: 50px auto;
	grid-template-areas: "logo" "main";
}

logo {
	grid-area: logo;
	width: 100%;
}

header img {
	width: 200px;
	height: 50px;
}

main {
	grid-area: main;
	width: 100%;
	height: 900px;
	display: flex;
	justify-content: center;
	/* 내부 요소들을 수평으로 가운데 정렬 */
}

main>div:first-child {
	margin-top: 500px;
	width: 300px;
}

main>div:nth-child(2) {
	width: 329px;
	margin-top: 200px;
}

main>div:nth-child(3) {
	width: 500px;
	margin-top: 250px;
}

input {
	width: 400px;
	height: 60px;
	background-color: #EFFFF2;
	border: none;
	border-radius: 30px;
	padding: 0 20px;
	margin-top: 20px;
	font-size: 18px;
	outline: none;
	/* 포커스 효과 제거 */
}

input::placeholder {
	color: #888;
	/* placeholder 텍스트 색상 */
}

input:focus {
	background-color: #D4F5E9;
	/* 포커스 시 배경색 변경 */
	border: 2px solid #48BB78;
	/* 포커스 시 테두리 스타일 변경 */
}

input[type="submit"] {
	width: 400px;
	height: 60px;
	background-color: #48BB78;
	color: white;
	border: none;
	border-radius: 30px;
	font-size: 18px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #38A169;
}
</style>
</head>

<body>
	<wrap> <header>
		<img src="./img/logoBus.png">
	</header>
	<main>
		<div>
			<h1>로그인</h1>
			<h2>Wellness Road</h2>
			<br>
			<h3>회원이 아니시라면</h3>
			<h3>
				<b><a href="register.jsp">여기를!</a></b>눌러 가입하세요!
			</h3>
		</div>
		<div>
			<img src="./img/loginpeople3.png">
		</div>
		<div>
			<br>
			<br>
			<form action="LoginService" method="post">
				<h1>로그인</h1>
				<input type="text" name="mem_id" id="mem_id" placeholder="Enter ID">
				<br> <input type="password" name="mem_pw" id="mem_pw"
					placeholder="password"> <br> <br></br>
				
				<p id="error-msg" style="color: red;"></p>
				
				<p style="margin-left: 260px;">
					<a href="">Forget password?</a>
				</p>
				<input type="submit" class="log_submit" value="Login">



			</form>
		</div>
	</main>
	</wrap>

	<script>
		document.querySelector('.log_submit').addEventListener(
				'click',
				function(e) {
					var idValue = document.querySelector('#mem_id').value
							.trim(); // id 입력값
					var pwValue = document.querySelector('#mem_pw').value
							.trim(); // pw 입력값

					if (idValue === '' || pwValue === '') { // id 또는 pw가 비어있을 경우
						alert('아이디와 비밀번호를 모두 입력해주세요.'); // 경고창 표시
						e.preventDefault(); // 폼 제출 막기
					}
				});
		
		 // URL에서 쿼리 문자열 가져오기
		  const urlParams = new URLSearchParams(window.location.search);
		  // 오류 메시지가 있는지 확인
		  const error = urlParams.get('error');
		  // 오류 메시지를 표시할 요소 가져오기
		  const errorMsgElement = document.getElementById('error-msg');

		  // 오류 메시지에 따라 적절한 메시지 표시
		  if (error === 'invalid_credentials') {
		    errorMsgElement.textContent = '아이디 또는 비밀번호가 잘못되었습니다.';
		  }
		
	</script>
	
	





</body>





</html>