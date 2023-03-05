/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    ListarDetalleDocumento();

});

var inputdS = document.getElementById("debeSoles");
var inputhS = document.getElementById("haberSoles");
var inputdD = document.getElementById("debeDolares");
var inputhD = document.getElementById("haberDolares");
var Glosa;
var numeroCuenta;
var NumeroAsiento = 0;
var doc =
        "                                     <div class=\"card-body\">\n" +
        "                                        <span><h5>Documento</h5></span>\n" +
        "                                        <div class=\"container-fluid\">\n" +
        "                                            <div class=\"row g-3 align-items-center\">\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> Cta Auxiliar:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <input type=\"number\" name=\"txtCuentaCorriente\" id=\"CuentaCorriente\" class=\"form-control\" style=\"width: 140px;\">\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <input type=\"text\" class=\"form-control\" id=\"NomCuentaCorriente\" style=\"width: 400px;\" readonly>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <label  class=\"col-form-label\" style=\"display: flex;\">Clase Bien/ Servicio</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\"style=\"display: flex;\">\n" +
        "                                                    <input type=\"text\" name=\"txtClaseBien\" id=\"ClaseBien\" class=\"form-control\" style=\"width: 50px\">\n" +
        "                                                </div>\n" +
        "                                            </div>\n" +
        "                                            <div class=\"row g-3 align-items-center\">\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> Concepto:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <input type=\"text\" name=\"txtConcepto\" id=\"Concepto\" step=\"0.01\" class=\"form-control\" style=\"width: 440px;\">\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <label  class=\"col-form-label\" >Tip/Ser/Corr</label>&nbsp;&nbsp;&nbsp;\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"display: flex;\">\n" +
        "                                                    <div class=\"col-auto\" style=\"display: flex;\">\n" +
        "                                                        <input type=\"text\" id=\"NAtipD\" name=\"txtTipoD\" class=\"form-control\" style=\"width: 50px;\">\n" +
        "                                                        <input type=\"text\" id=\"SerieD\" name=\"txtSerie\" class=\"form-control\" style=\"width: 90px;\">\n" +
        "                                                        <input type=\"number\" id=\"CorreD\" name=\"txtCorrelativo\" class=\"form-control\" style=\"width: 90px;\">\n" +
        "                                                    </div>\n" +
        "                                                </div>\n" +
        "                                            </div>\n" +
        "                                            <div class=\"row g-3 align-items-center\" id=\"extras\">\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\">F. Emisión - Venc.</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <input type=\"date\" id=\"FechaED\" name=\"txtFechaEmision\" class=\"form-control\" style=\"width: 170px\">\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\">...</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <input type=\"date\" id=\"FechaVD\" name=\"txtFechaVencimiento\" class=\"form-control\" style=\"width: 170px\">\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> Monto ISC:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <input type=\"number\" name=\"txtMontoISC\" id=\"MontoISC\" step=\"0.01\" class=\"form-control\" style=\"width: 80px;\">\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> Otros M.:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <input type=\"number\" name=\"txtOtrosM\" id=\"OtrosM\" step=\"0.01\" class=\"form-control\" style=\"width: 80px;\">\n" +
        "                                                </div>\n" +
        "                                            </div>\n" +
        "                                            <div class=\"row g-3 align-items-center\" id=\"extras2\">\n" +
        "                                            </div>\n" +
        "                                        </div>\n" +
        "                                    </div>";
var baseImp42 =
        "                                                <div class=\"col-auto\" >\n" +
        "                                                    <label  class=\"col-form-label\"> BIAGCFOGE:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> MIGVIPMOPG:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> BIAGCFOGyNG:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> MIGVIPMOPGyNG:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> BIAGsinCF:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> MIGVIPMsinCF:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> ICBPER:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\"> VANG:</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtBIAGCFOGE\" id=\"BIAGCFOGE\" step=\"0.01\" class=\"form-control\" style=\"width: 95px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtMIGVIPMOPG\" id=\"MIGVIPMOPG\" step=\"0.01\" class=\"form-control\" style=\"width: 105px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtBIAGCFOGyNG\" id=\"BIAGCFOGyNG\" step=\"0.01\" class=\"form-control\" style=\"width: 120px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtMIGVIPMOPGyNG\" id=\"MIGVIPMOPGyNG\" step=\"0.01\" class=\"form-control\" style=\"width: 137px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtBIAGsinCF\" id=\"BIAGsinCF\" step=\"0.01\" class=\"form-control\" style=\"width: 83px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtMIGVIPMsinCF\" id=\"MIGVIPMsinCF\" step=\"0.01\" class=\"form-control\" style=\"width: 115px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtICBPER\" id=\"ICBPER\" step=\"0.01\" class=\"form-control\" style=\"width: 80px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"margin-top: 0px;\">\n" +
        "                                                    <input type=\"number\" name=\"txtVANG\" id=\"VANG\" step=\"0.01\" class=\"form-control\" style=\"width: 80px; margin-top: 0px;\">\n" +
        "                                                    <br>\n" +
        "                                                </div>\n";
