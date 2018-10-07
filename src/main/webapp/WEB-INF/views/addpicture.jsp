<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<form action="/elec5619Springapp/addpictures" method="post" enctype="multipart/form-data">
	<input type="file" name="dish_img"/>
	<input type="file" name="file_img"/>
	<input type="file" name="file_img"/>
	<input type="file" name="file_img"/>
	<input type="submit" value="submit"/>
	<h1>github</h1>
	</form>
</body>
</html>