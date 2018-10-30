<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<style type="text/css">
@import url("<c:url value='/resources/css/recipepage.css'/>");
.backbutton{
color:white;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
window.onload=function(){

		
	var reuserid = $("#reuserid").val();
	var url = "${pageContext.request.contextPath}/user/getuser/"+reuserid;
	$.get(url,function(data){
		var username = data.userName;
		$("#reusername").html(username);
	})
	var collected = ${model.collect}
	if(collected==1){
		$("#collectbtn").hide();
	}
}
function collectrecipe(){
	var recipeID = $("#recipeid").val();
	var userid = $("#userid").val();
	if(userid==""){
		alert("please login first!")
	}
	else{
		$.post("${pageContext.request.contextPath}/recipe/collectrecipe",{recipeID:recipeID,userid:userid},function(){
			alert("you have collect the recipe!")
			$("#collectbtn").hide();
		})
	}
	
}
</script>
</head>
<body>
	<div class="topbar">
		<div class="row" id="titlediv">
			<div class="col-xs-2"></div>
	<div class="col-xs-4">All recipes</div>
	<div class="col-xs-2"></div>
	<div class="col-xs-2"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
		</div>
	</div>
	<input type="hidden" name="recipeID" value="${model.recipes.recipeID }"
		id="recipeid" />
	<input type="hidden" name="userID" value="${model.userid }"
		id="userid" />
	<div class="bodydiv">
		<div class="row">
			<div class="col-xs-8">
				<table id="basicinfotable">
					<tr>
						<td colspan="2"><h3>${model.recipes.recipeName}</h3></td>
					</tr>
					<tr>
						<td rowspan="4"><img src="/imgUrl/${model.recipes.dishImg }"
							height="200px" width="300px" /></td>
						<td><img src="<c:url value="/resources/decimg/head.png" />" height="20px" width="20px"/>&nbspChef:&nbsp<span id="reusername">${model.recipes.userID}</span></td>
					</tr>
					<tr>
						<td><img src="<c:url value="/resources/decimg/time_icon.png" />" height="20px" width="20px"/>&nbspTime needed: ${model.recipes.cookTime} mins</td>
					</tr>
					<tr>
						<td><img src="<c:url value="/resources/decimg/servepeople.png" />" height="20px" width="20px"/>&nbspserve people: ${model.recipes.servepeopleno}</td>
					</tr>
					<tr>
						<td><img src="<c:url value="/resources/decimg/tag.png" />" height="20px" width="20px"/>&nbspcategory: ${model.categoryName}</td>
					</tr>
				</table>
				<input type="hidden" value="${model.recipes.userID}" id="reuserid"/>
				<input type="button" value="add to collection" id="collectbtn" class="btn btn-primary" onclick="collectrecipe();"/>
				<div class="listdiv">
					<h3>Ingredients</h3>
					<table id="ingredientlistbox" class="table table-striped">
						<c:forEach items="${model.ingredients }" var="ingredient">
						<tr>
							<td>${ingredient.ingredientName }</td>
							<td>${ingredient.ingredientAmount }</td>
						</tr>
						</c:forEach>

					</table>
				</div>
				<div class="listdiv">
					<h3>Steps</h3>
					<table id="steplistbox">
						<c:forEach items="${model.steps }" var="step">
							<tr>
								<td>${step.stepsno }</td>
								<td>${step.description }</td>
								<td><img src="/imgUrl/${step.stepImg }" height="150px" width="200px" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="col-xs-3">Tips: ${model.recipes.tips}</div>
		</div>	
	</div>
	<div>
	Comments:
	<div>
	<form action="/elec5619Springapp/comments/addcomment" method="post" enctype="multipart/form-data">
	<input type="hidden" name="recipeID" value="${model.recipes.recipeID }"
		id="recipeid" />
	<input type="text" name="description"/>
	<input type="submit" value="add my comment"/>
	</form></div>
	<table class="table table-striped">
		<c:forEach items="${model.comments }" var="comment">
		<form action="/elec5619Springapp/comments/addsub/${comment.getCommentID()}" method="post" >
				<input type="hidden" name="recipeID" value="${model.recipes.recipeID }"
		id="recipeid" />
				<div> <tr>
				      <td> ${comment.getDescription()}</td>
				      <td> User : ${comment.getUserName() }</td>
				      <input type="hidden" name="commentID" value="${comment.getCommentID() }" /></tr>
				      <c:forEach items="${comment.getSub() }" var="sub">
				      <tr>
				      		<td></td>
				          <td> ${sub.getDescription()}</td>
				          <td> User : ${sub.getUserName() }</td></tr>
				      </c:forEach>
				    <tr><td colspan="3">Write your reply here :<input type="text" name="Sub"/> <input type="submit" value="reply"/></td></tr>
    	                  
				      
			    </div>
			    <div> </div>
			    <div> </div>
         </form>
		</c:forEach>
		</table>
	
	</div>
</body>
</html>