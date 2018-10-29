<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">
@import url("<c:url value="/resources/css/admin.css"/>");
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
window.onload=function(){
	$.get("${pageContext.request.contextPath}/recipe/categoriestest",function(data){
		var str = ""
		for(i=0;i<data.length;i++){
			str = str + "<tr><td>"+ data[i].categoryName+"</td><td><a href='${pageContext.request.contextPath}/recipe/categorydelete/"+data[i].categoryID+"' onclick='return check();'>delete</a></td></tr>";
		}
		$("#categorydiv").html(str);
	})
}
function addcategory(){
	var categoryname = $("#categoryName").val();
	if(categoryname==""){
		alert("please enter the category name!");
	}
	else{
		$.post("${pageContext.request.contextPath}/recipe/addcategory",{categoryname:categoryname},function(){
		alert("add success!");
		window.location="${pageContext.request.contextPath}/recipe/showcategory";
		})
	}
}
function check() {
	var message = "Are you sure you want to delete it?";
	if (confirm(message) == true) {
		return true;
	} else
		return false;
}
</script>
</head>
<body>
<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="adminmaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">Manage the categories of recipes</div>
			<div>
			<div>add new category: <input type="text" id="categoryName"/>
			<input type="button" value="add" onclick="addcategory()"/>
			</div>
			<table id="categorydiv" class="table table-striped"></table>
			</div>
			
		</div>
	</div>
</body>
</html>