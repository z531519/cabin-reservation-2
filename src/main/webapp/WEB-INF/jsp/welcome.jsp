<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" ng-app="cabinReservation">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- bower:css -->
    <link rel="stylesheet" href="/static/fullcalendar/dist/fullcalendar.css" />
    <link rel="stylesheet" href="/static/bootstrap/dist/css/bootstrap.css" />
    <!-- endbower -->
    <link rel="stylesheet" href="/static/custom.css" />
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
            <li ng-class="{active: $state.includes('assets')}"><a ui-sref="assets">Assets</a></li>
            <li ng-class="{active: $state.includes('employees')}"><a ui-sref="employees">Employees</a></li>
            <li ng-class="{active: $state.includes('reservations')}"><a ui-sref="reservations">Reservations</a></li>
            <li ng-class="{active: $state.includes('seasons')}"><a ui-sref="seasons">Season Bids</a></li>
            <li ng-class="{active: $state.includes('employeebids')}"><a ui-sref="employeebids">Employee Bids</a></li>
        </ul>

        </p>

       <div data-ui-view>



        </div>

        <div data-ui-view="reservations"></div>





    </div>

                   <pre>
      <!-- Here's some values to keep an eye on in the sample in order to understand $state and $stateParams -->
      $state = {{$state.current.name}}
      $stateParams = {{$stateParams}}
      $state full url = {{ $state.$current.url.source }}
      <!-- $state.$current is not a public api, we are using it to
           display the full url for learning purposes-->
    </pre>


    <script src="<%=request.getContextPath()%>/app/app.js"></script>
    <script src="<%=request.getContextPath()%>/app/assets/controllers.js"></script>
    <script src="<%=request.getContextPath()%>/app/assets/services.js"></script>

    <script src="<%=request.getContextPath()%>/app/employees/services.js"></script>
    <script src="<%=request.getContextPath()%>/app/employees/controllers.js"></script>

    <script src="<%=request.getContextPath()%>/app/reservations/services.js"></script>
    <script src="<%=request.getContextPath()%>/app/reservations/controllers.js"></script>

    <script src="<%=request.getContextPath()%>/app/seasonbids/seasonbids-services.js"></script>
    <script src="<%=request.getContextPath()%>/app/seasonbids/seasonbids-controllers.js"></script>

    <script src="<%=request.getContextPath()%>/app/employeebids/employeebids-services.js"></script>
    <script src="<%=request.getContextPath()%>/app/employeebids/employeebids-controllers.js"></script>

</body>

</html>
