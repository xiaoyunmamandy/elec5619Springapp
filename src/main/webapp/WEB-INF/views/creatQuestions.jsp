<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">@import url("<c:url value='/resources/css/qa.css'/>");
.backbutton{
	font-size:15px;
}
.bigtextbox{
height:100;
width:500;
}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function pointcheck(){
	var currentpoint = ${currentpoints};
	var enterpoint = $("#point").val();
	if(enterpoint>currentpoint){
		alert("your current point is not enough!");
		return false;
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
	<div class="col-xs-4">Create a question</div>
	<div class="col-xs-2"></div>
	<div class="col-xs-2"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
</div>
<div id="contentdiv">
<div id="questiondiv">
<table class="table table-striped">
<form action="/elec5619Springapp/addquestions" method="post" onsubmit="return pointcheck();">
	<input type="hidden" value="${userid }" name="userid" id="userid"/>
	<tr><td>Title:<input type="text" name="title"/></td></tr>
	<tr><td>Award:<input type="text" name="Worth" id="point"/></td></tr>
    <tr><td>Description:</td></tr>
    <tr><td><input type="text" name="description" class="bigtextbox"/></td></tr>
    <tr><td><input type="submit" value="submit"/></td></tr>
	</form>
</table>
</div>
</div>

</body>
</html>