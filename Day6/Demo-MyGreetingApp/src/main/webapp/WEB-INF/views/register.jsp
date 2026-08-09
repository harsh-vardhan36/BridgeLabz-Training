<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Registration</title>
</head>

<body>

    <h1>Register</h1>

    <form:form action="register" method="post" modelAttribute="user">

        <label>Name:</label>
        <input type="text" name="name">

        <form:errors path="name" />

        <br><br>

        <label>Email:</label>
        <input type="email" name="email">

        <form:errors path="email" />

        <br><br>

        <label>Password:</label>
        <input type="password" name="password">

        <form:errors path="password" />

        <br><br>

        <button type="submit">Register</button>

    </form:form>

</body>

</html>