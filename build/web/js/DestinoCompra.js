$(function () {
    Listar();
});

var cuenta_oC = 0;
var cuenta_cC = 0;
var cuenta_aC = 0;

const btnLanzarModal = document.querySelector('#lanzar-modal');
const btnOcultarModal = document.querySelector('#ocultar-modal');
const btnEditar = document.querySelector('#editar');
const btnEliminar = document.querySelector('#eliminar');
const contModal = document.querySelector('.contenedor-modal');

btnLanzarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
    var Inputcuenta_o = document.getElementById("cuenta_origenM");
    var Inputcuenta_c = document.getElementById("cuenta_cargoM");
    var Inputcuenta_a = document.getElementById("cuenta_abonoM");

    Inputcuenta_o.value = cuenta_oC;
    Inputcuenta_c.value = cuenta_cC;
    Inputcuenta_a.value = cuenta_aC;

});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');


});

function Recuperar(cuenta_origen, cuenta_cargo, cuenta_abono) {

    cuenta_oC = cuenta_origen;
    cuenta_cC = cuenta_cargo;
    cuenta_aC = cuenta_abono;

}
;

function Listar() {
    $.getJSON("Controlador?URL=listar_destinocompra", {busq: ""}, function (data) {
        $("#destino_compra").empty();
        $.each(data, function (i, obj) {
            $("#destino_compra").append(
                    "<tr onclick=\"Recuperar('"+ obj.cuenta_origen + "','" + obj.cuenta_cargo + "','" + obj.cuenta_abono + "')\">" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.cuenta_origen + "</td>" +
                    "<td>" + obj.cuenta_cargo + "</td>" +
                    "<td>" + obj.cuenta_abono + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {

    var recolec = $('#formModal').serialize();

    $.ajax({
        url: 'Controlador?URL=modificar_destinocompra',
        type: 'POST',
        data: recolec,
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            Listar();
        }
    });
}
;

function Eliminar() {
    $.ajax({
        url: 'Controlador?URL=eliminar_destinocompra',
        type: 'POST',
        data: {txtCuenta_origenM: cuenta_oC},
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            Listar();
        }
    });
}
;

