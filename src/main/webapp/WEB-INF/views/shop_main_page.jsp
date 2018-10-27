<%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Shop</title>
<style type="text/css">@import url("<c:url value="/resources/css/shop.css"/>");</style>
<script type="text/javascript">
function checklogin(){
	var userid = $("#userid").val();
	if(userid==""){
		alert("please log in first!")
		return false;
	}
	else{
		return true;
	}
}
</script>
</head>
<body>
<div>${username }</div>
<input type="hidden" value="${userid }" id="userid"/>
	<div class="Ann">
		<div class="row">
			<div class="col-md-2"></div>	
			<div class="col-md-6">
				<div class="slider-content">
					<h2>
						Sale off <span>30%</span> for all
					</h2>
					<p>Lorem ipsum dolor sit amet consectetur adipisici elit, sed
						do eius tempor incididunt ut labore et dolore magna.</p>
					<a href="#collection">shop now</a>
				</div>
			</div>
			<div class="col-md-4">
				<div>
					<img src="<c:url value="/resources/decimg/shop_main_page.png"/>"/>
				</div>
			</div>
		</div>
	</div>
	<div class="product-area pb-80">
		<div class="container">
			<div class="section-title text-center mb-20" id="collection">
				<h2>Our Collection</h2>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-md-3">	
					<table>
    					<tr>
       						<td><img src="/imgUrl/${product.productImg}"  style="width:300px; height: 300px;"/></td>
    					</tr>
    					<tr>
    						<td>${product.name}</td>
    					</tr>
    					<tr>
    						<td>${product.price} &nbsp <a href="order/add/${product.id}/${userid}" onclick="return checklogin();"><img src="<c:url value="/resources/decimg/cart.png"/>" style="width:18px; height: 18px;"/></a></td>
    					</tr>
    				</table>		
				</div>
			</c:forEach>
		</div>		
	</div>	
</body>
</html>