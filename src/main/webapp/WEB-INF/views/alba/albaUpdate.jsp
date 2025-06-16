<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>회원 수정</h1>
<body>
<form method="post" action="/alba/albaUpdate.do">
<br><hr/><br>
	아이디 : <input type="text" name="alId" value="${alba.alId }" readonly><br><hr/><br>
	이름 : <input type="text" name="alName" value="${alba.alName}"><br><hr/><br>
	나이 : <input type="number" name="alAge" value="${alba.alAge }"><br><hr/><br>
	우편번호 : <input type="text" name="alZip" value="${alba.alZip }"><br><hr/><br>
	상세주소1 : <input type="text" name="alAdd1" value="${alba.alAdd1 }"><br><hr/><br>
	상세주소2 : <input type="text" name="alAdd2" value="${alba.alAdd2 }"><br><hr/><br>
	핸드폰번호 : <input type="text" name="alHp" value="${alba.alHp }"><br><hr/><br>
	<c:if test="${alba.alGen eq 'M'}">
			<input type="radio" name="alGen" value="M" checked/>남성 
			<input type="radio" name="alGen" value="F"/>여성 
	</c:if>
	<c:if test="${alba.alGen eq 'F'}">
		<input type="radio" name="alGen" value="M" />남성 
		<input type="radio" name="alGen" value="F" checked/>여성 
	</c:if> <br><hr/><br>
	이메일 : <input type="email" name="alMail" value="${alba.alMail }"><br><hr/><br>
	경력사항 : <input type="text" name="alCareer" value="${alba.alCareer }"><br><hr/><br>
	특기사항 : <input type="text" name="alSpec" value="${alba.alSpec }"><br><hr/><br>
	비고 : <input type="text" name="alDesc" value="${alba.alDesc }"><br><hr/><br>
	
<div class="form-group">
            	<label calss="form-label" for="">프로필사진</label>
           		<input type="file", name="alImg", id="alImg" accept="image/*"/>;
            	 <form:errors path="alImg" cssClass="text-danger"/>
            </div>
            <br><hr/><br>
	학력코드 : 
	<select name="grCode">
		<option value="G001">고졸</option>
		<option value="G002">초대졸</option>
		<option value="G003">대졸</option>
		<option value="G005">석사</option>
		<option value="G006">학사</option>
	</select>
	<br><hr/><br>
	<button type="submit">수정완료</button>
	</form>
</body>
</html>