<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<h1><fmt:message key="heading"></fmt:message></h1> <!-- 映射一个关键字给局部信息，然后执行参数替换 -->
<p><fmt:message key="greating"/><c:out value="${model.now}"/></p>
<h3>Recipes</h3>
<c:forEach items="${model.recipes}" var="recipe">
	<c:out value="${recipe.recipeName}"/> <i>$<c:out value="${recipe.userID}"></c:out></i><br><br>
</c:forEach>
</body>
</html>