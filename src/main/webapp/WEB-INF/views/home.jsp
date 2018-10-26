<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<style type="text/css">
@import url("<c:url value='/resources/css/home.css'/>");
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
window.onload=function(){
	var username = "${model.username}";
	if(username!=""){
		$("#loginpart").html("<a href='${pageContext.request.contextPath}/user/selfinfo'>Self center</a>")
		$("#registerpart").html("logout")
	}
}
</script>
</head>
<body>
<div class="topbar">
		<div class="col-xs-2"></div>
		<div class="col-xs-4">Welcome to our website</div>
		<div class="col-xs-1" id="loginpart">
		<a href="${pageContext.request.contextPath}/user/loginpage">Login</a>
		</div>
		<div class="col-xs-1" id="registerpart">
		<a href="${pageContext.request.contextPath}/user/showcreateuserform">register</a>
		</div>
		<div class="col-xs-2">Admin login</div>
</div>
<div class="row">
	<div class="col-xs-4" id="recipepart">
	<img src="<c:url value="/resources/decimg/recipe.jpg" />" height="200px" width="200px"/></br>
	<a href="${pageContext.request.contextPath}/recipe/allrecipes">Look recipes</a>
	</div>
	<div class="col-xs-4" id="awardpart">
	<img src="<c:url value="/resources/decimg/qa.jpg" />" height="200px" width="200px"/></br>
	Award questions</div>
	<div class="col-xs-4" id="mallpart">
	<img src="<c:url value="/resources/decimg/mall.png" />" height="200px" width="200px"/></br>
	Shopping mall</div>
</div>
</body>
</html>
