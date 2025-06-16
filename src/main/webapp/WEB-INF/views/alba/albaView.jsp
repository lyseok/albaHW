<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<table>
	<tr>
		<td colspan="2">
			<c:url value="/alba/albaDelete.do" var="deleteURL">
					<c:param name="alId" value="${alba.alId }"/>
			</c:url>
			 <a class="btn btn-primary" href="${deleteURL }">삭제하기</a>
		</td>
	</tr>
	<!-- 목록가기 추가 -->
	<tr>
		<td colspan="2">
			<c:url value="/alba/albaList.do" var="backListURL"/>
			 <a class="btn btn-primary" href="${backListURL }">목록으로 돌아가기</a>
		</td>
	</tr>
		
	
	
	<tr>
		<th>프로필.</th>
		<c:if test="${not empty alba.alImg }">
				<img src="/image/${alba.alImg}" />
		</c:if>
	</tr>
	
	<tr>
		<th>이름 </th>
		<td>${alba.alName }</td>
	</tr>

	<tr>
		<th>나이 </th>
		<td>${alba.alAge }</td>
	</tr>
	<tr>
		<th>우편  </th>
		<td>${alba.alZip }</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${alba.alAdd1 }</td>
	</tr>
	<tr>
		<th>상세주소</th>
		<td>${alba.alAdd2 }</td>
	</tr>
	<tr>
		<th>핸드폰 번호</th>
		<td>${alba.alHp }</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>${alba.alGen }</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${alba.alMail }</td>
	</tr>
	<tr>
		<th>경력사항</th>
		<td>${alba.alCareer }</td>
	</tr>
	<tr>
		<th>특기사항</th>
		<td>${alba.alSpec }</td>
	</tr>
	<tr>
		<th>비고</th>
		<td>${alba.alDesc }</td>
	</tr>
	
	<tr>
		<th>학력</th>
		<td>${alba.grade.grName }</td>
	</tr>
	
	<tr>
			<th>거래품목</th>
			<td>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>자격증</th>
							<th>자격증코드</th>
							<th>취득일 </th>
							<th>자격증 사본 </th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty alba }">
								<c:forEach items="${alba.licAlbaList }" var="albaLic">
									<tr>
										<td>${albaLic.license.licName}</td>
										<td>${albaLic.licCode }</td>
										<td>${albaLic.licDate }</td>
										<td>
										<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#licenseModal${status.index}">
										    자격증 보기
										</button>
				
										<div class="modal fade" id="licenseModal${status.index}" tabindex="-1" aria-labelledby="licenseModalLabel${status.index}" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <h1 class="modal-title fs-5" id="licenseModalLabel${status.index}">자격증 사본</h1>
										        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
										      </div>
										      <div class="modal-body text-center">
										 
										        <img src="data:image/*;base64,${albaLic.licImgBase64}" class="img-fluid"/>
										      </div>
										      <div class="modal-footer">
										        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
										      </div>
										    </div>
										  </div>
										</div>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="3">자격증 없음...</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</td>
		</tr>		
</table>
<c:url value="/alba/albaUpdate.do" var="updateURL">
					<c:param name="what" value="${alba.alId }" />
				</c:url>
				<a class="btn btn-primary" href="${updateURL }">수정</a>
			
</body>
</html>