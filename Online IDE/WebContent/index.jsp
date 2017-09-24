<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<form action="CompileAndRun" method=POST>
		<select id="type" name=type>
			<option value=java>Java</option>
			<option value=cpp>C++14 (gcc 6.0.3)</option>
			<option value=py>Python</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<button type=submit>run</button><br><br>
		<textarea rows=10 id=code name=code style="width:100%" placeholder="/*write your code here*/"></textarea><br><br>
		
				<!--  <textarea rows=10 id=res style="width:100%" name=res>%=request.getAttribute("res")%</textarea>
		-->
	</form>
	<form action="OnServletLogin" method=post>
		<input type=text name=userName placeholder=name><br><br>
		<input type=password name=userPass placeholder=****><br><br>
		<button type=submit name=Login>Login</button>
	</form>
</body>
</html>

<!-- tasklist /FI "IMAGENAME eq tomcat.exe" | find /C /I ".exe" > NUL -->