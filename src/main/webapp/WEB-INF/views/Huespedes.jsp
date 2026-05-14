<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registro de Huéspedes | Baratié</title>
 
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        body { background-color: #f4f7f6; }
        .table-header { background-color: #2c3e50; color: white; }
        .btn-add { background-color: #e67e22; border: none; color: white; }
        .btn-add:hover { background-color: #d35400; color: white; }
        .search-card { border: none; border-left: 4px solid #e67e22; }
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
        <div class="card shadow-sm mb-4 search-card">
            <div class="card-body">
                <form action="<c:url value='/huespedes' />" method="GET" class="row g-3 align-items-end">
                    <div class="col-md-5">
                        <label class="form-label small fw-bold text-muted text-uppercase">Nombre o Apellidos</label>
                        <div class="input-group">
                            <span class="input-group-text bg-light border-end-0 text-muted">
                                <span class="bi bi-search"></span>
                            </span>
                            <input type="text" name="nombre" class="form-control border-start-0 bg-light" 
                                   placeholder="Buscar por nombre..." value="${nombreBusqueda}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label class="form-label small fw-bold text-muted text-uppercase">DNI / Pasaporte</label>
                        <div class="input-group">
                            <span class="input-group-text bg-light border-end-0 text-muted">
                                <span class="bi bi-card-text"></span>
                            </span>
                            <input type="text" name="dni" class="form-control border-start-0 bg-light" 
                                   placeholder="Documento..." value="${dniBusqueda}">
                        </div>
                    </div>
                    <div class="col-md-3 d-flex gap-2">
                        <button type="submit" class="btn btn-dark w-100 fw-bold">
                            <span class="bi bi-funnel-fill"></span> Buscar
                        </button>
                        <a href="<c:url value='/huespedes' />" class="btn btn-outline-secondary" title="Limpiar filtros">
                            <span class="bi bi-arrow-counterclockwise"></span>
                        </a>
                    </div>
                </form>
            </div>
        </div>

        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="h3 mb-0 text-dark">
                <span class="bi bi-people-fill me-2"></span>Gestión de Huéspedes
            </h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/huespedes/nuevo' />" class="btn btn-add">
                    <span class="bi bi-person-plus-fill"></span> Nuevo Huésped
                </a>
            </c:if>
        </div>
 
        <div class="card shadow border-0">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                <caption>Listado de huéspedes del Hotel Baratié</caption>
                    <thead class="table-header">
                        <tr>
                            <th scope="col">DNI / Pasaporte</th>
                            <th scope="col">Nombre Completo</th>
                            <th scope="col">Email</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col" class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="h" items="${listaHuespedes}">
                            <tr>
                                <td class="align-middle fw-bold">${h.dniPasaporte}</td>
                                <td class="align-middle">${h.nombre} ${h.apellidos}</td>
                                <td class="align-middle">${h.email}</td>
                                <td class="align-middle">${h.telefono}</td>
                                <td class="text-center">
                                    <a href="<c:url value='/huespedes/detalle/${h.id}' />" class="btn btn-sm btn-outline-info">
                                        <span class="bi bi-search"></span>
                                    </a>
                                    <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                        <a href="<c:url value='/huespedes/editar/${h.id}' />" class="btn btn-sm btn-outline-warning">
                                            <span class="bi bi-pencil"></span>
                                        </a>
                                        <a href="<c:url value='/huespedes/eliminar/${h.id}' />" class="btn btn-sm btn-outline-danger" onclick="return confirm('¿Eliminar registro?')">
                                            <span class="bi bi-trash"></span>
                                        </a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty listaHuespedes}">
                            <tr>
                                <td colspan="5" class="text-center py-4 text-muted">
                                    <span class="bi bi-info-circle me-1"></span> No se encontraron huéspedes con los criterios de búsqueda.
                                </td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
