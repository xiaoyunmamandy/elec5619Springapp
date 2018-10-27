<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Product Details</title>
<style type="text/css">@import url("<c:url value="/resources/css/main.css"/>");</style> 
<script src="c="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></"></script>
</head>
<body>
<div id="global">
<!--<form action="" method="POST">
	<input type="hidden" name="_method" value="DELETE">
</form>  -->
<h1>Product Details</h1>
<a href="<c:url value="/product/add"/>">Add New Product</a>
<table>
<tr><!-- modify here -->
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
        <td><img src="/imgUrl/${product.productImg}"  style="width:100px; height: 100px;"/></td>
        <td><a href="edit-product/${product.id}">Edit</a></td>
        <td><a href="product/delete-product/${product.id}" class="delete">Delete</a></td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>