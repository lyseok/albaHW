<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<main class="container">
<a href="/alba/albaList.do">
<h4>알바 목록 조회</h4>
</a>
    <div class="row mb-3">
        <div class="col-md-6">
            <form action="/alba/searchAlba.do" method="get" class="d-flex">
            <select id="grCode" name="grCode" class="form-select">
				<option value="">학력 선택</option>
			</select>
			<select id="licCode" name="licCode" class="form-select">
				<option value="">자격증 선택</option>
			</select>
			<input type="radio" name="alGen" value="M" checked/>남성
			<input type="radio" name="alGen" value="F"/>여성
                <input type="text" name="alName" placeholder="이름"/>
                <input type="text" name="alAdd1" placeholder="지역"/>
                <input type="text" name="alCareer" placeholder="경력사항"/>
                <button type="submit" class="btn btn-primary">검색</button>
            </form>
        </div>
    </div>
<table class="table">
	<thead>
		<tr>
			<th>사진</th>
			<th>이름</th>
			<th>나이</th>
			<th>휴대폰</th>
			<th>학력</th>
			<th>성별</th>
			<th>이메일</th>
			<th>경력사항</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${not empty albaList }">
				<c:forEach items="${albaList }" var="alba">
					<c:url value="/alba/albaView.do" var="detailURL">
						<c:param name="who" value="${alba.alId }"/>
					</c:url>
					<tr>
						<td>${alba.alImg }</td>
						<td>
						<a href="${detailURL }">${alba.alName }</a>
						</td>
						<td>${alba.alAge }</td>
						<td>${alba.alHp }</td>
						<td>${alba.grade.grName }</td>
					<c:if test="${alba.alGen eq 'M'}">
						<td>남성</td>
					</c:if>
					<c:if test="${alba.alGen eq 'F'}">
						<td>남성</td>
					</c:if>
						<td>${alba.alMail }</td>
						<td>${alba.alCareer }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8">
						현재 알바생 없음.
					</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
</main>
</body>
</html>