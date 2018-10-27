<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit Product Form</title>
<style type="text/css">@import url("<c:url value="/resources/css/main.css"/>");</style>
</head>
<body>
<div id="global">
<c:url var="formAction" value="/product/update-product"/>
<form:form commandName="product" action="${formAction}" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>Edit a book</legend>
        <form:hidden path="id"/>
        <p>
            <label for="name">Name: </label>
            <form:input id="name" path="name"/><!-- path is used to bind the input area with the attribute of Model object -->
        </p>
        <p>
            <label for="amount">Amount: </label>
            <form:input id="amount" path="amount"/><!-- path is used to bind the input area with the attribute of Model object -->
        </p>
        <p>
            <label for="price">Price: </label>
            $<form:input id="price" path="price"/>
        </p>
        <p>
            <label for="productImg">Product Image:</label> 
            <input type="file" name="file"/>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Update Product">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
