<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>President Result</title>
</head>
<body>
<c:if test="${! empty(sessionScope.presidents)}" >
		<c:forEach var="president" items="${ sessionScope.presidents }">
			<p>${president.firstName}
				${president.lastName}<br> In office: ${president.startYear} -
				${president.endYear}<br> Party: ${president.party}
			</p>
		</c:forEach>
		<form action="Presidents" method="POST">
			<input type="submit"  name="input" value="Previous" /> <input type="submit" name="input"
				value="Next" />
		</form>
	</c:if>
</body>
</html>