<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div class="row">
	<div class="col-xs-3" id="navigationbar"><jsp:include page="selfcentermaster.jsp"></jsp:include></div>
	<div class="col-xs-9" id="contentdiv">
		<div class="topbar">Profile</div>
		<div>
		<form action="/elec5619/user/updateinformation" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${model.user.id }" name="userid"/>
		<table id="register">
				<tr>
					<td>user name: <input type="text" name="userName"
						id="username" value="${model.user.userName }"></td>
				</tr>
				<tr>
					<td>email: <input type="text" name="email" id="email" value="${model.user.email }"></td>
				</tr>
				<tr>
					<td>Profile photo:<img src="/imgUrl/${model.user.picture }" height="30px" width="30px"/>
					<input type="hidden" value="${model.user.picture }" name="orignpersonImg"/></br>
					 <input type="file" name="personImg"
						id="personImg" /></td>
				</tr>
			</table>
			<input type="submit" value="update"/>
		</form>
			
		</div>
	</div>
</div>
</body>
</html>