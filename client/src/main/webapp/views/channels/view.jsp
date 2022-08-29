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
</div>
<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
