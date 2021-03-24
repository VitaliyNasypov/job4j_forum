<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:choose>
        <c:when test="${post.id != null}"><title>Edit Post</title></c:when>
        <c:when test="${post.id == null}"><title>Add Post</title></c:when>
    </c:choose>
    <title>Edit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
</head>
<body>
<header class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-body border-bottom shadow-sm">
    <p class="h5 my-0 me-md-auto fw-normal">Forum job4j</p>
    <nav class="my-2 my-md-0 me-md-3">
        <a class="p-2 text-dark" href="<c:url value='/index'/>">Main</a>
        <a class="p-2 text-dark" href="<c:url value='/login'/>">Login</a>
        <a class="btn btn-outline-primary" href="<c:url value='/reg'/>">Sign up</a>
        <a class="btn btn-outline-primary" href="<c:url value='/logout'/>">NameUser | Logout</a>
    </nav>
</header>
<div class="container">
<c:choose>
        <c:when test="${post.id != null}">
         <form class="row g-3" action="<c:url value='/edit/save/${post.id}'/>" method='POST'>
        </c:when>
        <c:when test="${post.id == null}">
         <form class="row g-3" action="<c:url value='/edit/save/0'/>" method='POST'>
        </c:when>
    </c:choose>
            <div class="col-md-4">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${post.name}" required>
            </div>
            <br>
            <div class="col-md-4">
                <label for="description" class="form-label">Description</label>
                <input type="text" class="form-control" id="description" name="description" value="${post.description}" required>
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Save</button>
            </div>
        </form>
</div>
</body>
</html>