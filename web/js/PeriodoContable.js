$(function () {
    Listar();
});

var idPC = 0;
var estadoPC = "";

const btnLanzarModal = document.querySelector('#lanzar-modal');
const btnOcultarModal = document.querySelector('#ocultar-modal');
const btnEditar = document.querySelector('#editar');
const btnEliminar = document.querySelector('#eliminar');
const contModal = document.querySelector('.contenedor-modal');

btnLanzarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
    
    var Inputid = document.getElementById("idM");
    var Inputestado = document.getElementById("estadoM");
    
    Inputid.value = idPC;
    Inputestado.value = estadoPC;

});

btnOcultarModal.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');


});

function Recuperar(id,estado) {

    idPC = id;
    estadoPC = estado;
    
}
;

function Listar() {
    $.getJSON("Controlador?URL=listar_periodocontable", {busq: ""}, function (data) {
        $("#periodo_contable").empty();
        $.each(data, function (i, obj) {
            $("#periodo_contable").append(
                    "<tr onclick=\"Recuperar('"+obj.id+"','"+obj.estado+"')\">" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + obj.año + "</td>" +
                    "<td>" + obj.fecha_inicio + "</td>" +
                    "<td>" + obj.fecha_fin + "</td>" +
                    "<td>" + obj.estado + "</td>" +
                    "</tr>"
                    );
        });
    });
}
;

function Editar() {
    
    var recolec = $('#formModal').serialize();
    
    $.ajax({
        url: 'Controlador?URL=modificar_periodocontable',
        type: 'POST',
        data: recolec,
        success: function (e) {
            Listar();
            contModal.classList.remove('mostrar');
            alert(e);
        }
    });
}
;


