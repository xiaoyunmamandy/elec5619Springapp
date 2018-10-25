<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
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
			<div class="topbar">Profile</div>
			<div>
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
					<input type="file" name="personImg" id="personImg" />
					<table>
						<tr>
							<td>Original password: <input type="text" name="originpassword"
								id="password""></td>
						</tr>
						<tr>
							<td>New password: <input type="text" name="password"
								id="newpwd"></td>
						</tr>
						<tr>
							<td>Comfirm new password:<input type="text"
								name="confirmnewpwd" id="confirmnewpwd"></td>
						</tr>
					</table>
					<input type="submit" value="update" />
				</form>

			</div>
		</div>
	</div>
</body>
</html>