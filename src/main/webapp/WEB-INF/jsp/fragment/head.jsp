<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:message code="jsp.title" var="i18n_title"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>${i18n_title}</title>
<base href="${pageContext.request.contextPath}/"/>
<link rel="icon" type="image/png" href="resources/image/customs-police-16.png" sizes="16x16"/>
<link rel="icon" type="image/png" href="resources/image/customs-police-24.png" sizes="24x24"/>
<link rel="icon" type="image/png" href="resources/image/customs-police-32.png" sizes="32x32"/>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap-select/1.12.4/css/bootstrap-select.min.css"/>
<link rel="stylesheet" type="text/css" href="webjars/datatables/1.10.19/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="webjars/datatables/1.10.19/css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="webjars/datatables-buttons/1.5.1/css/buttons.dataTables.min.css"/>