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
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
