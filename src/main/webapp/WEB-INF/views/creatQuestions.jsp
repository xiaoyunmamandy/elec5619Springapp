<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<style type="text/css">@import url("<c:url value='/resources/css/recipepage.css'/>");</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div class="topbar">
	<h3>create your question here</h3>
	<a href="https://www.baidu.com/">Back to homepage</a>
</div>

<form action="/elec5619Springapp/addquestions" method="post" >
	<input type="hidden" value="${userid }" name="userid" id="userid"/>
	<div>title:<input type="text" name="title"/></div>
	<div>award:<input type="text" name="Worth"/></div>
    <div>description:<input type="text" name="description"/></div>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>