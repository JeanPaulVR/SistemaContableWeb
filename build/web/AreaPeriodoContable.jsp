<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="verif" scope="session" class="java.lang.String"/>
<jsp:useBean id="Usuario" scope="session" class="modelo.beans.Usuario"/>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page session = "true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="css/panelcss.css">
        <title>Dashboard</title>
    </head>
    <body>
        <!-- Barra Lateral-->
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
                <li class="active">
                    <a href="Controlador?URL=area_plancontable">
                        <i class='bx bxs-shopping-bag-alt' ></i>
                        <span class="text">Mantenimiento</span>
                    </a>
                </li>
                <li>
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
                        <h1>Mantenimiento</h1>
                        <ul class="breadcrumb">
                            <li>
                                <a href="#">Mantenimiento</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                            <li>
                                <a class="active" href="#">Plan Contable</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_plancontable'">
                            <h3 class="itemm" >Plan Contable</h3>
                        </span>

                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_tipooperacion'">
                            <h3 class="itemm" >Tipo de Operación Contable</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_cuentacorriente'">
                            <h3 class="itemm" >Cuentas Auxiliares</h3>
                        </span>
                    </li>
                </ul>
                <ul class="box-info">
                    <li>
                        <i class='bx bxs-doughnut-chart' ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_destinocompra'">
                            <h3 class="itemm" >Destino de Compra</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_periodos'">
                            <h3 class="itemm" >Periodos</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-smile'  ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_clasebien'">
                            <h3 class="itemm" >Adicionales</h3>
                        </span>
                    </li>
                </ul>
                <div class="table-data">
                    <div class="todo">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Año</label>
                                <input type="text" name="txtAño" placeholder="Año">
                            </div>
                            
                            <div class="col-auto">
                                            <label  class="col-form-label"> Fecha Inicio</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="date" name="txtFecha_inicio" class="form-control">
                            </div>
                            
                            <div class="col-auto">
                                            <label  class="col-form-label"> Fecha Fin</label>
                                        </div>
                                        <div class="col-auto" >
                                            <input type="date" name="txtFecha_fin" class="form-control">
                            </div>
                            
                            <%
                            if(msj!=null)
                                out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="agregar_periodocontable">
                            <button type="submit" class="btn">Enviar</button>
                        </form>
                    </div>
                <div class="table-data">
                    <div class="order">
                        <div class="head">
                            <h3>Lista</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>AÑO</th>
                                    <th>FECHA DE INICIO</th>
                                    <th>FECHA FINAL</th>
                                    <th>ESTADO</th>
                                </tr>
                            </thead>
                            <tbody id="periodo_contable">
                            </tbody>
                        </table>
                        <button type="submit" class="btn">
                            <img src="img/editar.png" id="lanzar-modal" alt=""/>
                        </button>
                    </div>
                </div>
                <div class="contenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="ocultar-modal">X</button>
                        <form id="formModal">
                            <div class="form-control">
                                <label for="text">ID</label>
                                <input type="text" name="txtIdM" id="idM" placeholder="ID" readonly>
                            </div>
                            <div class="form-control">
                                <label for="text">Estado</label>
                                <select name="txtEstadoM" id="estadoM">
                                    <option selected></option>
                                    <option value="ABIERTO">Abierto</option>
                                    <option value="CERRADO">Cerrado</option>
                                </select>
                            </div>
                            <button class="btn" type="button" onclick="Editar()">Enviar</button>
                        </form>
                    </div>
                </div>            
            </main>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> 
        <script src="js/PeriodoContable.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
