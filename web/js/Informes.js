/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


const MostrarModalCompras = document.querySelector('#MostrarCompras');
const OcultarModalCompras = document.querySelector('#OcultarCompras');
const contModal = document.querySelector('.RCcontenedor-modal');
MostrarModalCompras.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.add('mostrar');
});
OcultarModalCompras.addEventListener('click', (e) => {
    e.preventDefault();
    contModal.classList.remove('mostrar');
});
const MostrarModalVentas = document.querySelector('#MostrarVentas');
const OcultarModalVentas = document.querySelector('#OcultarVentas');
const contModal1 = document.querySelector('.RVcontenedor-modal');
MostrarModalVentas.addEventListener('click', (e) => {
    e.preventDefault();
    contModal1.classList.add('mostrar');
});
OcultarModalVentas.addEventListener('click', (e) => {
    e.preventDefault();
    contModal1.classList.remove('mostrar');
});
const MostrarModalLD = document.querySelector('#MostrarLD');
const OcultarModalLD = document.querySelector('#OcultarLD');
const contModal2 = document.querySelector('.LDcontenedor-modal');
MostrarModalLD.addEventListener('click', (e) => {
    e.preventDefault();
    contModal2.classList.add('mostrar');
});
OcultarModalLD.addEventListener('click', (e) => {
    e.preventDefault();
    contModal2.classList.remove('mostrar');
});
const MostrarModalBC = document.querySelector('#MostrarBC');
const OcultarModalBC = document.querySelector('#OcultarBC');
const contModal3 = document.querySelector('.BCcontenedor-modal');
MostrarModalBC.addEventListener('click', (e) => {
    e.preventDefault();
    contModal3.classList.add('mostrar');
});
OcultarModalBC.addEventListener('click', (e) => {
    e.preventDefault();
    contModal3.classList.remove('mostrar');
});
const MostrarModalBG = document.querySelector('#MostrarBG');
const OcultarModalBG = document.querySelector('#OcultarBG');
const contModal4 = document.querySelector('.BGcontenedor-modal');
MostrarModalBG.addEventListener('click', (e) => {
    e.preventDefault();
    contModal4.classList.add('mostrar');
});
OcultarModalBG.addEventListener('click', (e) => {
    e.preventDefault();
    contModal4.classList.remove('mostrar');
});
const MostrarModalCyB = document.querySelector('#MostrarCyB');
const OcultarModalCyB = document.querySelector('#OcultarCyB');
const contModal41 = document.querySelector('.CyBcontenedor-modal');
MostrarModalCyB.addEventListener('click', (e) => {
    e.preventDefault();
    contModal41.classList.add('mostrar');
});
OcultarModalCyB.addEventListener('click', (e) => {
    e.preventDefault();
    contModal41.classList.remove('mostrar');
});
const MostrarModalLM = document.querySelector('#MostrarLM');
const OcultarModalLM = document.querySelector('#OcultarLM');
const contModal42 = document.querySelector('.LMcontenedor-modal');
MostrarModalLM.addEventListener('click', (e) => {
    e.preventDefault();
    contModal42.classList.add('mostrar');
});
OcultarModalLM.addEventListener('click', (e) => {
    e.preventDefault();
    contModal42.classList.remove('mostrar');
});
const MostrarModalEF = document.querySelector('#MostrarEF');
const OcultarModalEF = document.querySelector('#OcultarEF');
const contModal421 = document.querySelector('.EFcontenedor-modal');
MostrarModalEF.addEventListener('click', (e) => {
    e.preventDefault();
    contModal421.classList.add('mostrar');
});
OcultarModalEF.addEventListener('click', (e) => {
    e.preventDefault();
    contModal421.classList.remove('mostrar');
});
const MostrarModalIyB = document.querySelector('#MostrarIyB');
const OcultarModalIyB = document.querySelector('#OcultarIyB');
const contModal422 = document.querySelector('.IyBcontenedor-modal');
MostrarModalIyB.addEventListener('click', (e) => {
    e.preventDefault();
    contModal422.classList.add('mostrar');
});
OcultarModalIyB.addEventListener('click', (e) => {
    e.preventDefault();
    contModal422.classList.remove('mostrar');
});

function Recuperar() {
    var selector = document.getElementById("Selector").value;
    var FormBuscarSiniestro = $('#formIB');
    
    if (selector === "1") {
        FormBuscarSiniestro.attr("action", "RegistroInvBalCuenta10");
    } else if (selector === "2") {
        FormBuscarSiniestro.attr("action", "RegistroInvBalCuenta12");
    } else {
        FormBuscarSiniestro.attr("action", "RegistroInvBalCuenta42");
    }
}
