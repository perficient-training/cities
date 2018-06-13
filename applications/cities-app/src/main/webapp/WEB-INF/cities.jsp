<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities</title>
    <link href="default.css" rel="stylesheet">

</head>
<body>
<h2>Cities</h2>
<table>
    <tr>
        <th>Name</th>
        <th>County</th>
        <th>State</th>
        <th>Postal Code</th>
        <th>Latitude</th>
        <th>Longitude</th>
    </tr>

    <c:forEach items="${requestScope.cities}" var="city">
        <tr>
            <td> ${city.name} </td>
            <td> ${city.county} </td>
            <td> ${city.stateCode} </td>
            <td> ${city.postalCode} </td>
            <td> ${city.latitude} </td>
            <td> ${city.longitude} </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
