<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="../components/layout/page-header.jsp" %>
</head>
<body>
<%@ include file="../components/atoms/navbar.jsp" %>
<%
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    String image = request.getParameter("image");

    // function to format date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
%>
<div class="mt-5 container">
    <div class="row" style="margin-bottom: 20px">
        <div class="col-md-12" style="display: flex;flex-direction: column; align-items: center">
            <h1 class="text-center"><%= title %></h1>
            <p class="text-center col-sm-6"><%= description %></p>
            <img class="img-fluid " src="<%= image %>" alt="<%= title %>">
        </div>
    </div>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert" style="margin-bottom: 20px;">
                ${error}
        </div>
    </c:if>

        <div class="row">
            <div class="col-md-12">
                <form style="display: flex; gap: 15px">
                <h3>Comments</h3>
<%--                   choose number of comments input --%>
                <div action="/channels/view/${channelId}/comments" method="get">
                    <input type="hidden" name="title" value=<%= title %>>
                    <input type="hidden" name="description" value=<%= description %>>
                    <input type="hidden" name="image" value=<%= image %>>
                    <input type="number" name="limit" value="${limit}" min="1">
                    <input type="submit" value="Set Limit">
                </div>

                    <div>
<%--                       search comments input --%>
                        <input type="text" name="searchKeyword" value="${searchKeyword}">
                        <input type="submit" value="Search">
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-12">
                        <c:if test="${empty comments}">
                            <p>No comments Found</p>
                        </c:if>
                        <c:if test="${not empty comments}">
                            <p>Showing ${comments.size()} comments</p>

                        <c:forEach items="${comments}" var="comment">
                            <div class="row" style="margin-top: 10px">
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="col-md-12" style="display: flex; gap: 20px; align-items: center">
                                            <div>
                                                <img class="img-fluid rounded-circle" style="border-radius: 50%" src="${comment.snippet.topLevelComment.snippet.authorProfileImageUrl}" alt="${comment.snippet.topLevelComment.snippet.authorDisplayName}" referrerpolicy="no-referrer">
                                            </div>
                                            <div>
                                                <div style="display: flex; gap: 10px">
                                                    <h5>${comment.snippet.topLevelComment.snippet.authorDisplayName}</h5>
                                                    <p>On <a href="https://www.youtube.com/watch?v=${comment.snippet.videoId}">${comment.snippet.videoId}</a></p>
                                                <p>At ${comment.snippet.topLevelComment.snippet.publishedAt }</p>
                                                </p>
                                                </div>
                                                <p>${comment.snippet.topLevelComment.snippet.textDisplay}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>

</div>
<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
