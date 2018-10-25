<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>self center</title>
<style type="text/css">
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div id="selfinfodiv">
	<input type="hidden" value="${model.user.id }"/>
	<img src="/imgUrl/${model.user.picture }" height="30px" width="30px"/></br>
	username: ${model.user.userName }</br>points: ${model.user.points }
	</div>
	<div id="contentbar">
	<a href="${pageContext.request.contextPath}/user/selfinfo"/>Profile</a></br>
	<a href="${pageContext.request.contextPath}/recipe/userrecipe/${model.user.id }"/>My recipes</a></br>
	<input type="button" value="My collections"/></br>
	<input type="button" value="My comments"/></br>
	<input type="button" value="My questions"/></br>
	
	</div>

</body>
</html>