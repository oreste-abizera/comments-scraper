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

    <c:if test="${not empty comments}">
        <div class="row">
            <div class="col-md-12">
                <h3>Comments</h3>
                <div class="row">
                    <div class="col-md-12">
                        <c:forEach items="${comments}" var="comment">
                            <div class="row" style="margin-top: 10px">
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class="col-md-12" style="display: flex; gap: 20px; align-items: center">
                                            <div>
                                                <img class="img-fluid rounded-circle" style="border-radius: 50%" src="${comment.snippet.topLevelComment.snippet.authorProfileImageUrl}" alt="${comment.snippet.topLevelComment.snippet.authorDisplayName}" referrerpolicy="no-referrer">
                                            </div>
                                            <div>
                                            <h4>${comment.snippet.topLevelComment.snippet.authorDisplayName}</h4>
                                            <p>${comment.snippet.topLevelComment.snippet.textDisplay}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

</div>
<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
