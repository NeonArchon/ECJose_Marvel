<%-- 
    Document   : paginaSpiderman
    Created on : 3 jun 2025, 15:09:38
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        }

        .header {
            background-color: #c8102e; /* Rojo */
            color: #fff;
            padding: 30px 0;
            text-align: center;
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
            display: flex;
            justify-content: space-around;
            padding: 30px;
            background-color: #e6ecf0;
            flex-wrap: wrap;
        }

        .text-section,
        .powers-section {
            flex: 1;
            margin: 10px;
            min-width: 280px;
        }

        textarea {
            width: 100%;
            height: 120px;
            resize: none;
            border: 2px solid #0057b7; /* Azul */
            background-color: #f9f9f9;
            padding: 10px;
            font-size: 1em;
        }

        .first-appearance {
            flex: 0.5;
            text-align: center;
            margin: 10px;
        }

        .first-appearance img {
            width: 100%;
            max-width: 150px;
            border: 2px solid #ccc;
            box-shadow: 2px 2px 8px rgba(0,0,0,0.2);
        }

        .gallery {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            background-color: #f0f8ff;
            padding: 40px 20px;
        }

        .gallery-section {
            flex: 1;
            margin: 20px;
            text-align: center;
            min-width: 300px;
        }

        .gallery-section img {
            width: 80px;
            height: 120px;
            margin: 10px;
            border: 2px solid #aaa;
            transition: transform 0.3s ease;
        }

        .gallery-section img:hover {
            transform: scale(1.1);
        }

        /* Estilos para productos */
        form {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .merch-item {
            width: 180px;
            border: 1px solid #ccc;
            border-radius: 10px;
            padding: 10px;
            background-color: #ffffff;
            box-shadow: 2px 2px 10px rgba(0,0,0,0.1);
            text-align: center;
            position: relative;
        }

        .merch-item img {
            width: 100%;
            height: auto;
            max-height: 140px;
            object-fit: contain;
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

        .btn-comprar {
            margin-top: 30px;
            padding: 12px 25px;
            background-color: #0057b7; /* Azul */
            border: none;
            color: white;
            font-size: 1em;
            cursor: pointer;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }

        .btn-comprar:hover {
            background-color: #0040a0;
        }

        footer {
            margin-top: 40px;
            text-align: center;
            padding: 15px;
            background-color: #c8102e;
            color: #fff;
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
        <p><em>Comic</em></p>
    </div>
</div>


<div class="gallery-section">
    <h3>Galería</h3>
    <c:forEach var="img" items="${imagenesSpiderman}">
        <img src="${img.url}" alt="Imagen de Spiderman">
    </c:forEach>
</div>

    <div class="gallery-section">
        <h3>Mercancía</h3>
        <form id="compraForm" action="ProcesarCompra" method="post">
            <div class="merch-item">
                <input type="checkbox" name="productos" value="1" id="prod1">
                <img src="src/resources/spiderman_camisa.jpg" alt="Camisa de Spiderman">
                <div class="merch-details">
                    <h4>Camisa Spiderman</h4>
                    <p>€24.99</p>
                </div>
            </div>

            <div class="merch-item">
                <input type="checkbox" name="productos" value="2" id="prod2">
                <img src="src/resources/spiderman_juguete_articulado.png" alt="Figura de Acción de Spiderman">
                <div class="merch-details">
                    <h4>Figura de Acción</h4>
                    <p>$29.99</p>
                </div>
            </div>

            <div class="merch-item">
                <input type="checkbox" name="productos" value="3" id="prod3">
                <img src="src/resources/spiderman_ps4.jpg" alt="Juego Spiderman PS4">
                <div class="merch-details">
                    <h4>Spiderman PS4</h4>
                    <p>$59.99</p>
                </div>
            </div>

            <button type="submit" class="btn-comprar">Comprar Productos</button>
        </form>
    </div>
</div>

<footer>
    <p>
        <a href="https://www.marvel.com/" target="_blank">Página oficial de Marvel</a> |
        <a href="https://www.instagram.com/marvel/" target="_blank">Instagram de Marvel</a>
    </p>
</footer>

</body>
</html>