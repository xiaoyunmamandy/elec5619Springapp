<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
window.onload=function(){
	$.get("${pageContext.request.contextPath}/recipe/categoriestest",function(data){
		window.alert(data[0].categoryName);
		alert("111");
	
	})
}
</script>
</head>
<body>
<form action="/elec5619Springapp/addpictures" method="post" enctype="multipart/form-data">
	<div><jsp:include page="selfcentermaster.jsp"></jsp:include></div>
	<div>
		<table id="categorydiv"></table>
	</div>
	<input type="submit" value="submit"/>
	<h1>github</h1>
	</form>
	<input type="button" onclick="redirect:home"/>
</body>
</html>