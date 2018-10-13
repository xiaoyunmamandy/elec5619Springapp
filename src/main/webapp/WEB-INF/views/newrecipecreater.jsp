<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function addstep(){
	$('<div><input type="text" name="id"/><input type="text" name="name"/><input type="text" name="pwd"/><input type="button" value="delete this step" id="deletethestep" onclick="deletethestep()"></div>').appendTo($('#stepbox'))
}
function deletethestep(){
	$(this).parent().remove();
}
</script>
</head>
<body>
<form action="/elec5619Springapp/addrecipetotal" method="post" enctype="multipart/form-data">
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
			<td>dish image</td>
			<td><input type="file" name="dish_img"/></td>			
	</table>
	<div id="ingredientsbox">
	    Ingredient name:<input type="text" name="ingredientName"><br/>
        Amount:<input type="text" name="ingredientAmount"><br/>

        Ingredient name:<input type="text" name="ingredientName"><br/>
        Amount:<input type="text" name="ingredientAmount"><br/>
        
        Ingredient name:<input type="text" name="ingredientName"><br/>
        Amount:<input type="text" name="ingredientAmount"><br/>
     </div>
     
	<div id="stepbox">
	 StepNO<input type="text" name="stepid"><br/>
        Description:<input type="text" name="description"><br/>
        Picture:<input type="file" name="steppicture"><br/><br/>

        StepNo:<input type="text" name="stepid"><br/>
        Description:<input type="text" name="description"><br/>
        Picture:<input type="file" name="steppicture"><br/><br/>
        
        StepNo:<input type="text" name="stepid"><br/>
        Description:<input type="text" name="description"><br/>
        Picture:<input type="file" name="steppicture"><br/><br/>
     </div>
    <input type="button" value="add step" onclick="addstep();"/>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>