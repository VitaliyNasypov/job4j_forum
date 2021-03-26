<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Forum</title>
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
        <a class="btn btn-outline-primary" href="<c:url value='/logout'/>">${user.username} | Logout</a>
    </nav>
</header>
<div class="container">
    <c:if test="${user != null}">
        <a class="btn btn-primary" style="float:right" href="<c:url value='/edit/0'/>" role="button">New
            Discussion</a><br><br>
    </c:if>
    <c:forEach var="post" items="${posts}">
        <div class="card">
            <div class="card-header">
                <table style="width:100%">
                    <td><h5 class="card-title">${post.name}</h5></td>
                    <td><p class="card-text" style="float:right"><small>${post.formattedCalendar}</small></p></td>
                </table>
            </div>
            <div style="padding:1%">
                <div class="card-body">
                    <table style="width:100%">
                        <tr><p class="card-text">${post.description}</p></tr>
                        <tr>
                            <td style="width:80%">Author: ${user.username}</td>
                            <c:if test="${post.user.username == user.username}">
                                <td style="width:10%"><a href="<c:url value='/edit/${post.id}'/>"
                                                         class="btn btn-primary"
                                                         style="float:right">Edit</a></td>
                            </c:if>
                            <td style="width:10%"><a href="<c:url value='/post/${post.id}'/>" class="btn btn-primary"
                                                     style="float:right">View</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <br>
    </c:forEach>
</div>
</body>
</html>