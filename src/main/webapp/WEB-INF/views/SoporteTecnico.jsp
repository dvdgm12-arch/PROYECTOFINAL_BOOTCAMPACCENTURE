<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Contacto y Soporte | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    
    <style>
        .support-card {
            background-color: #ffffff;
            border: 1px solid #dee2e6;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .support-card:hover {
            transform: translateY(-3px);
            box-shadow: 0 10px 20px rgba(0,0,0,0.05);
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
        <div class="container d-flex justify-content-between align-items-center">
            <div class="navbar-brand mb-0 h1">
                <span class="bi bi-building me-2 text-warning"></span>Baratié Management
            </div>
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
        <div class="row mb-4 align-items-center">
            <div class="col-md-8">
                <h2 class="fw-bold"><span class="bi bi-headset me-2 text-danger"></span>Soporte Técnico y Contacto</h2>
                <p class="text-muted">¿Tienes alguna incidencia con la aplicación? Estamos aquí para ayudarte.</p>
            </div>
            <div class="col-md-4 text-md-end">
                <a href="<c:url value='/login/principal' />" class="btn btn-secondary shadow-sm">
                    <span class="bi bi-arrow-left-short fs-5 align-middle"></span> Volver al Panel
                </a>
            </div>
        </div>

        <div class="row g-4">
            <div class="col-md-6">
                <div class="card p-4 h-100 support-card shadow-sm">
                    <div class="icon-box text-danger">
                        <span class="bi bi-telephone-inbound-fill"></span>
                    </div>
                    <h4 class="fw-bold mb-3">Atención Inmediata</h4>
                    <p class="text-muted">Para problemas críticos que impidan el registro de huéspedes o la asignación de habitaciones:</p>
                    <ul class="list-unstyled mt-3 fs-5">
                        <li class="mb-2"><span class="bi bi-telephone text-secondary me-2"></span> Extensión Interna: <strong>999</strong></li>
                        <li class="mb-2"><span class="bi bi-envelope text-secondary me-2"></span> soporte@baratie-resort.com</li>
                        <li><span class="bi bi-clock text-secondary me-2"></span> Horario: 24/7 (Soporte Hotelero)</li>
                    </ul>
                </div>
            </div>

            <div class="col-md-6">
                <div class="card p-4 h-100 support-card shadow-sm">
                    <div class="icon-box text-warning">
                        <span class="bi bi-exclamation-triangle-fill"></span>
                    </div>
                    <h4 class="fw-bold mb-3">¿Problemas con los datos?</h4>
                    <p class="text-muted">Antes de contactar con el administrador, asegúrate de verificar las siguientes directrices:</p>
                    <ul class="list-unstyled mt-3">
                        <li class="mb-2"><span class="bi bi-check2-circle text-success me-2"></span> Comprueba que la habitación no tenga incidencias abiertas antes de asignarla a una reserva.</li>
                        <li class="mb-2"><span class="bi bi-check2-circle text-success me-2"></span> Los formatos de fechas deben seguir el estándar del hotel.</li>
                        <li><span class="bi bi-check2-circle text-success me-2"></span> Recuerda cerrar la sesión si vas a ausentarte de tu puesto de trabajo.</li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-12">
                <div class="alert alert-info border-0 shadow-sm d-flex align-items-center">
                    <span class="bi bi-info-circle-fill me-3 fs-4"></span>
                    <div>
                        Sesión activa como: <strong class="text-uppercase">${usuarioSesion.rol}</strong> | ID de Usuario: <strong>${usuarioSesion.id}</strong>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>