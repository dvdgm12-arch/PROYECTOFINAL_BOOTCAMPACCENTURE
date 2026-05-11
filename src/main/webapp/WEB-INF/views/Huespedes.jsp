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
 
    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="h3 mb-0 text-dark"><i class="bi bi-people-fill me-2"></i>Gestión de Huéspedes</h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/huespedes/nuevo' />" class="btn btn-add">
                    <i class="bi bi-person-plus-fill"></i> Nuevo Huésped
                </a>
            </c:if>
        </div>
 
        <div class="card shadow border-0">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                    <thead class="table-header">
                        <tr>
                            <th>DNI / Pasaporte</th>
                            <th>Nombre Completo</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                            <th class="text-center">Acciones</th>
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
                                    <a href="<c:url value='/huespedes/detalle/${h.id}' />" class="btn btn-sm btn-outline-info"><i class="bi bi-search"></i></a>
                                    <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                        <a href="<c:url value='/huespedes/editar/${h.id}' />" class="btn btn-sm btn-outline-warning"><i class="bi bi-pencil"></i></a>
                                        <a href="<c:url value='/huespedes/eliminar/${h.id}' />" class="btn btn-sm btn-outline-danger" onclick="return confirm('¿Eliminar registro?')"><i class="bi bi-trash"></i></a>
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
