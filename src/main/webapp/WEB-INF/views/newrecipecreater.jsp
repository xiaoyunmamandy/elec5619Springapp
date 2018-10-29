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
function submitvalification(){
	var recipename = $('#recipename').val();
	var cooktime = $('#cooktime').val();
	var servepeoplenumber = $('#servepeopleno').val()
    var dishimg = $('#dishimg').val()
	if(recipename==""){
		alert("please input the name of recipe!")
		return false;
	}
	else if(servepeoplenumber==""){
		alert("please enter the serve people number!")
		return false
	}
	else if(cooktime==""){
		alert("please enter the cook time!")
		return false
	}
	else if(isNaN(servepeoplenumber)){
		alert("serve people should be a number!")
		return false
	}
	else if(isNaN(cooktime)){
		alert("cook time should be a number!")
		return false
	}
	else if(dishimg==""){
		alert("please upload a picture for your dish!")
		return false
	}
	else{
		return true;
	}
}
</script>
</head>
<body>
<div class="topbar">
	<div class="col-xs-2"></div>
	<div class="col-xs-4">create your recipe here</div>
	<div class="col-xs-2"></div>
	<div class="col-xs-2"><a href="${pageContext.request.contextPath}/">Back to homepage</a></div>
	
</div>

<form action="/elec5619Springapp/recipe/addrecipetotal" method="post" enctype="multipart/form-data" onsubmit="return submitvalification();">
	<div>recipeName:<input type="text" name="recipeName" id="recipename"/>
	</div>
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
			cookTime:<input type="text" name="cookTime" id="cooktime"/>mins</br>
			servepeopleno:<input type="text" name="servepeopleno" id="servepeopleno"/></br>
			
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
		dish image: <input type="file" name="dish_img" id="dishimg"/>
		</div>
	</div>
	
	<input type="submit" value="submit"/>
	</form>
</body>
</html>