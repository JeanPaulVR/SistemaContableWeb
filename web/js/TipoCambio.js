$(function () {
    Listar();
});

function Listar() {
    $.getJSON("Controlador?URL=listar_tipocambio", {busq: ""}, function (data) {
        $("#tipo_cambio").empty();
        $.each(data, function (i, obj) {
            $("#tipo_cambio").append(
                    "<tr>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.id + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "<td>" + obj.fecha + "</td>" +
                    "<td>" + obj.precio_compra + "</td>" +
                    "<td>" + obj.precio_venta + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

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
    if (e.target.matches("#TipoOper1")) {
        var cons = e.target.value;
        $.getJSON("Controlador?URL=mostrar_nombreTO", {cons: cons}, function (data) {
            var inputNombre = document.getElementById("NomTipOp1");
            inputNombre.value = data;
        });

        if (cons === "0101" || cons === "0201") {
            $("#detalle2").remove();
        }
    }
    ;
    if (e.target.matches("#TipoOper2")) {
        var cons = e.target.value;
        $.getJSON("Controlador?URL=mostrar_nombreTO", {cons: cons}, function (data) {
            var inputNombre = document.getElementById("NomTipOp2");
            inputNombre.value = data;
        });

        if (cons === "0101" || cons === "0201") {
            $("#detalle2").remove();
        }
    }
    ;
});

const MostrarModalCR = document.querySelector('#MostrarCR');
const OcultarModalCR = document.querySelector('#OcultarCR');
const contModal4 = document.querySelector('.CRcontenedor-modal');

MostrarModalCR.addEventListener('click', (e) => {
    e.preventDefault();
    contModal4.classList.add('mostrar');
    
});

OcultarModalCR.addEventListener('click', (e) => {
    e.preventDefault();
    contModal4.classList.remove('mostrar');

});

const MostrarModalCB = document.querySelector('#MostrarCB');
const OcultarModalCB = document.querySelector('#OcultarCB');
const contModal5 = document.querySelector('.CBcontenedor-modal');

MostrarModalCB.addEventListener('click', (e) => {
    e.preventDefault();
    contModal5.classList.add('mostrar');
    
});

OcultarModalCB.addEventListener('click', (e) => {
    e.preventDefault();
    contModal5.classList.remove('mostrar');

});

const MostrarModalAA = document.querySelector('#MostrarAA');
const OcultarModalAA = document.querySelector('#OcultarAA');
const contModal6 = document.querySelector('.AAcontenedor-modal');

MostrarModalAA.addEventListener('click', (e) => {
    e.preventDefault();
    contModal6.classList.add('mostrar');
    
});

OcultarModalAA.addEventListener('click', (e) => {
    e.preventDefault();
    contModal6.classList.remove('mostrar');

});
