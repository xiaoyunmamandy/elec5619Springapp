<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<style type="text/css">
@import url("<c:url value='/resources/css/selfcenter.css'/>");
</style>
<style type="text/css">
@import url("<c:url value='/resources/css/recipepage.css'/>");
</style>
<style>
#dishimgbox {
	text-align: center;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#categorieslist").val(${model.categoryID});
})

function addingredient(){
	var newrow = "<tr><td><input type='hidden' name='ingredientID' value='0'/><input type='text' name='ingredientName'></td><td><input type='text' name='ingredientAmount'></td></tr>";
	$(newrow).appendTo($('#ingredientsbox'))
}

function addsteps(){
	var rowcount = $('#stepbox').find('tr').length;
	stepno = rowcount +1;
	var newrow = "<tr><td><input type='hidden' name='stepsID' value='0'/><label>"+stepno+"</label><input type='hidden' name='stepid' value='"+stepno+"'/></td><td><input type='text' name='description'></td><td><input type='file' name='steppicture'></td>"
	$(newrow).appendTo($('#stepbox'))
	alert(rowcount)
}
function datavalid(){
	var recipename = $('#recipename').val();
	var cooktime = $('#cooktime').val();
	var servepeoplenumber = $('#servepeopleno').val();
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
	else{
		return true;
	}
}
</script>
</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="selfcentermaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">My recipes</div>
			<div>
				<form action="/elec5619Springapp/recipe/updaterecipe" method="post"
					enctype="multipart/form-data" onsubmit="return datavalid();">
					<div class="row">
						<div class="col-xs-5">
							<div id="dishimgbox">
								<img src="/imgUrl/${model.recipes.dishImg }" height="150px"
									width="200px" /><br> change the dish picture:<input
									type="file" name="dish_img" /> <input type="hidden"
									name="origindishImg" value="${model.recipes.dishImg }" /> <input
									type="hidden" name="recipeID"
									value="${model.recipes.recipeID }" id="recipeid" />
							</div>
						</div>
						<div class="col-xs-7">
							<table>
								<tr>
									<td colspan="2">Recipe Name: <input type="text"
										name="recipeName" value="${model.recipes.recipeName}"
										id="recipename" /></td>
								</tr>
								<tr>
									<td>Cook time: <input type="text" name="cookTime"
										value="${model.recipes.cookTime}" id="cooktime" /> mins
									</td>
									<td>Serve people number: <input type="text"
										name="servepeopleno" value="${model.recipes.servepeopleno}"
										id="servepeopleno" /></td>
								</tr>
								<tr>
									<td>category: <form:select path="category"
											name="categoryID" id="categorieslist">
											<c:forEach items="${category}" var="category">
												<form:option value="${category.categoryID }">  ${category.categoryName }</form:option>
											</c:forEach>
										</form:select></td>
									<td>Tips: <input type="text" name="tips"
										value="${model.recipes.tips}" /></td>
								</tr>
							</table>
						</div>
					</div>
					<table id="ingredientsbox">
						<c:forEach items="${model.ingredients }" var="ingredient">
							<tr>
								<td><input type="hidden" name="ingredientID"
									value="${ingredient.ingredientID }" /> <input type="text"
									name="ingredientName" value="${ingredient.ingredientName }" /></td>
								<td><input type="text" name="ingredientAmount"
									value="${ingredient.ingredientAmount }" /></td>
							</tr>
						</c:forEach>
					</table>
					<input type="button" value="add ingredients"
						onclick="addingredient();" />
					<table id="stepbox">
						<c:forEach items="${model.steps }" var="step">
							<tr>
								<td><input type="hidden" name="stepsID"
									value="${step.stepsID }" /><span>${step.stepsno }</span><input
									type="hidden" name="stepid" value="${step.stepsno }" /></td>
								<td><input type="text" name="description"
									value="${step.description }" /></td>
								<td><img src="/imgUrl/${step.stepImg }" height="150px"
									width="200px" /><input type="hidden" value="${step.stepImg }"
									name="originstepImg" /></br>
								<input type="file" name="steppicture" /></td>
							</tr>
						</c:forEach>
					</table>
					<input type="button" value="add steps" onclick="addsteps();" /> <input
						type="submit" value="update" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>