<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
	<h1>
	<c:out value="${model.recipes.recipeName}"/> 
	<c:out value="${model.recipes.servepeopleno}"></c:out><br><br>
	<img src="/imgUrl/${model.recipes.dishImg }"/>
	<c:forEach items="${model.ingredients }" var="ingredient">
	<c:out value="${ingredient.ingredientName }"/>
	</c:forEach>
	<c:forEach items="${model.steps }" var="step">
	<c:out value="${step.description }"/>
	<img src="/imgUrl/${step.stepImg }"/>
	</c:forEach>
</h1>
	
</body>
</html>