<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/layout/page-header.jsp" %>
</head>
<body>
<%@ include file="../components/atoms/navbar.jsp" %>
<div class="mt-2 container">
    <h3 class="alert alert-light">Search a Channel From Youtube</h3>

<c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
            ${error}
    </div>
</c:if>


<form class="mt-5 col-12" style="margin: 0 auto; display: flex;" method="post" action="/channels/search">
    <div style="display: flex; gap: 30px; width: 70%">
    <div class="form-group" style="flex: 1">
        <input type="text" class="form-control" value="${searchKeyword}" name="searchKeyword" id="searchKeyword" placeholder="Enter Search Keyword">
    </div>
    <div>
    <button type="submit" class="btn btn-primary mt-4">Search</button>
    </div>
    </div>
</form>

    <c:if test="${not empty channels}">
        <div class="row">
            <c:forEach items="${channels}" var="channel">
                <div class="col-sm-4" style="margin-top: 20px">
                    <div class="card">
                        <img class="card-img-top" src="${channel.snippet.thumbnails.medium.url}" alt="Card image cap" referrerpolicy="no-referrer">
                        <div class="card-body">
                            <h5 class="card-title">${channel.snippet.title}</h5>
                            <p class="card-text">${channel.snippet.description}</p>
                            <a href="/channels/view/${channel.id.channelId}?title=${channel.snippet.title}&description=${channel.snippet.description}&image=${channel.snippet.thumbnails.medium.url}" class="btn btn-primary">View</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