var notaCredito =
        "                                                <div class=\"col-auto\">\n" +
        "                                                    <label  class=\"col-form-label\">Documento de Referencia</label>\n" +
        "                                                </div>\n" +
        "                                                <div class=\"col-auto\" style=\"display: flex;\">\n" +
        "                                                    <div class=\"col-auto\" style=\"display: flex;\">\n" +
        "                                                        <input type=\"text\" id=\"FKSerie\" name=\"txtfkSerie\" class=\"form-control\" style=\"width: 80px;\">\n" +
        "                                                        <input type=\"text\" id=\"FKCorre\" name=\"txtfkCorrelativo\" class=\"form-control\" style=\"width: 120px;\">\n" +
        "                                                    </div>\n" +
        "                                                </div>\n";

function ListarDetalleDocumento() {
    $.getJSON("Controlador?URL=listar_detalleasiento", function (data) {
        var debeDolares = 0;
        var debeSoles = 0;
        var haberSoles = 0;
        var haberDolares = 0;
        $("#detalle_asiento").empty();
        $.each(data, function (i, obj) {
            $("#detalle_asiento").append(
                    "<tr onclick=\"Recuperar('" + obj.cuenta + "')\">" +
                    "<td>" + obj.cuenta + "</td>" +
                    "<td>" + obj.nombrecc + "</td>" +
                    "<td>" + obj.debesoles + "</td>" +
                    "<td>" + obj.habersoles + "</td>" +
                    "<td>" + obj.debedolares + "</td>" +
                    "<td>" + obj.haberdolares + "</td>" +
                    "</tr>"
                    );
            debeDolares += obj.debedolares;
            debeSoles += obj.debesoles;
            haberSoles += obj.habersoles;
            haberDolares += obj.haberdolares;

        });
        inputdS.value = debeSoles.toFixed(2);
        inputhS.value = haberSoles.toFixed(2);
        inputdD.value = debeDolares.toFixed(2);
        inputhD.value = haberDolares.toFixed(2);

    });
}
;

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

