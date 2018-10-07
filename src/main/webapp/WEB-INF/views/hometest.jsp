<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  mandy
</h1>
<c:forEach items="${model.recipes}" var="recipe">
	<c:out value="${recipe.recipeName}"/> <i>$<c:out value="${recipe.userID}"></c:out></i><br><br>
</c:forEach>
<p> ${model.welcome }</p>
<P>  The time on the server is ${model.serverTime}. </P>
</body>
</html>
