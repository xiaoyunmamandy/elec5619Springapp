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
	window.onload = function(){
		var nouser = ${model.nouser};
		var pwdfalse = ${model.pwdfalse};
		if(nouser==1){
			$("#errormessage").html("The email is not exists!")
		}
		else if(pwdfalse==1){
			$("#errormessage").html("Your password is not correct!")
		}
	}

</script>
</head>
<body>
	<div class="topbar">
	Login in</div>
	<div class="container">
	        <div class="card card-container">
	            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
	            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	            <p id="profile-name" class="profile-name-card"></p>
	            <form action="/elec5619Springapp/user/login" method="post"
		enctype="multipart/form-data" onsubmit="return submitvalification()">
	           
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
	                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
	                <p id="errormessage"></p>
	                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
	            </form>
	        </div><!-- /card-container -->
	  </div><!-- /container -->
</body>
</html>