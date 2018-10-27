<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value='/resources/css/login.css'/>");
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function validate_email(field,alerttxt)
	{
	with (field)
	{
	apos=value.indexOf("@")
	dotpos=value.lastIndexOf(".")
	if (apos<1||dotpos-apos<2) 
	  {alert(alerttxt);return false}
	else {return true}
	}
	}
	function submitvalification() {
		var username = $('#inputName').val();
		var password = $('#inputPassword').val();
		var cpassword = $('#inputPassword1').val();
		var email = $('#inputEmail').val();
		var photo = $('#personImg').val();
		if (password != cpassword) {
			alert("password is different!")
			return false;
		}
		else if(email==""){
			alert("Email cannot be empty!");
		}
		else if(validate_email(email,"Not a valid e-mail address!")==false){
			return false;
		}
		else if (username == "") {
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
	<div class="topbar">Create a new account</div>
	<div class="container">
	        <div class="card card-container">
	            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            <p id="profile-name" class="profile-name-card"></p>
	            <form action="/elec5619Springapp/user/adduser" method="post"
		enctype="multipart/form-data" onsubmit="return submitvalification()">
	           
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="text" name="userName" id="inputName" class="form-control" placeholder="User name" required autofocus>
	                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
	                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
	                <input type="password" name="confirmpassword" id="inputPassword1" class="form-control" placeholder="Confirm Password" required>
	                Profile photo: <input type="file" name="personImg" id="personImg" />
	                <p id="errormessage"></p>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
	            </form>
	        </div><!-- /card-container -->
	  </div><!-- /container -->
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