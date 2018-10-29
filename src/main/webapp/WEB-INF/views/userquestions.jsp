<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>Hello :: Spring Application for all questions</title>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
.backbutton{
color:white;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="selfcentermaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">
<div class="col-xs-2"></div>
		<div class="col-xs-4">My question</div>
		<div class="col-xs-2"></div>
		<div class="col-xs-2"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
			</div>
			<form>
				<c:forEach items="${model.questions }" var="question">
					<a
						href="${pageContext.request.contextPath}/UserQuestion/${question.getQuestionId()}">
						<div>
							<td>Title : ${question.title }</td>
							<td>Award : ${question.getWorth()}</td>
						</div>
					</a>
				</c:forEach>
			</form>
		</div>
	</div>

</body>
</html>