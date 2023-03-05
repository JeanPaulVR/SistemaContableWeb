<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"><link rel="stylesheet" href="css/panelcss.css">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/panelcss.css">
        <title>Dashboard</title>
    </head>
    <body>
        <!-- Barra Lateral -->
        <section id="sidebar">
            <a href="#" class="brand">
                <i class='bx bxs-smile'></i>
                <span class="text">Sistema C.</span>
            </a>
            <ul class="side-menu top">
                <li>
                    <a href="Controlador?URL=area_dashboard">
                        <i class='bx bxs-dashboard' ></i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_plancontable">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Mantenimiento</span>
                    </a>
                </li>
                <li class="active">
                    <a href="Controlador?URL=area_tipocambio">
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="text">Operaciones</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_librodiario">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Consultas</span>
                    </a>
                </li>
                <li>
                    <a href="Controlador?URL=area_informes">
                        <i class='bx bxs-group' ></i>
                        <span class="text">Informes</span>
                    </a>
                </li>
            </ul>
            <ul class="side-menu">
                <li>
                    <a href="Controlador?URL=area_ajustes">
                        <i class='bx bxs-cog' ></i>
                        <span class="text">Ajustes</span>
                    </a>
                </li>
            </ul>
        </section>
        <section id="content">
            <!-- Barra de Navegacion -->
            <nav>
                <i class='bx bx-menu' ></i>
                <a href="#" class="nav-link"></a>
                <form action="#">
                    <div class="form-input">
                    </div>
                </form>
                <input type="checkbox" id="switch-mode" hidden>
                <label for="switch-mode" class="switch-mode"></label>
                <a href="#" class="profile">
                    <img src="img/people.png">
                </a>
            </nav>
            <!-- MAIN -->
            <main>
                <div class="head-title">
                    <div class="left">
                        <h1>Operaciones</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Operaciones</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_tipocambio'">
                            <h3 class="itemm">Tipo de Cambio</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_asientocontable'">
                            <h3 class="itemm">Asiento Contable</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_asientotesoreria'">
                            <h3 class="itemm">Asiento de Tesoreria</h3>
                        </span>
                    </li>
                </ul>
                <div class="head-title">
                    <div class="left">
                        <h1>Asiento Contable</h1>
                    </div>
                </div>
                <div class="table-data">
                    <div class="todo">
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <div class="card-body" style="display: flex;">
                            <div class="container-fluid">
                                <form id="finalizarForm">
                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label  class="col-form-label" >Tipo de Operación:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="number" class="form-control" name="txtTipoO" id="TipoOper" style="width: 60px;"> 
                                        </div>
                                        <div class="col-auto">
                                            <input type="text" id="NomTipOp" name="txtNombre" class="form-control" style="width: 300px;" readonly>
                                        </div>
                                        <div class="col-auto">
                                            <label  class="col-form-label"> Moneda</label>
                                        </div>
                                        <select id="TCid" name="txtTipoCambio" class="form-select" style="width: 100px;">
                                            <option value="1">Soles</option>
                                            <option value="2">Dólares</option>
                                        </select>
                                        <div class="col-auto">
                                            <label  class="col-form-label"> Nº de Asiento:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="number" id="NumeroAsiento" name="txtNumero" class="form-control" style="width: 95px;" readonly>
                                        </div>
                                    </div>
                                    <div class="row g-3 align-items-center">
                                        <div class="col-auto">
                                            <label  class="col-form-label">Glosa:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="text" name="txtGlosa" id="Glosa" class="form-control" style="width: 620px;">
                                        </div>
                                        <div class="col-auto">
                                            <label  class="col-form-label"> Fecha:</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="date" id="NAfecha" name="txtFecha" class="form-control">
                                            <input type="hidden" id="EstadoAsiento" name="txtEstado" value="TERMINADO">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="order">
                            <table id="tabla_detalles">
                                <thead>
                                    <tr>
                                        <th style="width: 50px;">N° Cuenta</th>
                                        <th style="width: 180px;">Nombre</th>
                                        <th style="width: 70px;">Debe (S/.)</th>
                                        <th style="width: 70px;">Haber (S/.)</th>
                                        <th style="width: 70px;">Debe ($)</th>
                                        <th style="width: 70px;">Haber ($)</th>
                                    </tr>
                                </thead>
                                <tbody id="detalle_asiento">
                                </tbody>
                            </table>
                            <div class="container-fluid" style="border-top: solid 2px;">
                                <div class="row g-3 align-items-center" style="margin:2px">
                                    <div class="col-auto" >
                                        <input type="checkbox" id="InputAjustar">                                
                                        <label  class="col-form-label"  style="width: 280px;">Ajustar</label>
                                    </div>
                                    <div class="col-auto">
                                        &nbsp; &nbsp;<label  class="col-form-label">Total</label>
                                    </div>
                                    <div class="col-auto">
                                        <input type="number" id="debeSoles" step="0.01" class="form-control" style="width: 120px;" readonly>
                                    </div>
                                    <div class="col-auto">
                                        <input type="number" id="haberSoles" step="0.01" class="form-control" style="width: 120px;" readonly>
                                    </div>
                                    <div class="col-auto">
                                        <input type="number" id="debeDolares" step="0.01" class="form-control" style="width: 120px;" readonly>
                                    </div>
                                    <div class="col-auto">
                                        <input type="number" id="haberDolares" step="0.01" class="form-control" style="width: 120px;" readonly>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="todo">
                            <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                            <form id="detalleForm">
                                <div class="card-body">
                                    <div class="container-fluid">
                                        <div class="row g-3 align-items-center">
                                            <div class="col-auto">
                                                <label  class="col-form-label" >Nº de Cta:</label>
                                            </div>
                                            <div class="col-auto" >
                                                <input type="number" id="NomCuentaC" name="txtNumCuenta" class="form-control" style="width: 100px;">
                                            </div>
                                            <div class="col-auto" >
                                                <input type="text" id="NomCContable" name="txtNombreCC" class="form-control" style="width: 420px;" readonly>
                                            </div>
                                            <div class="col-auto">
                                                <label  class="col-form-label">Importe: </label>
                                            </div>
                                            <div class="col-auto" >
                                                <input type="number" name="txtImporte" id="Importe" class="form-control" style="width: 80px;">
                                                <input type="hidden" id="TCtxt" name="txtCambioOculto" value="1">
                                            </div>
                                            <div class="col-auto">
                                                <label  class="col-form-label">Tipo:</label>
                                            </div>
                                            <div class="col-auto" >
                                                <select name="txtTipo" id="SelectTipo">
                                                    <option value="Debe">Debe</option>
                                                    <option value="Haber">Haber</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="card" id="detalle2">

                                </div>

                            </form>
                            <br>
                            <input type="checkbox" id="InputEstado">                                
                            <label  class="col-form-label"  style="width: 280px;">¿Asiento Pendiente?</label>
                            <button type="button" class="btn" id="AgregarDetalle">Agregar Detalle</button>
                            <button type="button" class="btn" id="ModificarDetalle">Modificar</button>
                            <button type="button" class="btn" id="EliminarDetalle">Eliminar</button>
                            <button type="button" class="btn" id="CancelarAsiento">Cancelar</button>
                            <button type="button" class="btn" id="FinalizarAsiento">Finalizar</button>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                </div>
            </main>
        </section>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/Asiento.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
