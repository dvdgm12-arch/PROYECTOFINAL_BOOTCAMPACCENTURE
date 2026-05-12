<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle Habitación ${habitacion.numero} | Baratié</title>
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow border-0" style="border-radius: 1rem;">
                    <div class="card-body p-4">
                        <div class="d-flex justify-content-between align-items-center mb-4">
                            <h3 class="mb-0">Habitación #${habitacion.numero}</h3>
                            <span class="badge ${habitacion.estado == 'disponible' ? 'bg-success' : 'bg-danger'} p-2">
                                ${habitacion.estado.toUpperCase()}
                            </span>
                        </div>
                        
                        <div class="row text-center bg-light rounded py-3 mb-4">
                            <div class="col-4">
                                <small class="text-muted d-block text-uppercase">Planta</small>
                                <strong>${habitacion.planta}ª</strong>
                            </div>
                            <div class="col-4">
                                <small class="text-muted d-block text-uppercase">Tipo</small>
                                <strong class="text-capitalize">${habitacion.tipo}</strong>
                            </div>
                            <div class="col-4">
                                <small class="text-muted d-block text-uppercase">Precio</small>
                                <strong class="text-primary">${habitacion.precio} €</strong>
                            </div>
                        </div>

                        <div class="d-flex justify-content-between">
                            <a href="<c:url value='/habitaciones' />" class="btn btn-outline-secondary">Volver</a>
                            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                <a href="<c:url value='/habitaciones/editar/${habitacion.id}' />" class="btn btn-warning text-white">Editar Datos</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>