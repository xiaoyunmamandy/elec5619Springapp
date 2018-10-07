<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
	<h1>
	<c:out value="${model.recipes.recipeName}"/> <i>$<c:out value="${model.recipes.userID}"></c:out></i><br><br>
</h1>
	
</body>
</html>