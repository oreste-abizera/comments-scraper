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


<form class="mt-5 col-sm-4" style="margin: 0 auto; display: flex; gap: 30px" method="post" action="/channels/search">
    <div class="form-group">
        <input type="text" class="form-control" value="${searchKeyword}" name="searchKeyword" id="searchKeyword" placeholder="Enter Search Keyword">
    </div>
    <div>
    <button type="submit" class="btn btn-primary mt-4">Search</button>
    </div>
</form>
</div>
<%@ include file="../components/layout/page-footer.jsp" %>
</body>
</html>
