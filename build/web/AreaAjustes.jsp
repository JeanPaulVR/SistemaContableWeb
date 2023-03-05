<%-- 
    Document   : Dashboard
    Created on : 29 dic. 2022, 18:10:19
    Author     : Jean Paul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="modelo.logic.PeriodoContableLogic" scope="page" id="pcL"/>
<jsp:useBean class="modelo.beans.PeriodoContable" scope="page" id="pcB"/>
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
                        <h1>Configuraciones</h1>
                    </div>
                </div>
                <div class="table-data">
                    <div class="formulinp">
                        <div class="head">
                            <h3>Ajustes Generales</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <form action="Controlador" method="post">
                            <div class="form-control">
                                <label for="text" > Digitos la contablidad:</label>
                                <input type="number" name="txtDigito" placeholder="Digitos de contabilidad">
                            </div>
                            <div class="form-control">
                                <label> RUC de la Empresa:</label>
                                <input type="number" name="txtRUC" placeholder="RUC de la Empresa">
                            </div>
                            <div class="form-control">
                                <label> Razon Social:</label>
                                <input type="text" name="txtRazonS" placeholder="Razon Social">
                            </div>
                            <div class="form-control">
                                <label> D. C. Ganancia:</label>
                                <input type="number" name="txtDiferenciaCambio" placeholder="D. C. Ganancia">
                            </div>
                            <div class="form-control">
                                <label> D. C. Perdida:</label>
                                <input type="number" name="txtDiferenciaCambio2" placeholder="D. C. Perdida">
                            </div>
                            <div class="form-control">
                                <label> Cuenta IGV:</label>
                                <input type="number" name="txtIGV" placeholder="Cuenta IGV">
                            </div>
                            <div class="form-control">
                                <label> Cuenta Caja:</label>
                                <input type="number" name="txtCaja" placeholder="Cuenta Caja">
                            </div>
                            <%
                                if(msj!=null)
                                    out.print(msj);
                            %>
                            <input type="hidden" name="URL" value="modificar_digitos">
                            <button type="submit" class="btn">Guardar</button>
                        </form>
                    </div>
                    <%
                        pcB = pcL.Datos(Usuario.getPeriodo());
                    %>
                    <div class="order">
                        <div class="head">
                            <h3>Informacion de la Cuenta:</h3>
                            <i class='bx bx-filter' ></i>
                        </div>
                        <p>Digitos de Contabilidad: <%=Usuario.getDigitos()%></p>
                        <br>
                        <p>Periodo Actual: <%=pcB.getAño()%></p>
                        <br>
                        <p>RUC: <%=Usuario.getRUC()%></p>
                        <br>
                        <p>Razon Social: <%=Usuario.getRazonSocial()%></p>
                        <br>
                        <p>Cuenta D. C. Ganancia: <%=Usuario.getDiferenciaDebe()%></p>
                        <br>
                        <p>Cuenta D. C. Perdida: <%=Usuario.getDiferenciaHaber()%></p>
                        <br>
                        <p>Cuenta IGV: <%=Usuario.getCuentaIGV()%></p>
                        <br>
                        <p>Cuenta Caja: <%=Usuario.getCuentaCaja()%></p>
                    </div>
                </div>
            </main>
        </section>


        <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
        <script src="js/lista.js" type="text/javascript"></script>
        <script src="js/panel.js"></script>
    </body>
</html>
