<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Grand Resort Baratié | Bienvenid@s</title>
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    
    <style>
        body {
            font-family: 'Roboto', sans-serif;
        }
        h1 {
            font-family: 'Playfair Display', serif;
        }
        .full-screen-hero {
            background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)), 
                        url('https://images.unsplash.com/photo-1542314831-068cd1dbfeeb?auto=format&fit=crop&w=1920&q=80');
            background-size: cover;
            background-position: center;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            text-align: center;
        }
    </style>
</head>
<body>

    <header class="full-screen-hero">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <span class="text-uppercase tracking-widest mb-3 d-block" style="letter-spacing: 3px;">Experiencia de Lujo</span>
                    <h1 class="display-1 mb-4">Grand Resort Baratié</h1>
                    <p class="lead mb-5 fs-4">Un oasis de tranquilidad y elegancia en el corazón de la ciudad. Gestionado por el Equipo B.</p>
                    
                    <div class="d-grid gap-3 d-sm-flex justify-content-sm-center">
                        <a href="#" class="btn btn-outline-light btn-lg px-5 py-3">Área de Gestión</a>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <footer class="fixed-bottom py-3 text-center text-white-50">
        <div class="container">
            <small>&copy; 2026 - Proyecto Final| Equipo B</small>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>