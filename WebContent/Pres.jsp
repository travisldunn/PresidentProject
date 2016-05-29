<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<title>President</title>
</head>
<body>
	<form action="Presidents" method="POST">
		<h3>Which President would you like?</h3>
		Term Number:<input type="text" name="termNumber" /> <input
			type="submit" name="input" value="Submit" id="submit" />
	</form>		
	<c:if test="${! empty(sessionScope.presidents)}" >
			<p>${president.firstName}
				${president.lastName}<br> In office: ${president.startYear} -
				${president.endYear}<br> Party: ${president.party}
				<br>
				<img src="${president.picture}"/>
			</p>
		<form action="Presidents" method="POST">
			<input type="submit"  name="input" value="Previous" id="submit"/> <input type="submit" name="input"
				value="Next" id="submit"/>
		</form>
	</c:if>
</body>
</html>