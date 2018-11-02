<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
.backbutton{
color:white;
font-size:15px;
}
.selfcontent{
	margin-top:5px;
	margin-left:5px;
	text-align:center;
}
#updatetable{
   margin:auto;
   text-align:center;
}

</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="selfcentermaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">
			<div class="col-xs-2"></div>
			<div class="col-xs-4">Profile</div>
			<div class="col-xs-1"></div>
			<div class="col-xs-3"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
			</div>
			<div class="selfcontent">
				<form action="/elec5619/user/updateinformation" method="post"
					enctype="multipart/form-data">
					<input type="hidden" value="${model.user.id }" name="userid" /> <input
						type="hidden" value="${model.user.password }" name="password" />
					<input type="hidden" value="${model.user.points }"
						name="points" />
					<table id="updatetable">
						<tr>
							<td>user name:</td>
							<td><input type="text" name="userName" id="username" value="${model.user.userName }"></td>
						</tr>
						<tr>
							<td>email:</td>
							<td><input type="text" name="email" id="email" value="${model.user.email }"></td>
						</tr>
						<tr>
							<td>Profile photo:</td>
							<td><img src="/imgUrl/${model.user.picture }"
								height="30px" width="30px" /> <input type="hidden"
								value="${model.user.picture }" name="orignpersonImg" /></td></tr>
						<tr>
						<td colspan="2"><input type="file" name="personImg" id="personImg" /></td></tr>
						
						<tr>
						<td colspan="2"><input type="submit" value="update" /></td>
						</tr>
					</table>
					
				</form>

			</div>
		</div>
	</div>
</body>
</html>