<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<body>
<h1>Products List Result</h1>
<ul>
    <c:forEach var="item" items="${products}">
        <li>   id: ${item.id}</li>
        <li>title: ${item.title}</li>
        <li> cost: ${item.cost}</li>
        <br>
    </c:forEach>
</ul>
</body>
</html>