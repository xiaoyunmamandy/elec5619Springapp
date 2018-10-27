<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Order Details</title>
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
			<div class="topbar">Order list</div>
			<div id="global">
				<h1>Order Details</h1>
				<table>
					<tr>
						<!-- modify here -->
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
		</div>
	</div>
</body>
</html>