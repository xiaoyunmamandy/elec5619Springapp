<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
.backbutton{
color:white;
font-size:15px;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="selfcentermaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">
<div class="col-xs-2"></div>
		<div class="col-xs-4">My collection</div>
		<div class="col-xs-1"></div>
		<div class="col-xs-3"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
			</div>
			<div>
				<table class="table table-striped">
					<tr>
						<td>Recipe name</td>
						<td>Cook Time needed</td>
						<td></td>
						<c:forEach items="${model.recipes }" var="recipe">
							<tr>
								<td>${recipe.recipeName }</td>
								<td>${recipe.cookTime} mins</td>
								<td> 
								<a
									href="${pageContext.request.contextPath}/recipe/recipedetails/${recipe.recipeID}"
									onclick="return deletecheck();">see detail</a>
								<a
									href="${pageContext.request.contextPath}/recipe/deletecollect/${model.user.id}/${recipe.recipeID}"
									onclick="return deletecheck();">cancel collection</a></td>
							</tr>
						</c:forEach>
				</table>

			</div>
		</div>
	</div>
</body>
</html>