<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<form action="/elec5619Springapp/comments/addcomment" method="post" enctype="multipart/form-data">
	<input type="text" name="description"/>
	<input type="submit" value="submit"/>
	</form>
	<input type="button" onclick="redirect:home"/>
</body>
</html>