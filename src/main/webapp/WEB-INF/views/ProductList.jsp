<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Product Details</title>
<style type="text/css">
@import url("<c:url value="/resources/css/main.css"/>");
@import url("<c:url value="/resources/css/admin.css"/>");
</style>
</head>
<body>
	<div class="row">
		<div class="col-xs-3" id="navigationbar"><jsp:include
				page="adminmaster.jsp"></jsp:include></div>
		<div class="col-xs-9" id="contentdiv">
			<div class="topbar">Manage products</div>
			<div id="global">
				<h1>Product Details</h1>
				<a href="<c:url value="/product/add"/>">Add New Product</a>
				<table>
					<tr>
						<!-- modify here -->
						<th>Name</th>
						<th>Amount</th>
						<th>Price</th>
						<th>ProductImage</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${products}" var="product">
						<tr>
							<td>${product.name}</td>
							<td>${product.amount}</td>
							<td>${product.price}</td>
							<td><img src="/imgUrl/${product.productImg}"
								style="width: 100px; height: 100px;" /></td>
							<td><a href="edit-product/${product.id}">Edit</a></td>
							<td><a href="product/delete-product/${product.id}"
								class="delete">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>