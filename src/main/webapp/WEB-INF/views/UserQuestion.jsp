<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
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
		<form action="/elec5619Springapp/addsub/${answer.getAnswerId()}" method="post" >
				<div> <tr>
				      <td> ${answer.getDescription()}</td>
				      <td> User : ${answer.getUserId() }</td>
				      <input type="hidden" name="answerID"+i value="${answer.getAnswerId() }" />
				      <c:forEach items="${answer.getSub() }" var="sub">
				          <td> ${sub.getDescription()}</td>
				          <td> User : ${sub.getUserId() }</td>
				      </c:forEach>
				    <div>Write your comment here :<input type="text" name="Sub"/></div>
    	                   <input type="submit" value="submit"/>
				      </tr>
			    </div>
			    <div> </div>
			    <div> </div>
         </form>
		</c:forEach>
</body>
</html>