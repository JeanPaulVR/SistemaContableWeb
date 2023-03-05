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
                                <a href="#">Adicionales</a>
                            </li>
                            <li><i class='bx bx-chevron-right' ></i></li>
                            <li>
                                <a class="active" href="#">Tipos de Documentos</a>
                            </li>
                        </ul>
                    </div>
                </div>

                <%-- Opciones de mantenimiento --%>

                <ul class="box-info">
                    <li>
                        <i class='bx bxs-calendar-check' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_clasebien'">
                            <h3 class="itemm" >Clases de Bienes</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-group' ></i>
                        <span class="lanzar-modal" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_tipodocumento'">
                            <h3 class="itemm" >Tipos de Documentos</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_tipoidentificacion'">
                            <h3 class="itemm" >Tipos de Identificacion</h3>
                        </span>
                    </li>
                    <li>
                        <i class='bx bxs-dollar-circle' ></i>
                        <span class="btnmant" type="submit" style="cursor:pointer" onclick="location.href = 'Controlador?URL=area_plantillacierre'">
                            <h3 class="itemm" >Plantillas de Cierre</h3>
                        </span>
                    </li>
                </ul>
                <div class="table-data">
                    <div class="formulinp">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Codigo</label>
                                <input type="text" name="txtCodigo" placeholder="Codigo">
                            </div>
                            <div class="form-control">
                                <label for="text">Nombre</label>
                                <input type="text" name="txtNombre" placeholder="Nombre">
                            </div>

                            <%
                            if(msj!=null)
                                out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="agregar_tipodocumento">
                            <button type="submit" class="btn">Enviar</button>
                        </form>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                    <div class="order">
                        <div class="head">
                            <h3>Lista Tipo Documentos</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table id="Tabla">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Codigo</th>
                                    <th>Nombre</th>
                                </tr>
                            </thead>
                            <tbody id="tipo_documento">
                            </tbody>
                        </table>
                        <button type="submit" class="btn">
                            <img src="img/editar.png" id="lanzar-modal" alt=""/>
                        </button>
                        <button type="submit" class="btn" onclick="Eliminar()">
                            <img src="img/eliminar.png" alt=""/>
                        </button>

                    </div>
                </div>
                <div class="contenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="ocultar-modal">X</button>
                        <form id="formModal">
                            <div class="form-control">
                                <label for="text">Codigo</label>
                                <input type="text" name="txtCodigoM" id="codigoM" placeholder="Codigo" readonly>
                            </div>
                            <div class="form-control">
                                <label for="text">Nombre</label>
                                <input type="text" name="txtNombreM" id="nombreM" placeholder="Nombre">
                            </div>
                            <button class="btn" type="button" onclick="Editar()">Enviar</button>
                        </form>
                    </div>  
                </div> 

            </main>
        </section>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> 
        <script src="js/TipoDocumento.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
