 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body>

<form:form  action = "resultAddProduct" modelAttribute="product">
    id: <form:input path="id" />
    <br>
    title: <form:input path="title" />
    <br>
    cost: <form:input path="cost" />

    <input type="submit" value="Submit" />
</form:form>

</body>
</html>

