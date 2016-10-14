<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <h1 th:inline="text">admin</h1>
        <p><a th:href="@{/user}">admin</a></p>
        <form th:action="@{/logout}" method="post">
            <input type="submit" value="ç»åº"/>
        </form>
    </body>
</html>