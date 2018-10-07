<%@ include file="/WEB-INF/views/include.jsp" %>
<html>
<head><title>Hello :: Spring Application for recipe sharing</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
function addstep(){
	$('<div><input type="text" name="id"/><input type="text" name="name"/><input type="text" name="pwd"/><input type="button" value="delete this step" id="deletethestep" onclick="deletethestep()"></div>').appendTo($('#stepbox'))
}
function deletethestep(){
	$(this).parent().remove();
}
</script>
</head>
<body>
<form action="/elec5619Springapp/newaddrecipe" method="post">
	<table>
		<tr>
			<td>recipeName:</td>
			<td><input type="text" name="recipeName"/></td>
		</tr>
		<tr>
			<td>cookTime:</td>
			<td><input type="text" name="cookTime"/></td>
		</tr>			
	</table>
	<div id="stepbox">
	 ID:<input type="text" name="id"><br/>
        Username:<input type="text" name="name"><br/>
        Password:<input type="text" name="pwd"><br/><br/>

        ID:<input type="text" name="id"><br/>
        Username:<input type="text" name="name"><br/>
        Password:<input type="text" name="pwd"><br/><br/>
        
        ID:<input type="text" name="id"><br/>
        Username:<input type="text" name="name"><br/>
        Password:<input type="text" name="pwd"><br/><br/>
     </div>
    <input type="button" value="add step" onclick="addstep();"/>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>