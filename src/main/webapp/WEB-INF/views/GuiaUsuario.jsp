<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Guía de Usuario | Baratié</title>

    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body>
    <div class="container py-5">
        <div class="mb-4">
            <a href="<c:url value='/login/principal' />" class="btn btn-outline-primary shadow-sm">
                <i class="bi bi-arrow-left me-2"></i> Volver
            </a>
        </div>
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card border-0 shadow-lg p-4">
                    <h2 class="mb-4 text-primary fw-bold border-bottom pb-2">Manual de Operaciones</h2>
                    <div class="list-group list-group-flush">
                        <div class="list-group-item py-3">
                            <h5 class="fw-bold">1. Registro de Clientes</h5>
                            <p class="mb-0 text-muted">Es obligatorio registrar primero al huésped antes de iniciar una reserva.</p>
                        </div>
                        <div class="list-group-item py-3">
                            <h5 class="fw-bold">2. Gestión de Reservas</h5>
                            <p class="mb-0 text-muted">Seleccione una habitación libre y asigne al huésped. El sistema registrará la fecha y método de pago.</p>
                        </div>
                        <div class="list-group-item py-3">
                            <h5 class="fw-bold">3. Seguridad</h5>
                            <p class="mb-0 text-muted">Los supervisores solo pueden auditar los datos; la edición es exclusiva de Recepción.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>