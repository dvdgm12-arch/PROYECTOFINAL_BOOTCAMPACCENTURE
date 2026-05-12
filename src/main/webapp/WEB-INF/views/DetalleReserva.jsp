<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle Reserva #${reserva.id} | Baratié</title>

    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="card shadow border-0 overflow-hidden">
            <div class="card-header bg-dark text-white d-flex justify-content-between align-items-center p-3">
                <h5 class="mb-0">Resumen de Reserva #${reserva.id}</h5>
                <span class="badge bg-success">Confirmada</span>
            </div>
            <div class="card-body p-4">
                <div class="row mb-4">
                    <div class="col-sm-6">
                        <h6 class="text-muted text-uppercase small fw-bold">Huésped</h6>
                        <p class="fs-5">${reserva.huesped.nombre} ${reserva.huesped.apellidos}</p>
                        <p class="text-muted">${reserva.huesped.dniPasaporte} | ${reserva.huesped.email}</p>
                    </div>
                    <div class="col-sm-6 text-sm-end">
                        <h6 class="text-muted text-uppercase small fw-bold">Habitación</h6>
                        <p class="fs-5">Nº ${reserva.habitacion.numero} - ${reserva.habitacion.tipo}</p>
                        <p class="text-muted">${reserva.habitacion.precio}€ / noche</p>
                    </div>
                </div>
                <hr>
                <div class="row py-3">
                    <div class="col-4">
                        <label class="d-block small text-muted">ENTRADA</label>
                        <strong><fmt:formatDate value="${reserva.fechaEntrada}" pattern="dd/MM/yyyy" /></strong>
                    </div>
                    <div class="col-4 text-center">
                        <label class="d-block small text-muted">SALIDA</label>
                        <strong><fmt:formatDate value="${reserva.fechaSalida}" pattern="dd/MM/yyyy" /></strong>
                    </div>
                    <div class="col-4 text-end">
                        <label class="d-block small text-muted">PERSONAS</label>
                        <strong>${reserva.numPersonas}</strong>
                    </div>
                </div>
                <div class="bg-light p-3 rounded d-flex justify-content-between align-items-center">
                    <div>
                        <span class="text-muted">Método de pago:</span>
                        <span class="text-uppercase fw-bold ms-2">${reserva.metodoPago}</span>
                    </div>
                    <div class="text-end">
                        <span class="fs-4 text-dark fw-bold">TOTAL: ${reserva.totalReserva}€</span>
                    </div>
                </div>
            </div>
            <div class="card-footer bg-white p-3 text-end">
                <a href="<c:url value='/reservas' />" class="btn btn-dark">Volver al listado</a>
            </div>
        </div>
    </div>
</body>
</html>