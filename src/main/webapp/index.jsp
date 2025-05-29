<%-- 
    Document   : index
    Created on : 27 may 2025, 15:16:17
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Tienda de Superhéroes</title>
        <style>
            * {
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }
            
            body {
                background-color: #f0f0f0;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            
            .login-container {
                width: 350px;
                background: white;
                padding: 30px;
                border-radius: 5px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }
            
            h2 {
                color: #333;
                text-align: center;
                margin-bottom: 25px;
            }
            
            .form-group {
                margin-bottom: 20px;
            }
            
            label {
                display: block;
                margin-bottom: 5px;
                color: #555;
                font-weight: bold;
            }
            
            input[type="text"],
            input[type="email"],
            input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 16px;
            }
            
            input[type="text"]:focus,
            input[type="email"]:focus,
            input[type="password"]:focus {
                border-color: #4CAF50;
                outline: none;
            }
            
            .btn-login {
                width: 100%;
                padding: 12px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
            }
            
            .btn-login:hover {
                background-color: #45a049;
            }
            
            .error-message {
                color: #d9534f;
                background-color: #f2dede;
                padding: 10px;
                border-radius: 4px;
                margin-bottom: 15px;
                border: 1px solid #ebccd1;
                display: none; /* Solo visible cuando hay error */
            }
            
            .register-link {
                text-align: center;
                margin-top: 15px;
            }
            
            .register-link a {
                color: #4CAF50;
                text-decoration: none;
            }
            
            .register-link a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h2>Iniciar Sesión</h2>
            
            <%-- Mostrar mensaje de error si existe --%>
            <% if (request.getAttribute("error") != null) { %>
                <div class="error-message" style="display: block;">
                    <%= request.getAttribute("error") %>
                </div>
            <% } %>
            
            <form action="InicializarHeroes" method="post">
                <div class="form-group">
                    <label for="nombreUsuario">Nombre de Usuario</label>
                    <input type="text" id="nombreUsuario" name="nombreUsuario" required>
                </div>
                
                <div class="form-group">
                    <label for="email">Correo Electrónico</label>
                    <input type="email" id="email" name="email" required>
                </div>
                
                <div class="form-group">
                    <label for="contrasena">Contraseña</label>
                    <input type="password" id="contrasena" name="contrasena" required>
                </div>
                
                <button type="submit" class="btn-login">Ingresar</button>
            </form>
            
        </div>
    </body>
</html>
