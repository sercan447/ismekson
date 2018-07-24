<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-9">
<title>Insert title here</title>
</head>
<body>

<c:if test="${param.error != null }">

</c:if>

<sec:authorize access="isAnonymous()">

<form name='f' action='${pageContext.request.contextPath }/login' method='POST'>
<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" /> <br/>
<table>
	<tr><td>TC:</td><td><input type='text' name='tc_no' value=''></td></tr>
	<tr><td>TELEFON:</td><td><input type='password' name='telefon'/></td></tr>
	<tr><td><input type='checkbox' name='hatirlabeni'/></td><td>Remember me on this computer.</td></tr>
	<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
</table>
</form>

</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	<p>${pageContext.request.userPrincipal.name }</p>
		<a href="${pageContext.request.contextPath }/logout">Çıkış Yap</a>
	</c:if>
	
</sec:authorize>

</body>
</html>