function Recuperar(codigo) {

    numeroCuenta = codigo;
    var veri = codigo.toString().substring(0, 2);
    var tipocambio = document.getElementById("TCid").value;

    $.getJSON("Controlador?URL=recuperar_detalle", {cuentaContable: numeroCuenta}, function (data) {
        $("#detalle2").empty();
        var tipoDH;
        if (data.debesoles > 0 || data.debedolares > 0) {
            tipoDH = 0;
        } else {
            tipoDH = 1;
        }

        document.getElementById("NomCuentaC").value = data.cuenta;
        if (tipocambio === "1") {
            if (data.debesoles > 0) {
                document.getElementById("Importe").value = data.debesoles;
            } else {
                document.getElementById("Importe").value = data.habersoles;
            }
        } else {
            if (data.debedolares > 0) {
                document.getElementById("Importe").value = data.debedolares;
            } else {
                document.getElementById("Importe").value = data.haberdolares;
            }
        }
        document.getElementById("NomCContable").value = data.nombrecc;
        document.getElementById("SelectTipo").selectedIndex = tipoDH;

        if (veri === "12" || veri === "42") {
            $("#detalle2").empty();
            $.getJSON("Controlador?URL=recuperar_documento", function (docu) {
                $("#detalle2").append(doc);
                document.getElementById("CuentaCorriente").value = docu.numerocuentacorriente;
                $.getJSON("Controlador?URL=mostrar_nombreCCorriente", {cons: docu.numerocuentacorriente}, function (data) {
                    var inputNombreCCor = document.getElementById("NomCuentaCorriente");
                    inputNombreCCor.value = data;
                });
                document.getElementById("ClaseBien").value = docu.claseBien;
                document.getElementById("Concepto").value = docu.concepto;
                document.getElementById("NAtipD").value = docu.tipoDoc;
                document.getElementById("SerieD").value = docu.serie;
                document.getElementById("CorreD").value = docu.correlativo;
                document.querySelector('#FechaED').value = ConvertirFecha(docu.fechaEmision);
                document.querySelector('#FechaVD').value = ConvertirFecha(docu.fechaVencimiento);
                document.getElementById("MontoISC").value = docu.MontoISC;
                document.getElementById("OtrosM").value = docu.OtrosM;
                if (veri === "42") {
                    $("#extras").append(baseImp42);
                    document.getElementById("BIAGCFOGE").value = docu.BIAGCFOGE;
                    document.getElementById("MIGVIPMOPG").value = docu.MIGVIPMOPG;
                    document.getElementById("VANG").value = docu.VANG;
                    document.getElementById("BIAGCFOGyNG").value = docu.BIAGCFOGyNG;
                    document.getElementById("MIGVIPMOPGyNG").value = docu.MIGVIPMOPGyNG;
                    document.getElementById("BIAGsinCF").value = docu.BIAGsinCF;
                    document.getElementById("MIGVIPMsinCF").value = docu.MIGVIPMsinCF;
                    document.getElementById("ICBPER").value = docu.ICBPER;
                }

                if (docu.tipoDoc === "07") {
                    $("#extras2").append(notaCredito);
                    document.getElementById("FKSerie").value = docu.fkSerie;
                    document.getElementById("FKCorre").value = docu.fkCorrelativo;
                }
            });
        }
    });
}
;

$("#InputAjustar").click(function () {

    $.ajax({
        url: 'Controlador?URL=ajustar_cambio',
        type: 'POST',
        data: {debesoles: inputdS.value, habersoles: inputhS.value, debedolares: inputdD.value, haberdolares: inputhD.value},
        success: function (e) {
            alert(e);
            ListarDetalleDocumento();
        }
    });
});

$("#InputEstado").click(function () {
    var estado = document.getElementById("EstadoAsiento");
    if (estado.value === "TERMINADO") {
        estado.value = "PENDIENTE";
    } else {
        estado.value = "TERMINADO";
    }
});

$("#AgregarDetalle").click(function () {

    var recolec = $('#detalleForm').serialize();

    $.ajax({
        url: 'Controlador?URL=agregar_detalleasiento',
        type: 'POST',
        data: recolec,
        success: function (e) {
            alert(e);
            ListarDetalleDocumento();
            document.getElementById("NomCuentaC").value = "";
            document.getElementById("NomCContable").value = "";
            document.getElementById("Importe").value = "";
            $("#detalle2").empty();
        }
    });
});

$("#FinalizarAsiento").click(function () {

    if (inputdS.value === inputhS.value && inputdD.value === inputhD.value || document.getElementById("EstadoAsiento").value === "PENDIENTE") {
        var recolec = $('#finalizarForm').serialize();

        $.ajax({
            url: 'Controlador?URL=finalizar_asientocontable',
            type: 'POST',
            data: recolec,
            success: function (e) {
                alert(e);
                ListarDetalleDocumento();
                if (e === "AGREGADO") {
                    $('input[type="text"],input[type="number"],input[type="date"],input[type="checkbox"]').val('');
                }
            }
        });
    } else {
        alert("NO SE CUMPLE PARTIDA DOBLE");
    }
});

$("#CancelarAsiento").click(function () {

    $.ajax({
        url: 'Controlador?URL=cancelar_asientocontable',
        type: 'POST',
        success: function (e) {
            alert(e);
            $('input[type="text"],input[type="number"],input[type="date"]').val('');
            ListarDetalleDocumento();
            $("#detalles2").empty();
        }
    });
});

$("#ModificarDetalle").click(function () {

    var recolec = $('#detalleForm').serialize();

    $.ajax({
        url: 'Controlador?URL=modificar_detalleasiento&CuentaCC=' + numeroCuenta,
        type: 'POST',
        data: recolec,
        success: function (e) {
            alert("Detalle Modificado");
            ListarDetalleDocumento();
            document.getElementById("NomCuentaC").value = "";
            document.getElementById("NomCContable").value = "";
            document.getElementById("Importe").value = "";
            $("#detalle2").empty();
        }
    });
});

