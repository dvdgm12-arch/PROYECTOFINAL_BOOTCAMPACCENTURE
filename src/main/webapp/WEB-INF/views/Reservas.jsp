<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Reservas | Baratié</title>

    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        .search-card { border-left: 5px solid #198754; background-color: #ffffff; }
        .table-dark { background-color: #2c3e50 !important; }
    </style>
</head>
<body class="bg-light">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
        <div class="container">
            <a class="navbar-brand" href="<c:url value='/' />">Grand Resort Baratié</a>
        </div>
    </nav>
    
    <div class="container mb-4">
        <div class="row">
            <div class="col-12">
                <div class="p-3 bg-white shadow-sm rounded d-flex align-items-center">
                    <a href="<c:url value='/login/principal' />" class="btn btn-secondary btn-lg shadow-sm"> 
                        <span class="bi bi-house-door-fill me-1"></span> Menú Principal
                    </a> 
                    <span class="ms-3 text-muted"></span>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="card shadow-sm mb-4 search-card border-0">
            <div class="card-body">
                <form action="<c:url value='/reservas' />" method="GET" class="row g-3 align-items-end">
                    <div class="col-md-5">
                        <label class="form-label small fw-bold text-secondary">DNI / PASAPORTE HUÉSPED</label>
                        <div class="input-group">
                            <span class="input-group-text bg-light"><span class="bi bi-person-vcard"></span></span>
                            <input type="text" name="dniBusqueda" class="form-control" 
                                   placeholder="Filtrar por documento..." value="${dniFiltro}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label small fw-bold text-secondary">Nº HABITACIÓN</label>
                        <div class="input-group">
                            <span class="input-group-text bg-light"><span class="bi bi-door-open"></span></span>
                            <input type="number" name="habBusqueda" class="form-control" 
                                   placeholder="Ej: 101" value="${habFiltro}">
                        </div>
                    </div>
                    <div class="col-md-3 d-flex gap-2">
                        <button type="submit" class="btn btn-success w-100">
                            <span class="bi bi-search"></span> Filtrar
                        </button>
                        <a href="<c:url value='/reservas' />" class="btn btn-outline-secondary" title="Limpiar">
                            <span class="bi bi-arrow-clockwise"></span>
                        </a>
                    </div>
                </form>
            </div>
        </div>

        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="h3 mb-0 text-dark">
                <span class="bi bi-calendar-check me-2"></span>Listado de Reservas
            </h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/reservas/nuevo' />" class="btn btn-success">
                    <span class="bi bi-plus-lg"></span> Nueva Reserva
                </a>
            </c:if>
        </div>

        <div class="card shadow-sm border-0">
            <div class="card-body p-0">
                <div class="table-responsive">
                    <table class="table table-hover mb-0">
                    <caption>Listado de reservas del Hotel Baratié</caption>
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Huésped</th>
                                <th scope="col">Hab.</th>
                                <th scope="col">Entrada</th>
                                <th scope="col">Salida</th>
                                <th scope="col">Total</th>
                                <th scope="col" class="text-center">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="res" items="${listaReservas}">
                                <tr>
                                    <td class="align-middle fw-bold text-muted">#${res.id}</td>
                                    <td class="align-middle">
                                        <div class="fw-bold text-dark">${res.huesped.nombre} ${res.huesped.apellidos}</div>
                                        <small class="text-muted">${res.huesped.dniPasaporte}</small>
                                    </td>
                                    <td class="align-middle">
                                        <span class="badge bg-info text-dark">Nº ${res.habitacion.numero}</span>
                                    </td>
                                    <td class="align-middle">
                                        <fmt:formatDate value="${res.fechaEntrada}" pattern="dd/MM/yyyy" />
                                    </td>
                                    <td class="align-middle">
                                        <fmt:formatDate value="${res.fechaSalida}" pattern="dd/MM/yyyy" />
                                    </td>
                                    <td class="align-middle text-success fw-bold">
                                        <fmt:formatNumber value="${res.totalReserva}" type="currency" currencySymbol="€" />
                                    </td>
                                    <td class="text-center align-middle">
                                        <div class="btn-group" role="group">
                                            <a href="<c:url value='/reservas/detalle/${res.id}' />" class="btn btn-sm btn-outline-primary" title="Ver detalle">
                                                <span class="bi bi-eye"></span>
                                            </a>
                                            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                                <a href="<c:url value='/reservas/editar/${res.id}' />" class="btn btn-sm btn-outline-warning" title="Editar">
                                                    <span class="bi bi-pencil"></span>
                                                </a>
                                                <a href="<c:url value='/reservas/eliminar/${res.id}' />" class="btn btn-sm btn-danger text-white" 
                                                   onclick="return confirm('¿Estás seguro de que deseas cancelar esta reserva?')">
                                                    <span class="bi bi-trash"></span>
                                                </a>
                                            </c:if>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:if test="${empty listaReservas}">
                                <tr>
                                    <td colspan="7" class="text-center py-5 text-muted">
                                        <span class="bi bi-info-circle fs-4 d-block mb-2"></span>
                                        No se han encontrado reservas que coincidan con la búsqueda.
                                    </td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>