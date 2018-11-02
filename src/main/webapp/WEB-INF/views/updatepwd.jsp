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
#tablediv{
 margin-top:100px;
 margin:auto;
 text-align:center;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	function submitcheck() {
		var correctpwd = $("#correctpwd").val();
		var password = $("#password").val();
		var newpwd = $("#newpwd").val();
		var confirmpwd = $("#confirmnewpwd").val();
		if (password == "") {
			alert("please enter your original password!");
			return false;
		} else if (password != correctpwd) {
			alert("your original password is not correct!");
			return false;
		} else if (newpwd == "") {
			alert("please enter your new password!");
			return false;
		} else if (confirmpwd == "") {
			alert("please confirm your new password!");
			return false;
		} else if (confirmpwd != newpwd) {
			alert("the new passwords are different!")
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="selfcentermaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">
			<div class="col-xs-2"></div>
			<div class="col-xs-4">change password</div>
			<div class="col-xs-1"></div>
			<div class="col-xs-3"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
			</div>
			<div class="selfcontent">
				<form action="/elec5619/user/updateinformation" method="post"
					enctype="multipart/form-data" onsubmit="return submitcheck();">
					<input type="hidden" value="${model.user.id }" name="userid" /> <input
						type="hidden" value="${model.user.password }" name="correctpwd"
						id="correctpwd" /> <input type="hidden" name="userName"
						id="username" value="${model.user.userName }"> <input
						type="hidden" name="email" id="email" value="${model.user.email }">
					<input type="hidden" value="${model.user.picture }"
						name="orignpersonImg" />
					<input type="hidden" value="${model.user.points }"
						name="points" />
					<table id="tablediv">
						<tr>
							<td>Original password:</td>
							<td><input type="text" name="originpassword" id="password""></td>
						</tr>
						<tr>
							<td>New password:</td>
							<td><input type="text" name="password" id="newpwd"></td>
						</tr>
						<tr>
							<td>Confirm new password:</td>
							<td><input type="text"name="confirmnewpwd" id="confirmnewpwd"></td>
						</tr>
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