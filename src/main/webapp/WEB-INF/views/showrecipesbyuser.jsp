<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function deletecheck(){
	var message = "Are you sure you want to delete it?";
	if(confirm(message)==true){
		return true;
	}
	else return false;
}
</script>
</head>
<body>
	
	<table class="table table-striped">
		<tr>
			<td>Recipe name</td>
			<td>Cook Time needed</td>
			<td></td>
		<c:forEach items="${model.recipes }" var="recipe">
			<tr>
				<td>${recipe.recipeName }</td>
				<td>${recipe.cookTime} mins</td>
				<td><a href="${pageContext.request.contextPath}/recipe/updatepage/${recipe.recipeID }"> update</a>
					<a href="${pageContext.request.contextPath}/recipe/deleterecipe/${recipe.recipeID }" onclick="return deletecheck();">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>