<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<form action="/elec5619Springapp/getrecipebyidresult" method="post">
	<input name="getrecipebyID" type="text"/>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>