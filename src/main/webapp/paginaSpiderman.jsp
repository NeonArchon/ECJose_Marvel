<%-- 
    Document   : paginaSpiderman
    Created on : 3 jun 2025, 15:09:38
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entities.Heroes" %>
<%@ page import="entities.Compras" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<head>
    <meta charset="UTF-8">
    <title>Spiderman</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            background-color: #ffffff;
            color: #1a1a1a;
            flex-direction: column;
            min-height: 100vh; /* Altura mínima de toda la ventana */
        }

        .header {
            background: linear-gradient(to bottom, #8a0a1a 0%, #d31632 30%, #6e0818 100%); /* gradiente. El to bottom es pare que sea vertical */
            /* background-color: #c8102e;  Rojo */
            color: #fff;
            padding: 40px 0;
            text-align: center;
            box-shadow: 0 4px 12px rgba(0,0,0,0.2);
        }

        .header h1 {
            margin: 0;
            font-size: 3em;
        }

        .header h3 {
            margin: 10px 0 0;
            font-weight: normal;
            color: #ffffffcc;
        }

        .content {
            flex: 1; /* Ocupa todo el espacio disponible */
            display: flex;
            justify-content: space-around;
            padding: 30px;
            background-color: #e6ecf0;
            flex-wrap: wrap;
        }

        .text-section,
        .powers-section {
            flex: 1;
            margin: 20px; /* Aumentar el margen */
            min-width: 280px;
            background-color: #fff; /* Fondo blanco */
            padding: 20px; /* Más espacio interno */
            border-radius: 10px; /* Bordes redondeados */
            box-shadow: 0 4px 8px rgba(0,0,0,0.1); /* Sombra sutil */
        }

        textarea {
            width: 90%;
            height: 150px; /* Más alto */
            resize: none;
            border: 2px solid #0057b7;
            background-color: #4bc5ef;
            padding: 15px; /* Más padding */
            font-size: 1em;
            border-radius: 8px; /* Bordes redondeados */
            margin-top: 15px; /* Espacio sobre el textarea */
        }

        .first-appearance {
            flex: 0.5;
            text-align: center;
            margin: 10px;
        }

        .first-appearance img {
            width: 200px; 
            height: 275px;
            border: 2px solid #ccc;
            box-shadow: 2px 2px 8px rgba(0,0,0,0.2);
        }
        
        .gallery {
            display: flex;
            flex-direction: column;
            align-items: center; /* Centrado horizontal */
            background: linear-gradient(to bottom, #f0f8ff 0%, #d4e4f5 100%);
            padding: 50px 20px;
            width: 100%;
        }

        .gallery-section {
            width: 100%;
            max-width: 1200px; /* Ancho máximo para mejor lectura */
            text-align: center;
            margin: 20px 0;
            
        }
        
        .gallery-images-container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            gap: 20px;
            width: 100%;
        }

        .gallery-section h3 {
            font-size: 2em; /* Título más grande */
            margin: 0 0 40px 0;
            color: #c8102e;
            position: relative;
            text-align: center;
            display: inline-block;
        }
        
        .gallery-section h3::after {
            content: '';
            position: absolute;
            bottom: -10px;
            left: 50%;
            transform: translateX(-50%);
            width: 80px;
            height: 3px;
            background: #c8102e;
        }

        .gallery-section img {
            width: 300px; 
            height: 450px;
            margin: 15px;
            border: 2px solid #aaa;
            transition: transform 0.3s ease;
        }

        .merch-item {
            width: 220px; /* Aumentar de 180px */
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 15px; /* Más padding */
            background-color: #ffffff;
            box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
            text-align: center;
            position: relative;
            transition: all 0.3s ease;
            border: 2px solid #c8102e;
        }
        
        .text-section, 
        .powers-section {
            flex: 1;
            margin: 20px;
            min-width: 300px; /* Más ancho */
            background-color: #fff;
            padding: 30px; /* Más espacio interno */
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        textarea {
            width: 95%;
            height: 180px; /* Más alto */
            resize: none;
            border: 2px solid #0057b7;
            background-color: #f9f9f9;
            padding: 20px; /* Más padding */
            font-size: 1.1em; /* Texto más grande */
            border-radius: 8px;
            margin-top: 20px;
            line-height: 1.6; /* Mejor interlineado */
        }

        .merch-item img {
            width: 100%;
            height: auto;
            max-height: 200px; /* Aumentar de 140px */
            object-fit: contain;
        }

        .gallery-section img:hover {
            transform: scale(1.1);
            transform: translateY(-5px);
            box-shadow: 0 8px 16px rgba(200,16,46,0.2);
            border-color: #0057b7;
        }
        
        

        /* Estilos para productos */
        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .merch-item {
            width: 220px;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 15px;
            background-color: #ffffff;
            box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
            text-align: center;
            position: relative;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .merch-item img {
            width: 180px; /* Ancho fijo */
            height: 180px;
            object-fit: contain;
            margin-bottom: 15px;
        }

        .merch-details h4 {
            margin: 10px 0 5px;
            font-size: 1em;
        }

        .merch-details p {
            margin: 0;
            font-weight: bold;
            color: #c8102e;
        }
        
        .merch-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 25px;
            width: 100%;
            margin-bottom: 30px;
        }

        .btn-comprar {
            padding: 15px 40px; /* Más grande */
            background: linear-gradient(to bottom, #ff2d2d 0%, #c8102e 100%); /* Gradiente rojo */
            border: none;
            color: white;
            font-size: 1.2em; /* Texto más grande */
            cursor: pointer;
            border-radius: 8px;
            transition: all 0.3s ease;
            width: auto; /* Ancho según contenido */
            margin: 30px auto; /* Centrado horizontalmente */
            display: block; /* Para que funcione el margin auto */
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
            font-weight: bold;
            text-transform: uppercase;
        }

        .btn-comprar:hover {
            background-color: #0040a0;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.2);
        }

        footer {
            margin-top: 40px;
            text-align: center;
            padding: 25px;
            background: linear-gradient(to bottom, #8a0a1a 0%, #d31632 30%, #6e0818 100%);
            color: #fff;
            box-shadow: 0 -4px 12px rgba(0,0,0,0.1);
        }

        footer a {
            color: #ffffff;
            text-decoration: none;
            margin: 0 10px;
        }

        footer a:hover {
            text-decoration: underline;
        }
        
    </style>
</head>
<body>
    
<% if (request.getAttribute("mensaje") != null) { %>
    <script>
        alert("<%= request.getAttribute("mensaje") %>");
    </script>
<% } %>

<div class="header">
    <h1>Spiderman</h1>
    <h3>Peter Parker</h3>
</div>

<div class="content">
    <div class="text-section">
        <h3>Descripción</h3>
        <textarea readonly>
Al ser mordido por una araña radioactiva y sufrir la pérdida de su tío Ben, Peter B. Parker se ha convertido en Spiderman, usando sus nuevos poderes para defender Nueva York, porque un gran poder conlleva una gran responsabilidad.
        </textarea>
    </div>

    <div class="powers-section">
        <h3>Poderes</h3>
        <textarea readonly>
Fuerza proporcional a la de una araña, trepar muros, agilidad sobrehumana, un "sentido arácnido" que le alerta del peligro, y creó una fórmula especial de telaraña que arroja con unos lanzadores en las manos.
        </textarea>
    </div>

    <div class="first-appearance">
        <h3>Primera aparición</h3>
        <img src="img/amazing_fantasy_15.jpg" alt="Primera Aparición">
        <p><em>Amazing Fantasy #15</em></p>
    </div>
</div>


<div class="gallery">
    <div class="gallery-section">
        <h3>Galería</h3>
            <div class="gallery-images-container">
                <img src="img/spiderman.png" alt="Spiderman 1">
                <img src="img/spiderman_marvel_rivals.png" alt="Spiderman 2">
                <img src="img/spiderman_mcu.png" alt="Spiderman 3">
                    </div>
    </div>

    <div class="gallery-section">
        <h3>Mercancía</h3>
        
        <form id="compraForm" action="ProcesarCompraServlet" method="post">
            
            <input type="hidden" name="heroeId" value="1">

        <div class="merch-container"></div> 
        
        <div class="merch-item">
            
                <input type="checkbox" name="productos" value="Camisa Spiderman|24.99" id="prod1">
                <img src="img/spiderman_camisa.jpg" alt="Camisa de Spiderman">
                <div class="merch-details">
                    <h4>Camisa Spiderman</h4>
                    <p>€24.99</p>
                </div>
            </div>

            <div class="merch-item">
                <input type="checkbox" name="productos" value="Figura de Acción|29.99" id="prod2">
                <img src="img/spiderman_juguete_articulado.png" alt="Figura de Acción de Spiderman">
                <div class="merch-details">
                    <h4>Figura de Acción</h4>
                    <p>€29.99</p>
                </div>
            </div>

            <div class="merch-item">
                <input type="checkbox" name="productos" value="Spiderman PS4|59.99" id="prod3">
                <img src="img/spiderman_ps4.jpg" alt="Juego Spiderman PS4">
                <div class="merch-details">
                    <h4>Spiderman PS4</h4>
                    <p>€59.99</p>
                </div>
            </div>
        
        </div>   
    
            <button class="btn-comprar" type="submit">Comprar</button>
        
    </form>
</div>

<footer>
    <p>
        <a href="https://www.marvel.com/" target="_blank">Página oficial de Marvel</a> |
        <a href="https://www.instagram.com/marvel/" target="_blank">Instagram de Marvel</a>
    </p>
</footer>

</body>
</html>