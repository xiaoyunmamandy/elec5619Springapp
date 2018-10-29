<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for all questions</title>
<style type="text/css">@import url("<c:url value='/resources/css/qa.css'/>");</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function checklogin(){
	var userid = $("#userid").val();
	if(userid==""){
		alert("please log in first!")
		return false;
	}
	else{
		return true;
	}
}
</script>
</head>
<body>
<input type="hidden" value="${model.userid }" name="userid" id="userid"/>
<div class="topbar">${model.username}</div>
<div id="contentdiv">
<div id="questionlist">
<img src="<c:url value="/resources/decimg/plus.png" />" height="20px" width="20px"/>
<a href="${pageContext.request.contextPath}/CreateQuestion/${model.userid}" onclick="return checklog();">add a new question</a></div>
	<form>
	<table class="table table-striped">
		<c:forEach items="${model.questions }" var="question">
		<tr>
			<td>Title : ${question.title }</td>
			<td>Award : ${question.getWorth()}</td>
			<td>User : ${question.getUserName()}</td>
			<td><a href="${pageContext.request.contextPath}/questiondetails/${question.getQuestionId()}">See detail</a></td>
		</tr>
		</c:forEach>
	</table>
	</form>
</div>
</body>
</html>