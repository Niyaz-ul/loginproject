<html>
<head>
	<script language="javascript" >
		function validate()
		{
			var name=document.myform.t1.value;
			var pass=document.myform.t2.value;
			var cpass=document.myform.t3.value;
			var email=document.myform.t4.value;
			if(name=="")
				{
				alert("Name is mandatory  ");
				document.myform.t1.focus();
				return false;
				}
			if(pass=="")
			{
			alert("Password is mandatory  ");
			document.myform.t2.focus();
			return false;
			}
			if(cpass=="")
			{
			alert("confirm Password is mandatory  ");
			document.myform.t3.focus();
			return false;
			}
			if(email=="")
			{
			alert("Email is mandatory  ");
			document.myform.t4.focus();
			return false;
			}
			
			return true;
		}
	</script>
</head>
<body>
<form action="test" name="myform" onsubmit="return validate()">
	<table align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="t1"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="t2"/></td>
			</tr>
			<tr>
				<td>Confirm password:</td>
				<td><input type="password" name="t3"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="t4"/></td>
			</tr>
			<tr>
				<td><input type="reset" value="reset"/></td>
				<td><input type="submit" value="submit"/></td>
			</tr>
	</table>

</form>
</body>
</html>