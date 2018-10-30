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
#recipepart{
	background-color:#F0F8ED;
	height:400px;
}
#awardpart{
	background-color:#EAEDF6;
	height:400px;
}
#mallpart{
	background-color:#EBE2DD;
	height:400px;
}
#navparts{
	margin-left:20px;
	margin-right:20px;
	padding-top:10px;
	text-align:center;
	margin-top:10px;
}
.navlink{
color:black;
font-size:20px;
font-weight:bold;
}
</style>
<script type="text/javascript">
window.onload=function(){
	var username = "${model.username}";
	var logout = "logout";
	if(username==logout){
		alert("log out success!")
		$("#loginpart").html("<a href='${pageContext.request.contextPath}/user/loginpage'>Login</a>");
		$("#registerpart").html("<a href='${pageContext.request.contextPath}/user/showcreateuserform'>register</a>");
		$("#adminpart").html("<a href='${pageContext.request.contextPath}/adminloginpage'>Admin login</a>")
	}
	else if(username!=""){
		$("#loginpart").html("<a href='${pageContext.request.contextPath}/user/selfinfo'>Self center</a>")
		$("#registerpart").html("<a href='${pageContext.request.contextPath}/user/logout'>logout</a>")
		$("#adminpart").html("<a href='${pageContext.request.contextPath}/recipe/showcreaterecipeform'>Create recipe</a>")
	}
}
</script>
</head>
<body>
<div class="topbar">
		<div class="col-xs-2"></div>
		<div class="col-xs-4">Free recipe and delicious food</div>
		<div class="col-xs-1" id="loginpart">
		<a href="${pageContext.request.contextPath}/user/loginpage">Login</a>
		</div>
		<div class="col-xs-1" id="registerpart">
		<a href="${pageContext.request.contextPath}/user/showcreateuserform">register</a>
		</div>
		<div class="col-xs-2" id="adminpart">
		<a href="${pageContext.request.contextPath}/adminloginpage">Admin login</a></div>
</div>
<div id="myCarousel" class="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" ></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>   
    <div class="carousel-inner">
        <div class="item active">
            <a href="##"><img src="<c:url value="/resources/decimg/home1.jpg" />" alt="First slide"  style="height:400px;width:1300px" ></a>
        </div>
        <div class="item">
            <a href="##"><img src="<c:url value="/resources/decimg/home3.png" />" alt="Second slide" style="height:400px;width:1300px"></a>
        </div>
        <div class="item">
            <a href="##"><img src="<c:url value="/resources/decimg/homeimg3.jpeg" />" alt="Third slide" style="height:400px;width:1300px"></a>
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
	<img src="<c:url value="/resources/decimg/recipepart.jpg" />" height="280px" width="356px"/></br>
	<a href="${pageContext.request.contextPath}/recipe/allrecipes" class="navlink">Look recipes</a>
	</div>
	<div class="col-xs-4" id="awardpart">
	<img src="<c:url value="/resources/decimg/qapart.jpg" />" height="280px" width="356px"/></br>
	<a href="${pageContext.request.contextPath}/allquestions" class="navlink">Award questions</a></div>
	<div class="col-xs-4" id="mallpart">
	<img src="<c:url value="/resources/decimg/mallpart.jpg" />" height="280px" width="356px"/></br>
	<a href="${pageContext.request.contextPath}/shop" class="navlink">Shopping mall</a></div>
</div>
</body>
</html>
