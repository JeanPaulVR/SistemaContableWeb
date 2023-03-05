


$("#BtnBuscarTeso").click(function () {
    var recolec = $('#formTesoreria').serialize();
    $.getJSON("Controlador?URL=listar_asientotesoreria", recolec, function (data) {
        $("#asiento_tesoreria").empty();
        $.each(data, function (i, teso) {
            $("#asiento_tesoreria").append(
                    "<tr onclick=\"RecuperarNA('" + teso.tipo_documento + "','" + teso.serie + "')\">" +
                    "<td>" + teso.tipo_documento + "</td>" +
                    "<td>" + teso.cuenta_auxiliar + "</td>" +
                    "<td>" + teso.tipo_documento + "</td>" +
                    "<td>" + teso.moneda + "</td>" +
                    "<td>" + teso.importeS + "</td>" +
                    "<td>" + teso.importeD + "</td>" +
                    "</tr>"
                    );

            //Llenado de inputs hidden
            document.getElementById("TipoDocH").value = teso.tipo_documento;
            document.getElementById("CuentaAuxH").value = teso.cuenta_auxiliar;
            document.getElementById("ClaseBienH").value = teso.Clase_Bien;
            document.getElementById("ImporteH").value = teso.importeS;
            document.getElementById("DebeHaberH").value = teso.Debe_Haber;
            document.getElementById("SerieH").value = teso.serie;
            document.getElementById("CuentaContH").value = teso.numero_cuentac;

            //Numero Asiento
            inputNAsiento = document.getElementById("NumeroAsiento");

            $.getJSON("Controlador?URL=agregar_numeroasiento", {tipAsiento: 2}, function (data) {

                var mes = document.getElementById("NAfecha").value;
                let date = new Date(mes);

                if (date.getMonth() < 9) {
                    inputNAsiento.value = "0" + (date.getMonth() + 1) + teso.tipo_documento + data;
                } else {
                    inputNAsiento.value = (date.getMonth() + 1) + teso.tipo_documento + data;
                }
            });
        });
    });
});



function ConvertirFecha(Sfecha) {
    let translation = {
        "ene": "Jan",
        "feb": "Feb",
        "mar": "Mar",
        "abr": "Apr",
        "may": "May",
        "jun": "Jun",
        "jul": "Jul",
        "ago": "Aug",
        "sep": "Sep",
        "oct": "Oct",
        "nov": "Nov",
        "dic": "Dec"
    };
    let month = Sfecha.substring(0, 3);
    let translatedMonth = translation[month];
    let recognizableDateString = translatedMonth + Sfecha.substring(3);
    let parsedDate = Date.parse(recognizableDateString);
    let date = new Date(parsedDate);
    let str = date.toJSON().slice(0, 10);
    return str;
}
;
$("#FinalizarAsientoTesoreria").click(function () {

    var recolec = $('#finalizarFormteso').serialize();

    $.ajax({
        url: 'Controlador?URL=finalizar_asientotesoreria',
        type: 'POST',
        data: recolec,
        success: function (e) {
            alert(e);
            ListarDetalleDocumento();
            if (e === "AGREGADO") {
                $('input[type="text"],input[type="number"],input[type="date"]').val('');
            }
        }
    });
});

$("#CancelarAsiento").click(function () {

    $.ajax({
        url: 'Controlador?URL=cancelar_asientocontable',
        type: 'POST',
        success: function (e) {
            alert(e);
            $('input[type="text"],input[type="number"],input[type="date"]').val('');
            $("#asiento_tesoreria").empty();
        }
    });
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#TipoOper")) {
        var cons = e.target.value;
        $.getJSON("Controlador?URL=mostrar_nombreTO", {cons: cons}, function (data) {
            var inputNombre = document.getElementById("NomTipOp");
            inputNombre.value = data;
        });
    }
    ;
});
