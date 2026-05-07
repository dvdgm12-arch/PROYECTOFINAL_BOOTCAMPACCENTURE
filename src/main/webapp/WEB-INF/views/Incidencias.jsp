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

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="h3 mb-0 text-secondary"><i class="bi bi-tools me-2"></i>Gestión de Incidencias</h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/incidencias/nuevo' />" class="btn btn-danger">
                    <i class="bi bi-plus-circle"></i> Nueva Incidencia
                </a>
            </c:if>
        </div>

        <div class="card shadow-sm">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                    <thead class="table-thead">
                        <tr>
                            <th>ID</th>
                            <th>Habitación</th>
                            <th>Estado</th>
                            <th>Prioridad</th>
                            <th>Apertura</th>
                            <th class="text-center">Acciones</th>
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
                                    <i class="bi bi-flag-fill ${inc.prioridad == 'alta' ? 'text-danger' : (inc.prioridad == 'media' ? 'text-warning' : 'text-info')}"></i>
                                    <span class="text-capitalize">${inc.prioridad}</span>
                                </td>
                                <td class="align-middle">
                                    <fmt:formatDate value="${inc.fechaApertura}" pattern="dd/MM/yyyy HH:mm" />
                                </td>
                                <td class="text-center">
                                    <a href="<c:url value='/incidencias/detalle/${inc.id}' />" class="btn btn-sm btn-info text-white"><i class="bi bi-eye"></i></a>
                                    <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                        <a href="<c:url value='/incidencias/editar/${inc.id}' />" class="btn btn-sm btn-warning text-white"><i class="bi bi-pencil-square"></i></a>
                                        <a href="<c:url value='/incidencias/eliminar/${inc.id}' />" class="btn btn-sm btn-danger" onclick="return confirm('¿Eliminar incidencia?')"><i class="bi bi-trash"></i></a>
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