$("#EliminarDetalle").click(function () {

    $.ajax({
        url: 'Controlador?URL=eliminar_detalleasiento&CuentaCC=' + numeroCuenta,
        type: 'POST',
        success: function (e) {
            alert(e);
            ListarDetalleDocumento();
            $("#detalles2").empty();
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

        if (cons === "0101" || cons === "0201") {
            $("#detalle2").remove();
        }
    }
    ;
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#CuentaCorriente")) {
        var cons = e.target.value;
        $.getJSON("Controlador?URL=mostrar_nombreCCorriente", {cons: cons}, function (data) {
            var inputNombreCCor = document.getElementById("NomCuentaCorriente");
            inputNombreCCor.value = data;
        });
    }
    ;
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#Glosa")) {
        Glosa = e.target.value;
    }
    ;
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#NomCuentaC")) {
        var cons = e.target.value;
        $.getJSON("Controlador?URL=mostrar_nombreCC", {cons: cons}, function (data) {
            var inputNombreCC = document.getElementById("NomCContable");
            inputNombreCC.value = data;
        });
    }
    ;
});

$("#TCid").click(function () {
    var selector = document.getElementById("TCid").value;
    if (selector !== "") {
        var inputTP = document.getElementById("TCtxt");
        inputTP.value = selector;
    }
});

document.addEventListener("keyup", e => {

    var inputNAsiento = document.getElementById("NumeroAsiento");
    var TipOper = document.getElementById("TipoOper");
    if (TipOper.value === "0101") {
        inputNAsiento.value = "00000001";
    } else if (TipOper.value === "0201") {
        $.getJSON("Controlador?URL=agregar_numeroasiento", {tipAsiento: 3}, function (data) {
            inputNAsiento.value = "1300" + data;
            
        });
    } else {
        if (e.target.matches("#NAtipD")) {
            var cons = e.target.value;
            if (inputNAsiento.value.length < 8) {
                $.getJSON("Controlador?URL=agregar_numeroasiento", {tipAsiento: 2}, function (data) {
                    var mes = document.getElementById("NAfecha").value;

                    let date = new Date(mes);

                    if (date.getMonth() < 9) {
                        inputNAsiento.value = "0" + (date.getMonth() + 1) + cons + data;
                    } else {
                        inputNAsiento.value = (date.getMonth() + 1) + cons + data;
                    }
                });
            }
            ;
        }
    }
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#Importe")) {
        var cons = e.target.value;
        var importe = (cons) / 1.18;
        var impuesto = (cons * 0.18) / 1.18;
        document.getElementById("MontoISC").value = 0.00;
        document.getElementById("OtrosM").value = 0.00;
        document.getElementById("BIAGCFOGE").value = importe.toFixed(2);
        document.getElementById("MIGVIPMOPG").value = impuesto.toFixed(2);
        document.getElementById("VANG").value = 0.00;
        document.getElementById("BIAGCFOGyNG").value = 0.00;
        document.getElementById("MIGVIPMOPGyNG").value = 0.00;
        document.getElementById("BIAGsinCF").value = 0.00;
        document.getElementById("MIGVIPMsinCF").value = 0.00;
        document.getElementById("ICBPER").value = 0.00;


    }
});

document.addEventListener("keyup", e => {

    if (e.target.matches("#NomCuentaC")) {

        var cons = e.target.value;
        var codVerif = cons.toString().substring(0, 2);

        if (codVerif === "42") {
            $("#detalle2").empty();
            $("#detalle2").append(doc);
            $("#extras").append(baseImp42);

            var inputConcepto = document.getElementById("Concepto");
            inputConcepto.value = Glosa;
            //console.log(codVerif);
        } else if (codVerif === "12") {
            $("#detalle2").empty();
            $("#detalle2").append(doc);

            var inputConcepto = document.getElementById("Concepto");
            inputConcepto.value = Glosa;
        } else {
            $("#detalle2").empty();
        }
    } else if (e.target.matches("#NAtipD")) {
        var NotaCred = e.target.value;
        if (NotaCred === "07") {
            $("#extras2").empty();
            $("#extras2").append(notaCredito);
        } else {
            $("#extras2").empty();
        }
    }
}
);