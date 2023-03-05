<%-- 
    Document   : index
    Created on : 27 dic 2022, 13:23:05
    Author     : aleja
--%>
<jsp:useBean id="msj" scope="request" class="java.lang.String"/>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/logincss.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
 
        <title>Login</title>
    </head>
    <body>
        <main>
            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>Inicia sesión para entrar en la página</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Regístrate para que puedas iniciar sesión</p>
                        <button id="btn__registrarse">Regístrarse</button>
                    </div>
                </div>

                <!--Formulario de Login y registro-->
                <div class="contenedor__login-register">
                    <!--Login-->
                    <form action="Controlador" class="formulario__login" method="post">
                        <h2>Iniciar Sesión</h2>
                        <input type="text" name="txtUsuario" placeholder="Usuario">
                        <input type="password" name="txtContraseña" placeholder="Contraseña">
                        <%
                            if(msj!=null)
                                out.print(msj);
                        %>
                        <input type="hidden" name="URL" value="ingresar">
                        <button value="Login"> Entrar</button>
                    </form>

                    <!--Register-->
                    <form action="Controlador" class="formulario__register" method="post">
                        <h2>Regístrarse</h2>
                        <input type="text" name="txtNombres" placeholder="Nombres">
                        <input type="text" name="txtApellidos" placeholder="Apellidos">
                        <input type="text" name="txtDni" placeholder="DNI">
                        <input type="text" name="txtUsuario" placeholder="Usuario">
                        <input type="password" name="txtContraseña" placeholder="Contraseña">
                        <%
                            if(msj!=null)
                                out.print(msj);
                        %>
                        <input type="hidden" name="URL" value="registrar">
                        <button value="Registrar">Regístrarse</button>
                    </form>
                </div>
            </div>
        </main>

        <script src="js/script.js"></script>
    </body>
</html>