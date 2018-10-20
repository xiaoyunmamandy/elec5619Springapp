<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function test(){
	alert('111');
	//string categoryID = $("#categoryselect").val();
	//alert(categoryID);
	var categoryID = $("#categoryselect").val();
	alert(categoryID);
	window.location.href="${pageContext.request.contextPath}/categoryrecipe/"+categoryID;
	$.post("${pageContext.request.contextPath}/categoryrecipe",{categoryID:$("#categoryselect").val()}, function(data){alert(data)});
}
</script>
</head>
<body>
	<form:select path="category" name="categoryID" id="categoryselect">
		<c:forEach items="${category}" var="category">
			<form:option value="${category.categoryID }"> ${category.categoryName }</form:option>
		</c:forEach>
	</form:select>
	<input type="button" value="filter" id="changecategory" onclick="test()"/>
	<table>
		<% int i = 1; %>
	
		<c:forEach items="${model.recipes }" var="recipe">
			<% if(i%4==1){ %>
			<tr>
			<%} %>
			<td><img src="/imgUrl/${recipe.dishImg }" height="150px" width="200px"/></br>${recipe.recipeName } ${recipe.cookTime} mins
				<a href="${pageContext.request.contextPath}/recipedetails/${recipe.recipeID }"> see detail</a>
			</td>
			<% if(i%4==0){ %>
			</tr>
			<%} i++; %>
		</c:forEach>
	</table>
	</div>
</body>
</html>