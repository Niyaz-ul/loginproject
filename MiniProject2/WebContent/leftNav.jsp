<html>
<head>
	<style>
		input[type="text"]
		{
			width:200px;
			height:30px;
			border:2px solid red;
			border-radius: 10px;
		
		}
		input[type="password"]
		{
			width:200px;
			height:30px;
			border:2px solid red;
			border-radius: 10px;
			margin:10px;
		
		}
		input[type="submit"]
		{
			padding:8px;
			background-color:cyan;
			color:black;
			border:none;
			border-radius:5px;
			
		}
		input[placeholder]
		{
			text-align:center;
			font-size:19px;
		}
	</style>
</head>
<body>
<br>
<center>
	<form action="test2">
			<input type="text" name="t1" placeholder="username" autocomplete="off"/><br>
			<input type="password" name="t2" placeholder="password" autocomplete="off"/><br>
			<input type="submit" value="LogIn"/>
	</form>
</center>
<br><br>
<center>
	<i>
	<a href="mainpage2.jsp">Registration</a>
	</i>
</center>
</body>
</html>