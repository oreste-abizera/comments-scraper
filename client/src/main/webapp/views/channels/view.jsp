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
    <div class="row">
        <div class="col-md-12" style="display: flex;flex-direction: column; align-items: center">
            <h1 class="text-center"><%= title %></h1>
            <p class="text-center col-sm-6"><%= description %></p>
            <img class="img-fluid " src="<%= image %>" alt="<%= title %>">
        </div>
    </div>

    <form class="row" style="margin-top: 40px">
        <div class="col-md-12" style="display: flex;flex-direction: column; align-items: center">
            <a class="btn btn-primary" href="/channels/view/${channelId}/comments?title=<%= title %>&description=<%= description %>&image=<%= image %>">
            Search Comments</a>
        </div>
    </form>
</div>
<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
