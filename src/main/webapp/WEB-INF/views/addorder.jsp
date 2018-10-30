<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url("<c:url value="/resources/css/main.css"/>");
.topbar{
height:70px;
background-color:#EAEDF6;
margin-bottom:10px;
font-size:30px;
font-weight:bold;
padding-top:20px;
}
.backbutton{
	font-size:15px;
}
</style>
<script type="text/javascript">
function amountcheck(){
	var currentamount = ${product.amount};
	var inputamount = $("#amount").val();
	alert(inputamount);
	if(currentamount>inputamount){
		return true;
	}
	else{
		alert("Sorry we do have enough storage!");
		return false;
	}
}
window.onload=function(){
	var pointcheck = ${pointcheck};
	if(pointcheck==1){
		$("errormessage").html(your points is not enough!);
	}
}

</script>
</head>
<body>
<div class="topbar">
	<div class="col-xs-2"></div>
	<div class="col-xs-4">All questions</div>
	<div class="col-xs-2"></div>
	<div class="col-xs-2"><a href="${pageContext.request.contextPath}/" class="backbutton">Back to homepage</a></div>
</div>
<div id="global">
<form:form commandName="order" action="addorder" method="post" onsubmit="return amountcheck()"><!-- commandName means the name of the attribute of the model from Controller -->
    <fieldset>
        <legend>Make a Order</legend>
        <p>
            <label for="address">Address: </label>
            <form:input id="address" path="address"/><!-- path is used to bind the input area with the attribute of Model object -->
        </p>
        <p>
            <label for="contact">Contact: </label>
            <form:input id="contact" path="contact"/><!-- path is used to bind the input area with the attribute of Model object -->
        </p>
        <p>
            <label for="postcode">Postcode: </label>
            <form:input id="postcode" path="postcode"/>
        </p>
        <p>
            <label for="country">Country: </label>
            <form:input id="country" path="country"/>
        </p>
        <p>
            <label for="amount">Amount: </label>
            <form:input id="amount" path="amount"/>
        </p>
        <p>
            <form:input type="hidden" id="productID" path="productID" value="${model.order.id}"/><!-- model.order.id is for getting single value of model. As for foreach is a list use items -->
        </p>
        <p>
            <form:input type="hidden" id="userid" path="userid" value="${model.order.userid}"/><!-- model.order.id is for getting single value of model. As for foreach is a list use items -->
        </p>	
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Order">
        </p>
    </fieldset>
</form:form>
<div id="errormessage"></div>
</div>
</body>
</html>
