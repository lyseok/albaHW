<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>회원 등록</h1>
<body>
	<form action="/alba/albaInsert.do" method="post"><br><hr/><br>
	아이디 : <input type="text" name="alId" palcaholder="" ><br><hr/><br>
	이름 : <input type="text" name="alName" palcaholder="" ><br><hr/><br>
	나이 : <input type="number" name="alAge" palcaholder="" ><br><hr/><br>
	우편번호 : <input type="text" name="alZip" palcaholder="" ><br><hr/><br>
	상세주소1 : <input type="text" name="alAdd1" palcaholder="" ><br><hr/><br>
	상세주소2 : <input type="text" name="alAdd2" palcaholder="" ><br><hr/><br>
	핸드폰번호 : <input type="text" name="alHp" palcaholder="" ><br><hr/><br>
	성별 : <input type="radio" name="alGen" >남
	<input type="radio" name="alGen" >여<br><hr/><br>
	이메일 : <input type="email" name="alMail" palcaholder="" ><br><hr/><br>
	경력사항 : <input type="text" name="alCareer" palcaholder="" ><br><hr/><br>
	특기사항 : <input type="text" name="alSpec" palcaholder="" ><br><hr/><br>
	비고 : <input type="text" name="alDesc" palcaholder="" ><br><hr/><br>
	프로필사진 : <input type="file" name="alImg" palcaholder="" ><br><hr/><br>
	학력코드 : 
	<select name="alCode">
		<option value="g001">고졸</option>
		<option value="g002">초대졸</option>
		<option value="g003">대졸</option>
		<option value="g004">석사</option>
		<option value="g005">학사</option>
	</select>
	<br><hr/><br>
	<button type="submit">가입완료</button>
	</form>
</body>
</html>