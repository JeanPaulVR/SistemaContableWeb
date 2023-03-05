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
        
                <div class="table-data" id="CampoBloqueado1"> 
                    <div class="formulinp">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">Cuenta de Destino</label>
                                <input type="text" name="txtCuenta_destinoM" placeholder="Cuenta de Destino">
                            </div>
                            <div class="form-control">
                                <label for="text">Glosa</label>
                                <input type="text" name="txtGlosaM" placeholder="Glosa">
                            </div>

                            <%
                            if(msj!=null)
                                out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="agregar_plantillacierre">
                            <button type="submit" class="btn">Enviar</button>
                        </form>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                    <div class="order">
                        <div class="head">
                            <h3>Listado</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>Cuenta Contable</th>
                                    <th>Nombre</th>
                                    <th>Glosa</th>
                                </tr>
                            </thead>
                            <tbody id="plantilla_asiento">
                            </tbody>
                        </table>
                        <button type="submit" class="btn">
                            <img src="img/editar.png" id="lanzar-modal" alt=""/>
                        </button>
                        <button type="submit" class="btn" onclick="Eliminar()">
                            <img src="img/eliminar.png" alt=""/>
                        </button>
                        <button type="submit" class="btn" id="MostrarDetallePlantilla">
                            <img src="" alt=""/>
                        </button>
                        
                    </div>
                </div>
                            
                <div class="table-data" id="AreaDetallePlantilla" style="opacity: 0; position: fixed;"> 
                    <div class="formulinp">
                        <div class="head">
                            <h3>Nuevo</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text">ID Plantilla</label>
                                <input type="text" name="txtId_detalle_plantillaM" id="txtId_detalle_plantillaM" placeholder="ID Plantilla" readonly>
                            </div>
                            <div class="form-control">
                                <label for="text">Cuenta Detalle</label>
                                <input type="text" name="txtCuenta_detalle_plantillaM" placeholder="Cuenta Detalle">
                            </div>

                            <%
                            if(msj!=null)
                                out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="agregar_detalleplantilla">
                            <button type="submit" class="btn">Enviar</button>
                        </form>
                        <!-- CAMBIOS ALEJANDRO 30/12/2022 4:52AM -->
                    </div>
                    <div class="order">
                        <div class="head">
                            <h3>Listado</h3>
                            <i class='bx bx-search' ></i>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Cuenta Contable</th>
                                    <th>Nombre</th>
                                </tr>
                            </thead>
                            <tbody id="detalle_plantilla">
                            </tbody>
                        </table>
                        <button type="submit" class="btn" onclick="EliminarDetalle()">
                            <img src="img/eliminar.png" alt=""/>
                        </button>
                    </div>
                </div>    
                            
                <div class="contenedor-modal">
                    <div class="modal">
                        <button class="btn" type="submit" id="ocultar-modal">X</button>
                        <form id="formModal">
                            <div class="form-control">
                                <label for="text">ID</label>
                                <input type="text" name="txtNumeroM" id="txtNumeroM" placeholder="ID" readonly>
                            </div>
                            <div class="form-control">
                                <label for="text">Cuenta Contable</label>
                                <input type="text" name="txtCuenta_destinoM" id="txtCuenta_destinoM" placeholder="Cuenta Destino">
                            </div>
                            <div class="form-control">
                                <label for="text">Glosa</label>
                                <input type="text" name="txtGlosaM" id="txtGlosaM" placeholder="Tipo de Cambio">
                            </div>
                            <button class="btn" type="button" onclick="Editar()">Enviar</button>
                        </form>
                    </div>
                </div>           
                            
            </main>
        </section>
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> 
        <script src="js/PlantillaCierre.js" type="text/javascript"></script>
        <script src="js/panel.js" type="text/javascript"></script>
    </body>
</html>
