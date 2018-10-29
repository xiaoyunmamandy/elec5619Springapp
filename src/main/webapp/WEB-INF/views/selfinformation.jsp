<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
.backbutton{
color:white;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="row">
	<div class="col-xs-3" id="navigationbar"><jsp:include page="selfcentermaster.jsp"></jsp:include></div>
	<div class="col-xs-9" id="contentdiv">
		<div class="topbar">
		<div class="col-xs-2"></div>
		<div class="col-xs-4">Profile</div>
		<div class="col-xs-2"></div>
		<div class="col-xs-2"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
		</div>
		<div class="row">
		<div class="col-xs-6">
			<a href="${pageContext.request.contextPath}/user/updatepwdpage/${model.user.id }">Change password</a>
		</div>		
		<div class="col-xs-6">
			<a href="${pageContext.request.contextPath}/user/updateinfopage/${model.user.id }">Update profile</a>
		</div>
			
		</div>
	</div>
</div>
</body>
</html>