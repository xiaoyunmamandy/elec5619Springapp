<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
Comments:
		<c:forEach items="${model.comments }" var="comment">
		<form action="/elec5619Springapp/comments/addsub/${comment.getCommentID()}" method="post" >
				<div> <tr>
				      <td> ${comment.getDescription()}</td>
				      <td> User : ${comment.getUserID() }</td>
				      <input type="hidden" name="commentID" value="${comment.getCommentID() }" />
				      <c:forEach items="${comment.getSub() }" var="sub">
				          <td> ${sub.getDescription()}</td>
				          <td> User : ${sub.getUserID() }</td>
				      </c:forEach>
				    <div>Write your comment here :<input type="text" name="Sub"/></div>
    	                   <input type="submit" value="submit"/>
				      </tr>
			    </div>
			    <div> </div>
			    <div> </div>
         </form>
		</c:forEach>
		
	<form action="/elec5619Springapp/comments/addcomment" method="post" enctype="multipart/form-data">
	<input type="text" name="description"/>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>