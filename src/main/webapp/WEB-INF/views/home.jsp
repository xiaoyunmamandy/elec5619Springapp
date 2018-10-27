<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
@import url("<c:url value='/resources/css/home.css'/>");
</style>
<script type="text/javascript">
window.onload=function(){
	var username = "${model.username}";
	var logout = "logout";
	if(username==logout){
		alert("log out success!")
		$("#loginpart").html("<a href='${pageContext.request.contextPath}/user/loginpage'>Login</a>");
		$("#registerpart").html("<a href='${pageContext.request.contextPath}/user/showcreateuserform'>register</a>");
	}
	else if(username!=""){
		$("#loginpart").html("<a href='${pageContext.request.contextPath}/user/selfinfo'>Self center</a>")
		$("#registerpart").html("<a href='${pageContext.request.contextPath}/user/logout'>logout</a>")
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
<div id="myCarousel" class="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" ></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>   
    <div class="carousel-inner">
        <div class="item active">
            <a href="##"><img src="<c:url value="/resources/decimg/homeimg1.jpg" />" alt="First slide" width="1200px" height="200px"></a>
        </div>
        <div class="item">
            <a href="##"><img src="<c:url value="/resources/decimg/homeimg2.jpg" />" alt="Second slide" width="1200px" height="200px"></a>
        </div>
        <div class="item">
            <a href="##"><img src="<c:url value="/resources/decimg/homeimg3.jpeg" />" alt="Third slide" width="1200px" height="200px"></a>
        </div>
    </div>
    	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		<span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		<span class="sr-only">Next</span>
	</a>
</div>
<div class="row" id="navparts">
	<div class="col-xs-4" id="recipepart">
	<img src="<c:url value="/resources/decimg/recipe.jpg" />" height="200px" width="300px"/></br>
	<a href="${pageContext.request.contextPath}/recipe/allrecipes">Look recipes</a>
	</div>
	<div class="col-xs-4" id="awardpart">
	<img src="<c:url value="/resources/decimg/qa.jpg" />" height="200px" width="300px"/></br>
	Award questions</div>
	<div class="col-xs-4" id="mallpart">
	<img src="<c:url value="/resources/decimg/mall.png" />" height="200px" width="300px"/></br>
	Shopping mall</div>
</div>
</body>
</html>
