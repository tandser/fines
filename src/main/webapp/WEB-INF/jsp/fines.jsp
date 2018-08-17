<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>

<spring:message code="jsp.title"                     var="i18n_title"/>
<spring:message code="jsp.userName"                  var="i18n_userName"/>
<spring:message code="jsp.userPatronymic"            var="i18n_userPatronymic"/>
<spring:message code="jsp.userSurname"               var="i18n_userSurname"/>
<spring:message code="jsp.userLicenseNumber"         var="i18n_userLicenseNumber"/>
<spring:message code="jsp.carBrand"                  var="i18n_carBrand"/>
<spring:message code="jsp.carModel"                  var="i18n_carModel"/>
<spring:message code="jsp.carGovNumber"              var="i18n_carGovNumber"/>
<spring:message code="jsp.dutyName"                  var="i18n_dutyName"/>
<spring:message code="jsp.dutyPrice"                 var="i18n_dutyPrice"/>
<spring:message code="jsp.fineStatus"                var="i18n_fineStatus"/>
<spring:message code="jsp.search"                    var="i18n_search"/>
<spring:message code="jsp.tops"                      var="i18n_tops"/>
<spring:message code="jsp.datatables.loadingRecords" var="i18n_datatables_loadingRecords"/>
<spring:message code="jsp.datatables.search"         var="i18n_datatables_search"/>
<spring:message code="jsp.datatables.zeroRecords"    var="i18n_datatables_zeroRecords"/>
<spring:message code="jsp.tops"                      var="i18n_tops"/>
<spring:message code="jsp.fineCount"                 var="i18n_fineCount"/>
<spring:message code="jsp.reset"                     var="i18n_reset"/>
<spring:message code="jsp.notFound"                  var="i18n_notFound"/>

<html>
    <head>
        <jsp:include page="fragment/head.jsp"/>
    </head>
    <body>
        <div class="jumbotron">
            <div class="container">
                <form class="form-inline" id="formFilter">
                    <div class="form-group mb-2">
                        <input class="form-control" id="licenseNumber" name="licenseNumber" type="text" placeholder="${i18n_userLicenseNumber}"/>
                    </div>
                    <div class="form-group mx-sm-3 mb-2">
                        <input class="form-control" id="govNumber" name="govNumber" type="text" placeholder="${i18n_carGovNumber}"/>
                    </div>
                    <button class="btn btn-primary mb-2" onclick="getByLicenseNumberAndGovNumber()" type="button">${i18n_search}</button>
                    <button class="btn btn-default mx-sm-3 mb-2" type="reset">${i18n_reset}</button>
                    <button class="btn btn btn-warning mb-2" onclick="getTops()" type="button">${i18n_tops}</button>
                </form>
                <table class="" id="datatable" style="width:100%">
                    <thead>
                    <tr>
                        <th>${i18n_userName}</th>
                        <th>${i18n_userPatronymic}</th>
                        <th>${i18n_userSurname}</th>
                        <th>${i18n_userLicenseNumber}</th>
                        <th>${i18n_carBrand}</th>
                        <th>${i18n_carModel}</th>
                        <th>${i18n_carGovNumber}</th>
                        <th>${i18n_dutyName}</th>
                        <th>${i18n_dutyPrice}</th>
                        <th>${i18n_fineStatus}</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
        <div class="fade modal" id="topsModalWindow">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">${i18n_tops}</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <table class="" id="topsDatatable" style="width:100%">
                            <thead>
                            <tr>
                                <th>${i18n_dutyName}</th>
                                <th>${i18n_fineCount}</th>
                            </tr>
                            </thead>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="fade modal" id="notFoundModalWindow">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">${i18n_tops}</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p class="text-center">${i18n_notFound}</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <jsp:include page="fragment/foot.jsp"/>
    <script type="text/javascript">
        var i18n = [];

        i18n["loadingRecords"] = "${i18n_datatables_loadingRecords}";
        i18n["search"]         = "${i18n_datatables_search}";
        i18n["zeroRecords"]    = "${i18n_datatables_zeroRecords}";
    </script>
</html>