<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<style type="text/css">@import url("<c:url value='/resources/css/recipepage.css'/>");
	.backbutton{
	color:white;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<script type="text/javascript">
	window.onload = function() {
		var categoryid = ${model.categoryid};
		var cooktime=${model.cooktime};
		if (categoryid != 0&&cooktime!=0) {
			$("#categorieslist").val(categoryid);
			$("#cooktimelist").val(cooktime);
		}
		else if(categoryid==0&&cooktime!=0){
			$("#cooktimelist").val(cooktime);
		}
		else if(categoryid!=0&&cooktime==0){
			$("#categorieslist").val(categoryid);
		}
	};

	function search(){
		var categoryID = $("#categorieslist").val();
		var cooktimeid = $("#cooktimelist").val();
		if(categoryID==0&&cooktimeid==0){
			window.location.href = "${pageContext.request.contextPath}/recipe/allrecipes";
		}
		else if(categoryID==0){
			window.location.href = "${pageContext.request.contextPath}/recipe/cooktimerecipe/"
				+ cooktimeid;
		}
		else if(cooktimeid==0){
			window.location.href = "${pageContext.request.contextPath}/recipe/categoryrecipe/"
				+ categoryID;
		}
		else{
			window.location.href = "${pageContext.request.contextPath}/recipe/cooktimerecipe/"
				+ cooktimeid+"/"+categoryID;
		}
	}
	function test(){
		var url ="localhost:8080${pageContext.request.contextPath}/recipe/categories/";
		alert(url);
		
		$.get("${pageContext.request.contextPath}/recipe/categoriestest",function(data){
			
			
			window.alert(data[0].categoryName);
			
			alert("111");
		
		})
		
		
	}
</script>
</head>
<body>
	<div class="topbar">
		<div class="col-xs-2"></div>
	<div class="col-xs-4">All recipes</div>
	<div class="col-xs-2"></div>
	<div class="col-xs-2"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
	</div>
	<div>
	<form:select path="category" name="categoryID" id="categorieslist">
		<form:option value="0">All category</form:option>
		<c:forEach items="${category}" var="category">
			<form:option value="${category.categoryID }"> ${category.categoryName }</form:option>
		</c:forEach>
	</form:select>
	<select  name="cooktime" id="cooktimelist">
		<option value="0">all</option>
		<option value="1">no more than 20 mins</option>
		<option value="2">no more than 40 mins</option>
		<option value="3">no more than 60 mins</option>
	</select>
	<input type="button" value="search" id="searchrecipe" class="btn btn-primary" onclick="search();"/></div></br>
	<div id="recipesdiv">
	<table id="recipeslistbox">
		<%
			int i = 1;
		%>

		<c:forEach items="${model.recipes }" var="recipe">
			<%
				if (i % 4 == 1) {
			%>
			<tr>
				<%
					}
				%>
				<td><img src="/imgUrl/${recipe.dishImg }" height="150px"
					width="200px" /></br>${recipe.recipeName } ${recipe.cookTime} mins </br>
					 <a
					href="${pageContext.request.contextPath}/recipe/recipedetails/${recipe.recipeID }">
						see detail</a></td>
				<%
					if (i % 4 == 0) {
				%>
			</tr>
			<%
				}
					i++;
			%>
		</c:forEach>
	</table>
	</div>
</body>
</html>