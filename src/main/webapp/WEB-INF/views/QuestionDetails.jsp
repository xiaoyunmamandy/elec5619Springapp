<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<style type="text/css">
@import url("<c:url value="/resources/css/qa.css"/>");
</style>
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
<input type="hidden" value="${model.user.id }" name="userid" id="userid"/>
<div class="topbar">Question details ${model.username}</div>
<div id="contentdiv">
	<div id="questiondiv">
	<h3>Question</h3>
	<input type="hidden" name="questionID" value="${model.question.getQuestionId() }" id="questionid"/>
	<table class="table table-striped">
		<tr>
			<td colspan="2">Title: ${model.question.getTitle()}</td>	
		</tr>
		<tr>
			<td><img src="<c:url value="/resources/decimg/questionmark.png" />" height="20px" width="20px"/>&nbspAsked by:&nbsp ${model.question.getUserName()}</td>
			<td><img src="<c:url value="/resources/decimg/point.png" />" height="20px" width="20px"/>&nbspAward:&nbsp ${model.question.getWorth()}</td>
		</tr>
		<tr>
			<td colspan="2">Description:</td>				
		</tr>
		<tr>
			<td colspan="2">
			${model.question.getDescription()}</td>	
		</tr>
	</table>
	</div>
	<div id="answersdiv">
	<h3>Answers</h3>
	<table class="table table-striped">
		<c:forEach items="${model.answers }" var="answer">
			<tr id="topanswer">
				<td> Answer by : ${answer.getUserName() }</td>
		      <td> ${answer.getDescription()}</td>
		      
	      </tr>
	    <c:forEach items="${answer.getSub() }" var="sub">
	    	<tr id="subanswer">
	    	<td></td>
	    		<td>${sub.getUserName() }: ${sub.getDescription()}</td>
	    	</tr>   
	      </c:forEach>
		</c:forEach>
	</table>
	</div>
	<div>Write your answer here :<input type="text" name="Answers"/><input type="submit" value="submit"/></div>
    	
</div>    
</form>
</body>
</html>