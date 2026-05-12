<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ficha Huésped | Baratié</title>
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
     <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
     
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow border-0">
                    <div class="card-header bg-dark text-white text-center py-3">
                        <h4 class="mb-0">Expediente del Cliente</h4>
                    </div>
                    <div class="card-body p-4">
                        <div class="text-center mb-4">
                            <div class="display-4 text-secondary"><i class="bi bi-person-badge"></i></div>
                            <h3 class="mt-2">${huesped.nombre} ${huesped.apellidos}</h3>
                            <span class="badge bg-info text-dark">ID Huésped: #${huesped.id}</span>
                        </div>
                        <hr>
                        <div class="row mb-3">
                            <div class="col-5 fw-bold text-muted">DNI / Pasaporte:</div>
                            <div class="col-7">${huesped.dniPasaporte}</div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-5 fw-bold text-muted">Email:</div>
                            <div class="col-7">${huesped.email}</div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-5 fw-bold text-muted">Teléfono:</div>
                            <div class="col-7">${huesped.telefono}</div>
                        </div>
                       
                        <div class="d-flex justify-content-between mt-5">
                            <a href="<c:url value='/huespedes' />" class="btn btn-secondary">Volver al listado</a>
                            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                <a href="<c:url value='/huespedes/editar/${huesped.id}' />" class="btn btn-warning text-white">Editar Huésped</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
