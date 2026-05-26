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
        
        .nav-card {
            background-color: #ffffff;
            border: 1px solid #dee2e6;
            transition: all 0.2s;
        }
        .nav-card:hover {
            background-color: #f8f9fa;
            border-color: #e67e22;
        }
    </style>
</head>
<body class="bg-light">
    <nav class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-between align-items-center">
            <span class="navbar-brand mb-0 h1">
                <span class="bi bi-building me-2 text-warning"></span>Baratié Management
            </span>
            <div class="d-flex align-items-center text-white">
                <span class="me-3 d-none d-md-inline">
                    Bienvenido, <strong>${usuarioSesion.nombreCompleto}</strong> 
                    <span class="badge bg-secondary ms-1 text-uppercase">${usuarioSesion.rol}</span>
                </span>
                <a href="<c:url value='/login/cerrar' />" class="btn btn-outline-danger btn-sm">
                    <span class="bi bi-box-arrow-right"></span> Salir
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
                        <div class="icon-box"><span class="bi bi-door-closed"></span></div>
                        <h5 class="fw-bold">Habitaciones</h5>
                        <p class="small text-muted mb-0">Control de inventario y tipos</p>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/huespedes' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box"><span class="bi bi-people"></span></div>
                        <h5 class="fw-bold">Huéspedes</h5>
                        <p class="small text-muted mb-0">Registro y base de datos</p>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/incidencias' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box"><span class="bi bi-tools"></span></div>
                        <h5 class="fw-bold">Incidencias</h5>
                        <p class="small text-muted mb-0">Mantenimiento y averías</p>
                    </div>
                </a>
            </div>

            <div class="col-md-6 col-lg-3">
                <a href="<c:url value='/reservas' />" class="text-decoration-none text-dark">
                    <div class="card h-100 text-center p-4 menu-card">
                        <div class="icon-box"><span class="bi bi-calendar-check"></span></div>
                        <h5 class="fw-bold">Reservas</h5>
                        <p class="small text-muted mb-0">Gestión de estancias</p>
                    </div>
                </a>
            </div>
        </div>

        <div class="row mt-5 mb-4">
            <div class="col">
                <h4 class="fw-bold"><span class="bi bi-gear-wide-connected me-2"></span>Herramientas y Ayuda</h4>
            </div>
        </div>

        <div class="row g-3">
            <div class="col-md-4">
                <a href="<c:url value='/dashboard/resumen' />" class="text-decoration-none text-dark">
                    <div class="card p-3 nav-card shadow-sm h-100 d-flex flex-row align-items-center">
                        <span class="bi bi-graph-up-arrow fs-3 me-3 text-primary"></span>
                        <div>
                            <h6 class="mb-0 fw-bold">Estadísticas</h6>
                            <small class="text-muted">Resumen de ocupación</small>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="<c:url value='/ayuda' />" class="text-decoration-none text-dark">
                    <div class="card p-3 nav-card shadow-sm h-100 d-flex flex-row align-items-center">
                        <span class="bi bi-journal-text fs-3 me-3 text-info"></span>
                        <div>
                            <h6 class="mb-0 fw-bold">Guía de Usuario</h6>
                            <small class="text-muted">Manual del personal</small>
                        </div>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="<c:url value='/terminos-condiciones' />" class="text-decoration-none text-dark">
                    <div class="card p-3 nav-card shadow-sm h-100 d-flex flex-row align-items-center">
                        <span class="bi bi-shield-check fs-3 me-3 text-success"></span>
                        <div>
                            <h6 class="mb-0 fw-bold">Legal</h6>
                            <small class="text-muted">Términos y condiciones</small>
                        </div>
                    </div>
                </a>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-12">
                <div class="alert alert-info border-0 shadow-sm d-flex align-items-center">
                    <span class="bi bi-info-circle-fill me-3 fs-4"></span>
                    <div>
                        Su último inicio de sesión fue el: <strong>${usuarioSesion.ultimoLogin}</strong>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>






