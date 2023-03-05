/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

$(function () {
    ListarCuentas();
});

var codigoC = 0;
var nombreC = 0;

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
    
    
    Inputcodigo.value = codigoC;
    Inputnombre.value = nombreC;
    
});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');


});

function Recuperar(codigo, nombre) {

    codigoC = codigo;
    nombreC = nombre;
    
}
;

function ListarCuentas() {
    $.getJSON("Controlador?URL=listar_clasebien", {busq: ""}, function (data) {
        $("#clase_bien").empty();
        $.each(data, function (i, obj) {
            $("#clase_bien").append(
                    "<tr onclick=\"Recuperar('"+obj.codigo+"','"+obj.nombre+"')\">" +
                    "<td>" + obj.codigo + "</td>" +
                    "<td>" + obj.nombre + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {
    
    var recolec = $('#formModal').serialize();
    
    $.ajax({
        url: 'Controlador?URL=modificar_clasebien',
        type: 'POST',
        data: recolec,
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            ListarCuentas();
        }
    });
}
;

function Eliminar() {
    $.ajax({
        url: 'Controlador?URL=eliminar_clasebien',
        type: 'POST',
        data: {txtCodigoM: codigoC},
        success: function (e) {
            contModal.classList.remove('mostrar');
            alert(e);
            ListarCuentas();
        }
    });
}
;

