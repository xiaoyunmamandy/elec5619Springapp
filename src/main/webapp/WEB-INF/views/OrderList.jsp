<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Order Details</title>
<style type="text/css">@import url("<c:url value="/resources/css/main.css"/>");</style> 
<script src="c="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></"></script>
</head>
<body>
<div id="global">
<!--<form action="" method="POST">
	<input type="hidden" name="_method" value="DELETE">
</form>  -->
<h1>Order Details</h1>
<table>
<tr><!-- modify here -->
    <th>ProductID</th>
    <th>Amount</th>
    <th>UserID</th>
    <th>Contact</th>
    <th>Country</th>
    <th>Address</th>
    <th>Postcode</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${orders}" var="order">
    <tr>
        <td>${order.productID}</td>
        <td>${order.amount}</td>
        <td>${order.userid}</td>
        <td>${order.contact}</td>
        <td>${order.country}</td>
        <td>${order.address}</td>
        <td>${order.postcode}</td>
        <td><a href="order/delete-order/${order.id}" class="delete">Delete</a></td>
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>