$("#BtnBuscar").click(function () {

    var recolec = $('#formLibro').serialize();

    $.getJSON("Controlador?URL=listar_librocajabanco", recolec, function (data) {
        $("#libro_cajabanco").empty();
        $.each(data, function (i, obj) {
            $("#libro_cajabanco").append(
                    "<tr>" +
                    "<td>" + obj.numero_correlativo + "</td>" +
                    "<td>" + obj.fecha_operacion + "</td>" +
                    "<td>" + obj.descripcion + "</td>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.denominacion + "</td>" +
                    "<td>" + obj.deudor + "</td>" +
                    "<td>" + obj.acreedor + "</td>" +
                    "</tr>"
                    );
        });
    });
});