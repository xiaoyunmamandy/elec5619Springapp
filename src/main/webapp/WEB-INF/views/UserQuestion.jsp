<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="selfcentermaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">My questions</div>
			<div>
				<table>
					<tr>
						<td>Title:</td>
						<td>${model.question.getTitle()}</td>

					</tr>
					<tr>
						<td>Award:</td>
						<td>${model.question.getWorth()}</td>

					</tr>
					<tr>
						<td>Description:</td>
						<td>${model.question.getDescription()}</td>
					</tr>
					<tr>
						<td>User:</td>
						<td>${model.question.getQuestionId()}</td>
					</tr>
				</table>
				Answers:
				<c:forEach items="${model.answers }" var="answer">
					<form action="/elec5619Springapp/addsub/${answer.getAnswerId()}"
						method="post">
						<input type="hidden" value="${model.user.id}" name="userid" /> <input
							type="hidden" name="questionID"
							value="${model.question.getQuestionId() }" id="questionid" />
						<div>
							<tr>
								<td>${answer.getDescription()}</td>
								<td>User : ${answer.getUserId() }</td>
								<input type="hidden" name="answerID" +i
									value="${answer.getAnswerId() }" />
								<c:forEach items="${answer.getSub() }" var="sub">
									<td>${sub.getDescription()}</td>
									<td>User : ${sub.getUserId() }</td>
								</c:forEach>
								<div>
									Write your comment here :<input type="text" name="Sub" />
								</div>
								<input type="submit" value="submit" />
							</tr>
						</div>
						<div></div>
						<div></div>
					</form>
				</c:forEach>
			</div>
		</div>
	</div>

</body>
</html>