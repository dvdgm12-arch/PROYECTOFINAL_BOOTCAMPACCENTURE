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
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="h3 mb-0">
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
                                <td class="align-middle fw-bold">#${res.id}</td>
                                <td class="align-middle">${res.huesped.nombre} ${res.huesped.apellidos}</td>
                                <td class="align-middle"><span class="badge bg-info text-dark">Nº ${res.habitacion.numero}</span></td>
                                <td class="align-middle"><fmt:formatDate value="${res.fechaEntrada}" pattern="dd/MM/yyyy" /></td>
                                <td class="align-middle"><fmt:formatDate value="${res.fechaSalida}" pattern="dd/MM/yyyy" /></td>
                                <td class="align-middle text-success fw-bold">${res.totalReserva}€</td>
                                <td class="text-center align-middle">
                                    <a href="<c:url value='/reservas/detalle/${res.id}' />" class="btn btn-sm btn-outline-primary">
                                        <span class="bi bi-eye"></span>
                                    </a>
                                    <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                        <a href="<c:url value='/reservas/editar/${res.id}' />" class="btn btn-sm btn-outline-warning">
                                            <span class="bi bi-pencil"></span>
                                        </a>
                                        <a href="<c:url value='/reservas/eliminar/${res.id}' />" class="btn btn-sm btn-danger" 
                                           onclick="return confirm('¿Estás seguro de que deseas cancelar esta reserva?')">
                                            <span class="bi bi-trash"></span>
                                        </a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>