<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
 <%@ taglib prefix = "C" uri ="http://java.sun.com/jstl/core_rt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%= request.getAttribute("msginsertstudent")!= null ? request.getAttribute("msginsertstudent"): " " %></h3>
 <form action = "HomeController" method = "POST">
	
	<h3>PERSONAL FORM</h3>
		Student Name : <input type = "text" name = "studentname"/>
		<br/>
		<br/>
		<select name = "dropdownprovince">
		Province :	
		<c:forEach items = "${listprovince}" value = "l">
					<option value = "${l.provinceid}">${l.provincename}</option>
		</c:forEach>			
		</select>
		<br/>
		<br/>
				<input type = "submit" value = "registor" />
	
</form>
</body>
</html>