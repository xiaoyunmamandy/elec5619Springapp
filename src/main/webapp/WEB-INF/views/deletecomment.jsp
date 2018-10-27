<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<form action="/elec5619Springapp/comments" method="post" enctype="multipart/form-data">
	<input type="submit" value="showComments"/>
	<div>
		<c:forEach items="${model.commentlist}" var="comment">
		${comment.description}
			<a href="${pageContext.request.contextPath}/comments/deletecomment/${comment.commentID }"> delete</a>
		</c:forEach>
		</div>
</form>
</body>
</html>