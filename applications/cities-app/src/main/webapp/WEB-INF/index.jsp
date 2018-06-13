<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
    <title>cities-app</title>
</head>

<body>
<h3>Load Cities</h3>
<form action="setup" method="POST" enctype="multipart/form-data">
    <input type="file" name="file" accept=".csv">
    <input type="submit" value="Upload">
</form>


<h3><a href="cities">Show Cities</a></h3>
</body>
</html>