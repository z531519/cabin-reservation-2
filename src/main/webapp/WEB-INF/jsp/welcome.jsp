<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en" ng-app="cabinReservation">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link rel="stylesheet" href="/static/fullcalendar/dist/fullcalendar.css" />
    <link rel="stylesheet" href="/static/custom/boottheme/bootstrap.min.css" />
    <style type="text/css">
        body {
            padding-top: 60px;
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
    </style>
    <link href="/static/custom/boottheme/bootstrap-responsive.min.css" rel="stylesheet">

    <link href="/static/custom/boottheme/main.css" rel="stylesheet">

    <link rel="stylesheet" href="/static/custom.css" />
    <!-- bower:js -->
    <script src="/static/jquery/dist/jquery.js"></script>
    <script src="/static/jquery-ui/jquery-ui.js"></script>

    <script src="/static/ajaxq/functionq.js"></script>

    <script src="/static/angular/angular.js"></script>
    <script src="/static/angular-cookies/angular-cookies.js"></script>
    <script src="/static/angular-resource/angular-resource.js"></script>
    <script src="/static/angular-ui-router/release/angular-ui-router.js"></script>
    <script src="/static/angular-hateoas/src/angular-hateoas.js"></script>
    <script src="/static/moment/moment.js"></script>
    <script src="/static/fullcalendar/dist/fullcalendar.js"></script>
    <script src="/static/custom/boottheme/bootstrap.min.js"></script>
    <script src="/static/angular-bootstrap/ui-bootstrap-tpls.js"></script>
    <script src="/static/underscore/underscore.js"></script>
    <script src="/static/angular-underscore/angular-underscore.js"></script>
    <script src="/static/hammerjs/hammer.js"></script>
    <script src="/static/angular-hammer/angular-hammer.js"></script>
    <script src="/static/ngRepeatReorder/dist/ngRepeatReorder.js"></script>
    <script src="/static/angular-ui-sortable/sortable.js"></script>
    <!-- endbower -->


</head>


<body>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="btn btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>

                </a>
                <a class="brand" href="#">Cabin Reservation</a>
                <div class="nav-collapse collapse" style="height: 0px;">
                    <p class="navbar-text pull-right">Logged in as
                        <a href="#" class="navbar-link">Username</a>
                    </p>
                    <ul class="nav">
                        <li ng-class="{active: $state.includes('assets')}"><a ui-sref="assets">Assets</a></li>
                        <li ng-class="{active: $state.includes('employees')}"><a ui-sref="employees">Employees</a></li>
                        <li ng-class="{active: $state.includes('reservations')}"><a ui-sref="reservations">Reservations</a></li>
                        <li ng-class="{active: $state.includes('seasons')}"><a ui-sref="seasons">Season Bids</a></li>
                        <li ng-class="{active: $state.includes('employeebids')}"><a ui-sref="employeebids">Employee Bids</a></li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
    </div>


    <div class="container-fluid">

       <div class="row-fluid" data-ui-view>
        </div>
        <div class="row-fluid" data-ui-view="reservations"></div>
        <footer>
            <p>© Company 2013</p>
        </footer>
    </div>

   <%--<pre>--%>
      <%----%>
      <%--$state = {{$state.current.name}}--%>
      <%--$stateParams = {{$stateParams}}--%>
      <%--$state full url = {{ $state.$current.url.source }}--%>
      <%----%>
    <%--</pre>--%>


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

    <script src='/static/custom/boottheme/main.js'></script>

</body>

</html>
