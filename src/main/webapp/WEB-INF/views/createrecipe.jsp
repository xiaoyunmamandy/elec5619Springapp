<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title></head>
<body>
<form action="/elec5619Springapp/addrecipe" method="post">
	<table>
		<tr>
			<td>recipeName:</td>
			<td><input type="text" name="recipeName"/></td>
		</tr>
		<tr>
			<td>cookTime:</td>
			<td><input type="text" name="cookTime"/></td>
		</tr>
		<tr>
			<td>servepeopleno:</td>
			<td><input type="text" name="servepeopleno"/></td>
		</tr>
		<tr>
			<td>tips:</td>
			<td><input type="text" name="tips"/></td>
		</tr>
		<tr>
			<td>categoryID:</td>
			<td><form:select path="category" name="categoryID">
			<c:forEach items="${category}" var="category">
				<form:option value="${category.categoryID }"> ${category.categoryName }</form:option>
			</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>userID:</td>
			<td><input type="text" name="userID"/></td>
		</tr>
		<tr>
			<td>dishImg:</td>
			<td><input type="text" name="dishImg"/></td>
		</tr>
	</table>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>