<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Panel de Control | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    
    <style>
        .menu-card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
            border: none;
            border-bottom: 4px solid transparent;
        }
        .menu-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.1);
            border-bottom: 4px solid #e67e22;
        }
        .icon-box {
            font-size: 2.5rem;
            margin-bottom: 1rem;
            color: #2c3e50;
        }
    </style>
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <span class="navbar-brand mb-0 h1">
                <i class="bi bi-building me-2 text-warning"></i>Baratié Management
            </span>
            <div class="d-flex align-items-center text-white">
                <span class="me-3 d-none d-md-inline">
                    Bienvenido, <strong>${usuarioSesion.nombreCompleto}</strong> 
                    <span class="badge bg-secondary ms-1 text-uppercase">${usuarioSesion.rol}</span>
                </span>
                <a href="<c:url value='/login/cerrar' />" class="btn btn-outline-danger btn-sm">
                    <i class="bi bi-box-arrow-right"></i> Salir
                </a>
            </div>
        </div>
    </nav>

    <div class="container py-5">
        <div class="row mb-4">
            <div class="col">
                <h2 class="fw-bold">Panel Principal</h2>
                <p class="text-muted">Seleccione el módulo que desea gestionar</p>
            </div>
        </div>

        <div class="row g-4">
            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/habitaciones' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box"><i class="bi bi-door-closed"></i></div>
                        <h5 class="fw-bold">Habitaciones</h5>
                        <p class="small text-muted mb-0">Control de inventario y tipos</p>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/huespedes' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box"><i class="bi bi-people"></i></div>
                        <h5 class="fw-bold">Huéspedes</h5>
                        <p class="small text-muted mb-0">Registro y base de datos</p>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/incidencias' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box"><i class="bi bi-tools"></i></div>
                        <h5 class="fw-bold">Incidencias</h5>
                        <p class="small text-muted mb-0">Mantenimiento y averías</p>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/reservas' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box text-muted"><i class="bi bi-calendar-check"></i></div>
                        <h5 class="fw-bold">Reservas</h5>
                        <p class="small text-muted mb-0">Gestión de estancias</p>
                    </div>
                </a>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-12">
                <div class="alert alert-info border-0 shadow-sm">
                    <i class="bi bi-info-circle-fill me-2"></i>
                    Su último inicio de sesión fue el: <strong>${usuarioSesion.ultimoLogin}</strong>
                </div>
            </div>
        </div>
    </div>
</body>
</html>






