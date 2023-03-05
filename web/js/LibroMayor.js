/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

$("#BtnBuscar").click(function () {

    var recolec = $('#formLibroMayor').serialize();

    $.getJSON("Controlador?URL=listar_libromayor", recolec, function (data) {
        $("#libro_mayor").empty();
        $.each(data, function (i, obj) {
            $("#libro_mayor").append(
                    "<tr>" +
                    "<td>" + obj.numero_cuenta + "</td>" +
                    "<td>" + obj.fecha_operacion + "</td>" +
                    "<td>" + obj.numero_correlativo + "</td>" +
                    "<td>" + obj.glosa + "</td>" +
                    "<td>" + obj.deudor + "</td>" +
                    "<td>" + obj.acreedor + "</td>" +
                    "</tr>"
                    );
        });
    });
});