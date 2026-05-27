<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Estadísticas | Baratié</title>

    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="mb-4">
            <a href="<c:url value='/login/principal' />" class="btn btn-secondary btn-lg shadow-sm">
                <span class="bi bi-house-door-fill me-2"></span> Menú Principal
            </a>
        </div>

        <div class="row mb-5 text-center">
            <div class="col-12">
                <h1 class="display-5 fw-bold text-dark">Panel de Control Baratié</h1>
                <p class="text-muted">Resumen del estado actual del hotel</p>
            </div>
        </div>

        <div class="row g-4 justify-content-center">
            <div class="col-md-5">
                <div class="card border-0 shadow-sm bg-primary text-white h-100">
                    <div class="card-body text-center p-5">
                        <span class="bi bi-calendar-check display-1 mb-3"></span>
                        <h3 class="card-title">Total Reservas</h3>
                        <p class="display-2 fw-bold mb-0">${totalReservas}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="card border-0 shadow-sm bg-success text-white h-100">
                    <div class="card-body text-center p-5">
                        <span class="bi bi-door-open display-1 mb-3"></span>
                        <h3 class="card-title">Habitaciones</h3>
                        <p class="display-2 fw-bold mb-0">${totalHabitaciones}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>