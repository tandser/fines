var ajaxPath = "ajax/fines/", table, formFilter, topsTable, topsModalWindow, notFoundModalWindow;

$(function () {
    table = $("#datatable").DataTable(append({
        "dom": "Bfrtip",
        "buttons": [
            "excel", {"extend": "pdf", "orientation": "landscape", "pageSize": "A4"}, "print"
        ],
        "columns": [{
            "data": "userName",
            "orderable": false
        }, {
            "data": "userPatronymic",
            "orderable": false
        }, {
            "data": "userSurname",
            "orderable": false
        }, {
            "data": "userLicenseNumber",
            "orderable": false
        }, {
            "data": "carBrand",
            "orderable": false
        }, {
            "data": "carModel",
            "orderable": false
        }, {
            "data": "carGovNumber",
            "orderable": false
        }, {
            "data": "dutyName",
            "orderable": false
        }, {
            "data": "dutyPrice",
            "orderable": false
        }, {
            "data": "fineStatus",
            "orderable": false
        }],
        "initComplete": varsInit
    }));

    topsTable = $("#topsDatatable").DataTable(append({
        "columns": [{
            "data": "dutyName",
            "orderable": false
        }, {
            "data": "count",
            "orderable": false
        }],
        "initComplete": varsInit
    }));
});

function append(opts) {
    $.extend(true, opts, {
        "searching": false,
        "paging"   : false,
        "info"     : false,
        "language" : {
            "loadingRecords": i18n["loadingRecords"],
            "search"        : i18n["search"],
            "zeroRecords"   : i18n["zeroRecords"]
        }
    });
    return opts;
}

function varsInit() {
    formFilter          = $("#formFilter");
    topsModalWindow     = $("#topsModalWindow");
    notFoundModalWindow = $("#notFoundModalWindow");
}

function getByLicenseNumberAndGovNumber() {
    $.ajax({
        url    : ajaxPath,
        type   : "POST",
        data   : formFilter.serialize(),
        success: function (data) {
            updateDatatable(data);
        }
    });
}

function getTops() {
    $.ajax({
        url    : ajaxPath + "tops",
        type   : "POST",
        data   : formFilter.serialize(),
        success: function (data) {
            if (!data || data.length == 0) {
                notFoundModalWindow.modal();
            } else {
                updateTopsDatatable(data);
                topsModalWindow.modal();
            }
        }
    });
}

function updateDatatable(data) {
    table.clear().rows.add(data).draw();
}

function updateTopsDatatable(data) {
    topsTable.clear().rows.add(data).draw();
}