<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value='/resources/css/recipepage.css'/>");
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function submitvalification() {
		var username = $('#username').val();
		var password = $('#password').val();
		var cpassword = $('#cpassword').val();
		var photo = $('#personImg').val();
		if (password != cpassword) {
			alert("password is different!")
			return false;
		} else if (username == "") {
			alert("Username cannot be empty!")
			return false;
		} else if (password == "") {
			alert("password cannot be empty!")
			return false;
		} else if (cpassword == "") {
			alert("Please confirm your password!")
			return false;
		} else if (photo == "") {
			alert("Profile phote cannot be empty!")
			return false;
		} else
			return true;
	}
</script>
</head>
<body>
	<div class="topbar">111</div>

	<form action="/elec5619Springapp/user/adduser" method="post"
		enctype="multipart/form-data" onsubmit="return submitvalification()">
		<div class="row">

			<table id="register">
				<tr>
					<td>user name: <input type="text" name="userName"
						id="username"></td>
				</tr>
				<tr>
					<td>email: <input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td>password: <input type="text" name="password" id="password"></td>
				</tr>
				<tr>
					<td>confirm password: <input type="text"
						name="comfirm password" id="cpassword"></td>
				</tr>
				<tr>
					<td>Profile photo: <input type="file" name="personImg"
						id="personImg" /></td>
				</tr>

			</table>
		</div>
		<input type="submit" value="submit" />
	</form>
</body>
</html>