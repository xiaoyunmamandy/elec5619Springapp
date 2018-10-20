<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
<input type="hidden" name="recipeID" value="${model.recipes.recipeID }" id="recipeid"/>
<table>
	<tr>
		<td>recipeName:</td>
		<td>${model.recipes.recipeName}</td>
		
	</tr>
	<tr>
		<td>cookTime:</td>
		<td>${model.recipes.cookTime} mins</td>
		
	</tr>
	<tr>
		<td>servepeopleno:</td>
		<td>
		${model.recipes.servepeopleno}</td>		
	</tr>
	<tr>
		<td>tips:</td>
		<td>${model.recipes.tips}</td>
	</tr>
	<tr>
		<td>category:</td>
		<td>${model.categoryName}</td>
	</tr>	
	<tr>
		<td>dish picture:</td>
		<td><img src="/imgUrl/${model.recipes.dishImg }" height="150px" width="200px"/></td>
	</tr>
</table>
<c:forEach items="${model.ingredients }" var="ingredient">
	${ingredient.ingredientName }
	${ingredient.ingredientAmount }</br>
</c:forEach>
<c:forEach items="${model.steps }" var="step">
	${step.stepsno }
	${step.description }
	<img src="/imgUrl/${step.stepImg }" height="150px" width="200px"/></br>
</c:forEach>

</body>
</html>