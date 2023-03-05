$(function () {
    Listar();
});

var numero = 0;
var cuenta_destino = 0;
var glosa = 0;
var id_detalle_plantilla = 0;
var cuenta_detalle_plantilla =0;

const btnLanzarModal = document.querySelector('#lanzar-modal');
const btnOcultarModal = document.querySelector('#ocultar-modal');
const btnEditar = document.querySelector('#editar');
const btnEliminar = document.querySelector('#eliminar');
const contModal = document.querySelector('.contenedor-modal');

const btnLanzarModalD = document.querySelector('#lanzar-modalD');
const btnOcultarModalD = document.querySelector('#ocultar-modalD');
const btnEditarD = document.querySelector('#editarD');
const btnEliminarD = document.querySelector('#eliminarD');
const contModalD = document.querySelector('.contenedor-modalD');

btnLanzarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
    
    var Inputnumero = document.getElementById("txtNumeroM");
    var Inputcuenta_destino = document.getElementById("txtCuenta_destinoM");
    var Inputglosa = document.getElementById("txtGlosaM");

    Inputnumero.value = numero;
    Inputcuenta_destino.value = cuenta_destino;
    Inputglosa.value = glosa;

});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');
});

function Recuperar(numero, cuenta, glosa) {

    this.numero = numero;
    this.cuenta_destino = cuenta;
    this.glosa = glosa;

}
;

function Listar() {
    $.getJSON("Controlador?URL=listar_plantillacierre", {busq: ""}, function (data) {
        $("#plantilla_asiento").empty();
        $.each(data, function (i, obj) {
            $("#plantilla_asiento").append(
                    "<tr onclick=\"Recuperar('" + obj.id + "','" + obj.cuentaDestino + "','" + obj.glosa + "')\">" +
                    "<td>" + obj.cuentaDestino + "</td>" +
                    "<td>" + obj.nombre_cuenta + "</td>" +
                    "<td>" + obj.glosa + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {

    var recolec = $('#formModal').serialize();

    $.ajax({
        url: 'Controlador?URL=modificar_plantillacierre',
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
        url: 'Controlador?URL=eliminar_plantillacierre',
        type: 'POST',
        data: {txtNumeroM: numero},
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            Listar();
        }
    });
}
;

$("#MostrarDetallePlantilla").click(function () {
    var divStyle = $("#AreaDetallePlantilla").prop("style");
    divStyle.removeProperty("opacity");
    divStyle.removeProperty("position");
    $("#CampoBloqueado1").remove();
    ListarDetallePlantilla();
    document.getElementById("txtId_detalle_plantillaM").value = numero;
});

btnLanzarModalD.addEventListener('click', (e) => {
    e.preventDefault();
    contModalD.classList.add('mostrar');
    
    var Inputid_detalle_plantilla = document.getElementById("txtId_detalle_plantillaM");
    var Inputcuenta_detalle_plantilla = document.getElementById("txtCuenta_detalle_plantillaM");

    Inputid_detalle_plantilla.value = id_detalle_plantilla;
    Inputcuenta_detalle_plantilla.value = cuenta_detalle_plantilla;

});

btnOcultarModalD.addEventListener('click', (e) => {
    e.preventDefault();
    contModalD.classList.remove('mostrar');
});

function RecuperarD(a, b) {

    id_detalle_plantilla = a;
    cuenta_detalle_plantilla = b;

}
;

function ListarDetallePlantilla() {
    $.getJSON("Controlador?URL=listar_detalleplantilla", {busq: numero}, function (data) {
        $("#detalle_plantilla").empty();
        $.each(data, function (i, obj) {
            $("#detalle_plantilla").append(
                    "<tr onclick=\"RecuperarD('"+ obj.id_detalle_plantilla + "','" + obj.cuenta + "')\">" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.cuenta + "</td>" +
                    "<td>" + obj.nombre_cuenta + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function EditarDetalle() {

    var recolec = $('#formModal').serialize();

    $.ajax({
        url: 'Controlador?URL=modificar_detalleplantilla',
        type: 'POST',
        data: recolec,
        success: function (e) {
            contModalD.classList.remove('mostrar');
            alert(e);
            ListarDetallePlantilla();
        }
    });
}
;

function EliminarDetalle() {
    $.ajax({
        url: 'Controlador?URL=eliminar_detalleplantilla',
        type: 'POST',
        data: {txtId_detalle_plantillaM: id_detalle_plantilla},
        success: function (e) {
            contModalD.classList.remove('mostrar');
            alert(e);
           ListarDetallePlantilla();
        }
    });
}
;