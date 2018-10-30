<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
.backbutton{
color:white;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

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
			<div>
				<h3>Question</h3>
				<table class="table table-striped">
					<tr>
						<td><img src="<c:url value="/resources/decimg/questionmark.png" />" height="20px" width="20px"/>&nbsp Title: ${model.question.getTitle()}</td>
						<td><img src="<c:url value="/resources/decimg/point.png" />" height="20px" width="20px"/>&nbsp Award: ${model.question.getWorth()}</td>

					</tr>
					<tr>
						<td colspan="2">Description:</td>
					</tr>
					<tr><td colspan="2">${model.question.getDescription()}</td></tr>
				</table>
				<h3>Answers</h3>
				<table class="table table-striped">
				<c:forEach items="${model.answers }" var="answer">
					<form action="/elec5619Springapp/addsub/${answer.getAnswerId()}"
						method="post">
						<input type="hidden" value="${model.user.id}" name="userid" /> <input
							type="hidden" name="questionID"
							value="${model.question.getQuestionId() }" id="questionid" />
							<tr>
								<td>Answer by : ${answer.getUserName() }</td> 
								<% if(${answer.getAcceptence()}==true) {%>
								<td>
								<%} %>	
								Best Answer!</td>
								<td>${answer.getDescription()}</td>	
								<input type="hidden" name="answerID" +i
									value="${answer.getUserName() }" />	</tr>
								<c:forEach items="${answer.getSub() }" var="sub">
								<tr>
								<td></td>
								<td>Reply: ${sub.getDescription()}</td>
								</tr>
									
								</c:forEach>
				
				
					</form>
				</c:forEach>
				</table>
			</div>
		</div>
	</div>
	</div>

</body>
</html>
© 2018 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
