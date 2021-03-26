<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Post</title>
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
    <div class="mb-3">
        <div class="card">
            <div class="card-header">
                <table style="width:100%">
                    <td><h5 class="card-title">${post.name}</h5></td>
                    <td><p class="card-text" style="float:right"><small>${post.formattedCalendar}</small></p></td>
                </table>
            </div>
            <div style="padding:1%">
                <div class="card-body">
                    ${post.description}
                </div>
            </div>
        </div>
        <br>
        <c:forEach var="comment" items="${post.comments}">
            <div class="card" style="padding:1%">
                <div class="card-body">
                    ${comment.text}
                </div>
                <hr>
                <table style="width:100%">
                    <td><strong class="me-auto"> ${comment.user.username}</strong></td>
                    <td><p class="card-text" style="float:right"><small>${comment.formattedCalendar}</small></p></td>
                </table>
            </div>
            <br>
        </c:forEach>
        <br>
        <form class="row g-3" name='login' action="<c:url value='/post/add/${post.id}'/>" method='POST'>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name='comment' required></textarea>
            <div class="col-12">
                <button type="submit" class="btn btn-primary" style="float:right">Add comment</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>