<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Panel de Incidencias | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        body { background-color: #f8f9fa; }
        .table-thead { background-color: #c0392b; color: white; }
    </style>
</head>
<body>
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
            <h2 class="h3 mb-0 text-secondary">
                <span class="bi bi-tools me-2"></span>Gestión de Incidencias
            </h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/incidencias/nuevo' />" class="btn btn-danger">
                    <span class="bi bi-plus-circle"></span> Nueva Incidencia
                </a>
            </c:if>
        </div>

        <div class="card shadow-sm">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                <caption>Listado de incidencias del Hotel Baratié</caption>
                    <thead class="table-thead">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Habitación</th>
                            <th scope="col">Estado</th>
                            <th scope="col">Prioridad</th>
                            <th scope="col">Apertura</th>
                            <th scope="col" class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="inc" items="${listaIncidencias}">
                            <tr>
                                <td class="align-middle fw-bold">#${inc.id}</td>
                                <td class="align-middle text-primary fw-bold">Hab. ${inc.habitacion.numero}</td>
                                <td class="align-middle">
                                    <span class="badge ${inc.estado == 'abierta' ? 'bg-danger' : (inc.estado == 'en curso' ? 'bg-warning text-dark' : 'bg-success')}">
                                        ${inc.estado.toUpperCase()}
                                    </span>
                                </td>
                                <td class="align-middle">
                                    <span class="bi bi-flag-fill ${inc.prioridad == 'alta' ? 'text-danger' : (inc.prioridad == 'media' ? 'text-warning' : 'text-info')}"></span>
                                    <span class="text-capitalize">${inc.prioridad}</span>
                                </td>
                                <td class="align-middle">
                                    <fmt:formatDate value="${inc.fechaApertura}" pattern="dd/MM/yyyy HH:mm" />
                                </td>
                                <td class="text-center">
                                    <a href="<c:url value='/incidencias/detalle/${inc.id}' />" class="btn btn-sm btn-info text-white">
                                        <span class="bi bi-eye"></span>
                                    </a>
                                    <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                        <a href="<c:url value='/incidencias/editar/${inc.id}' />" class="btn btn-sm btn-warning text-white">
                                            <span class="bi bi-pencil-square"></span>
                                        </a>
                                        <a href="<c:url value='/incidencias/eliminar/${inc.id}' />" class="btn btn-sm btn-danger" onclick="return confirm('¿Eliminar incidencia?')">
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