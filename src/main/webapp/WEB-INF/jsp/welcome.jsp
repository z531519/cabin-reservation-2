<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <!-- bower:css -->
    <link rel="stylesheet" href="/static/bootstrap/dist/css/bootstrap.css" />
    <!-- endbower -->

    <!-- bower:js -->
    <script src="/static/jquery/dist/jquery.js"></script>
    <script src="/static/angular/angular.js"></script>
    <script src="/static/angular-cookies/angular-cookies.js"></script>
    <script src="/static/angular-resource/angular-resource.js"></script>
    <script src="/static/bootstrap/dist/js/bootstrap.js"></script>
    <!-- endbower -->
</head>


<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br>
	Message: ${message}

    <p>
        Section
    </p>

    <div data-ui-view="results"></div>


    <script src="<%=request.getContextPath()%>/app/app.js"></script>


</body>

</html>
