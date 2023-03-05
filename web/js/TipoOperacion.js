$(function () {
    Listar();
});

var codigoC = 0;
var nombreC = 0;
var tipo_cambioC = 0;

const btnLanzarModal = document.querySelector('#lanzar-modal');
const btnOcultarModal = document.querySelector('#ocultar-modal');
const btnEditar = document.querySelector('#editar');
const btnEliminar = document.querySelector('#eliminar');
const contModal = document.querySelector('.contenedor-modal');

btnLanzarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
    var Inputcodigo = document.getElementById("codigoM");
    var Inputnombre = document.getElementById("nombreM");
    var Inputtipo_cambio = document.getElementById("tipo_cambioM");

    Inputcodigo.value = codigoC;
    Inputnombre.value = nombreC;
    Inputtipo_cambio.value = tipo_cambioC;

});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');


});

function Recuperar(codigo, nombre, tipo_cambio) {

    codigoC = codigo;
    nombreC = nombre;
    tipo_cambioC = tipo_cambio;

}
;

function Listar() {
    $.getJSON("Controlador?URL=listar_tipooperacion", {busq: ""}, function (data) {
        $("#tipo_operacion").empty();
        $.each(data, function (i, obj) {
            $("#tipo_operacion").append(
                    "<tr onclick=\"Recuperar('"+ obj.codigo + "','" + obj.nombre + "','" + obj.tipo_cambio + "')\">" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "<td>" + obj.tipo_cambio + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {

    var recolec = $('#formModal').serialize();

    $.ajax({
        url: 'Controlador?URL=modificar_tipooperacion',
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
        url: 'Controlador?URL=eliminar_tipooperacion',
        type: 'POST',
        data: {txtCodigoM: codigoC},
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            Listar();
        }
    });
}
;

