<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
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
    
    <div class="row mb-4">
		<div class="col-12">
			<div class="p-3 bg-white shadow-sm rounded d-flex align-items-center">
				<a href="<c:url value='/login/principal' />"
					class="btn btn-secondary btn-lg shadow-sm"> <i
					class="bi bi-house-door-fill me-1"></i> Menú Principal
				</a> <span class="ms-3 text-muted"></span>
			</div>
		</div>
	</div>
    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="h3"><i class="bi bi-calendar-check me-2"></i>Listado de Reservas</h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/reservas/nuevo' />" class="btn btn-success">
                    <i class="bi bi-plus-lg"></i> Nueva Reserva
                </a>
            </c:if>
        </div>

        <div class="card shadow-sm">
            <table class="table table-hover mb-0">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Huésped</th>
                        <th>Hab.</th>
                        <th>Entrada</th>
                        <th>Salida</th>
                        <th>Total</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="res" items="${listaReservas}">
                        <tr>
                            <td class="fw-bold">#${res.id}</td>
                            <td>${res.huesped.nombre} ${res.huesped.apellidos}</td>
                            <td><span class="badge bg-info text-dark">Nº ${res.habitacion.numero}</span></td>
                            <td><fmt:formatDate value="${res.fechaEntrada}" pattern="dd/MM/yyyy" /></td>
                            <td><fmt:formatDate value="${res.fechaSalida}" pattern="dd/MM/yyyy" /></td>
                            <td class="text-success fw-bold">${res.totalReserva}€</td>
                            <td class="text-center">
                                <a href="<c:url value='/reservas/detalle/${res.id}' />" class="btn btn-sm btn-outline-primary"><i class="bi bi-eye"></i></a>
                                <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                    <a href="<c:url value='/reservas/editar/${res.id}' />" class="btn btn-sm btn-outline-warning"><i class="bi bi-pencil"></i></a>
                                </c:if>
                                <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                <a href="<c:url value='/reservas/eliminar/${res.id}' />" class="btn btn-sm btn-danger" 
                                onclick="return confirm('¿Estás seguro de que deseas cancelar esta reserva?')">
                                <i class="bi bi-trash"></i>
                                </a>
                                </c:if>
                                
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>