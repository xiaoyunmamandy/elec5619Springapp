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
	<div class="topbar">111</div>

	<form action="/elec5619Springapp/user/login" method="post"
		enctype="multipart/form-data" onsubmit="return submitvalification()">
		<div class="row">

			<table id="login">
				<tr>
					<td>Email: <input type="text" name="email" id="email"></td>
				</tr>
				<tr>
					<td>password: <input type="text" name="password" id="password"></td>
				</tr>
			</table>
		</div>
		<input type="submit" value="login" />
		<p id="errormessage"></p>
	</form>
</body>
</html>