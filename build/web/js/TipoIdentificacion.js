$(function () {
    Listar();
});

function Listar() {
    $.getJSON("Controlador?URL=listar_tipoidentificacion", {busq: ""}, function (data) {
        $("#tipo_identificacion").empty();
        $.each(data, function (i, obj) {
            $("#tipo_identificacion").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;


