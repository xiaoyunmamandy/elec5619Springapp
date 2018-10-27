<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
<head>
<title>self center</title>
<style type="text/css">
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div>
	</div>
	<div id="contentbar">
	<a href="${pageContext.request.contextPath}/recipe/showcategory"/>Manage category</a></br>
	<a href="${pageContext.request.contextPath}/product/list-products"/>Manage products</a></br>
	<a href="${pageContext.request.contextPath}/order/list-orders"/>See orders</a></br>	
	</div>

</body>
</html>