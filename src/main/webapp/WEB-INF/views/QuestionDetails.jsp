<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
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
<form action="/elec5619Springapp/addanswers" method="post" onsubmit="return checklogin();">
<input type="hidden" value="${model.userid }" name="userid" id="userid"/>
<div class="topbar">${model.username}</div>
<input type="hidden" name="questionID" value="${model.question.getQuestionId() }" id="questionid"/>
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
		<td>
		${model.question.getDescription()}</td>		
	</tr>
	<tr>
		<td>User:</td>
		<td>${model.question.getQuestionId()}</td>
	</tr>
</table>
Answers:
		<c:forEach items="${model.answers }" var="answer">
				<div> <tr>
				      <td> ${answer.getDescription()}</td>
				      <td> User : ${answer.getUserId() }</td>
				      </tr>
			    </div>
			    <c:forEach items="${answer.getSub() }" var="sub">
				          <td> ${sub.getDescription()}</td>
				          <td> User : ${sub.getUserId() }</td>
				      </c:forEach>
			    <div> </div>
			    <div> </div>
		</c:forEach>
    <div>Write your answer here :<input type="text" name="Answers"/></div>
    	<input type="submit" value="submit"/>
    </form>
</body>
</html>