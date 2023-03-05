/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

$(function () {
    ListarCuentasCorriente();
});

var numeroC = 0;
var denominacionC = 0;
var paisC = 0;
var direccionC = 0;
var idtipoC = 0;


const btnLanzarModal = document.querySelector('#lanzar-modal');
const btnOcultarModal = document.querySelector('#ocultar-modal');
const btnEditar = document.querySelector('#editar');
const btnEliminar = document.querySelector('#eliminar');
const contModal = document.querySelector('.contenedor-modal');

btnLanzarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
    var Inputidtipo = document.getElementById("idtipoM");
    var Inputnumero = document.getElementById("numeroM");
    var Inputdenominacion = document.getElementById("denominacionM");
    var Inputpais = document.getElementById("paisM");
    var Inputdireccion = document.getElementById("direccionM");



    Inputidtipo.value = idtipoC;
    Inputnumero.value = numeroC;
    Inputdenominacion.value = denominacionC;
    Inputpais.value = paisC;
    Inputdireccion.value = direccionC;


});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');


});

function Recuperar(numero, denominacion, pais, direccion, idtipo) {

    idtipoC = idtipo;
    numeroC = numero;
    denominacionC = denominacion;
    paisC = pais;
    direccionC = direccion;


}
;

function ListarCuentasCorriente() {
    $.getJSON("Controlador?URL=listar_cuentacorriente", {busq: ""}, function (data) {
        $("#cuenta_corriente").empty();
        $.each(data, function (i, obj) {
            $("#cuenta_corriente").append(
                    "<tr onclick=\"Recuperar('"+ obj.numero + "','" + obj.denominacion + "','" + obj.pais + "','" + obj.direccion + "','" + obj.idtipo + "')\">" +
                    "<td>" + obj.idtipo + "</td>" +
                    "<td>" + obj.numero + "</td>" +
                    "<td>" + obj.denominacion + "</td>" +
                    "<td>" + obj.pais + "</td>" +
                    "<td>" + obj.direccion + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {

    var recolec = $('#formModal').serialize();

    $.ajax({
        url: 'Controlador?URL=modificar_cuentacorriente',
        type: 'POST',
        data: recolec,
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            ListarCuentasCorriente();
        }
    });
}
;

function Eliminar() {
    $.ajax({
        url: 'Controlador?URL=eliminar_cuentacorriente',
        type: 'POST',
        data: {txtNumeroM: numeroC},
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            ListarCuentasCorriente();
        }
    });
}
;

