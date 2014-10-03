<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" ng-app="cabinReservation">
<head>
    <!-- bower:css -->
    <link rel="stylesheet" href="/static/fullcalendar/dist/fullcalendar.css" />
    <link rel="stylesheet" href="/static/bootstrap/dist/css/bootstrap.css" />
    <!-- endbower -->

    <!-- bower:js -->
    <script src="/static/jquery/dist/jquery.js"></script>
    <script src="/static/angular/angular.js"></script>
    <script src="/static/angular-cookies/angular-cookies.js"></script>
    <script src="/static/angular-resource/angular-resource.js"></script>
    <script src="/static/angular-ui-router/release/angular-ui-router.js"></script>
    <script src="/static/angular-hateoas/src/angular-hateoas.js"></script>
    <script src="/static/moment/moment.js"></script>
    <script src="/static/fullcalendar/dist/fullcalendar.js"></script>
    <script src="/static/bootstrap/dist/js/bootstrap.js"></script>
    <script src="/static/angular-bootstrap/ui-bootstrap-tpls.js"></script>
    <!-- endbower -->
</head>


<body>
    <%--<c:url value="/resources/text.txt" var="url"/>--%>
    <%--<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl"/>--%>
    <%--Spring URL: ${springUrl} at ${time}--%>
    <%--<br>--%>
    <%--JSTL URL: ${url}--%>
    <%--<br>--%>
    <%--Message: ${message}--%>

    <div class="container">
        <p>
        <ul class="nav nav-pills">
            <li><a href="#assets">Assets</a></li>
            <li><a href="#employees">Employees</a></li>

        </ul>

        </p>


        <div data-ui-view="results"></div>

        <div class="row">
            <div id="calendar" class="col-md-6"></div>
        </div>

    </div>

    <script src="<%=request.getContextPath()%>/app/app.js"></script>
    <script src="<%=request.getContextPath()%>/app/assets/controllers.js"></script>
    <script src="<%=request.getContextPath()%>/app/assets/services.js"></script>

    <script src="<%=request.getContextPath()%>/app/employees/services.js"></script>
    <script src="<%=request.getContextPath()%>/app/employees/controllers.js"></script>

    <script>
        $(function() {
            $('#calendar').fullCalendar({
                // put your options and callbacks here
            })
        });
    </script>
</body>

</html>
