<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">@import url("<c:url value='/resources/css/recipepage.css'/>");</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
var stepnumber = 4
function addstep(){
	var newrow = "<tr><td><label id='stepid'>"+stepnumber+"</label></td><td><input type='text' name='description'></td><td><input type='file' name='steppicture'></td>"
	$(newrow).appendTo($('#stepbox'))
	stepnumber++;
}
function deletethestep(){
	$(this).parent().remove();
}
function addingredient(){
	var newrow = "<tr><td><input type='text' name='ingredientName'></td><td><input type='text' name='ingredientAmount'></td></tr>";
	$(newrow).appendTo($('#ingredientsbox'))
}
</script>
</head>
<body>
<div class="topbar">
	<h3>create your recipe here</h3>
	<a href="https://www.baidu.com/">Back to homepage</a>
</div>

<form action="/elec5619Springapp/recipe/addrecipetotal" method="post" enctype="multipart/form-data">
	<div>recipeName:<input type="text" name="recipeName"/></div>
	<div class="row">
		<div class="col-xs-8" id="ingredientsdiv">
			<table id="ingredientsbox">
				<tr>
					<th>Ingredient name:</th>
					<th>Amount:</th>
				</tr>
				<tr>
					<td><input type="text" name="ingredientName"></td>
					<td><input type="text" name="ingredientAmount"></td>
				</tr>
				<tr>
					<td><input type="text" name="ingredientName"></td>
					<td><input type="text" name="ingredientAmount"></td>
				</tr>
				<tr>
					<td><input type="text" name="ingredientName"></td>
					<td><input type="text" name="ingredientAmount"></td>
				</tr>
				<tr>
					<td><input type="text" name="ingredientName"></td>
					<td><input type="text" name="ingredientAmount"></td>
				</tr>
	        </table>
	        <input type="button" value="add ingredient" onclick="addingredient()"/>
	     	</div>
		<div class="col-xs-4">
			categoryID:<form:select path="category" name="categoryID">
							<c:forEach items="${category}" var="category">
								<form:option value="${category.categoryID }"> ${category.categoryName }</form:option>
							</c:forEach>
					</form:select></br>
			cookTime:<input type="text" name="cookTime"/>mins</br>
			servepeopleno:<input type="text" name="servepeopleno"/></br>
			
		</div>
	</div>
	<div class="row">
		<div class="col-xs-8" id="stepdiv">
			<table id="stepbox">
				<tr>
					<th>StepNO</th>
					<th>Description:</th>
					<th>Picture:</th>
				</tr>
				<tr>
					<td><label id="stepid">1</label></td>
					<td><input type="text" name="description"></td>
					<td><input type="file" name="steppicture"></td>
				</tr>
				<tr>
					<td><label id="stepid">2</label></td>
					<td><input type="text" name="description"></td>
					<td><input type="file" name="steppicture"></td>
				</tr>
				<tr>
					<td><label id="stepid">3</label></td>
					<td><input type="text" name="description"></td>
					<td><input type="file" name="steppicture"></td>
				</tr>
			</table>
			<input type="button" value="add step" onclick="addstep();"/>
     	</div>
		<div class="col-xs-4">tips:<input type="text" name="tips"/></br>
		dish image: <input type="file" name="dish_img"/>
		</div>
	</div>
	
	<input type="submit" value="submit"/>
	</form>
</body>
</html>