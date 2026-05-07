<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle Incidencia #${incidencia.id} | Baratié</title>
    
   	<link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-lg border-0">
                    <div class="card-header bg-dark text-white d-flex justify-content-between align-items-center">
                        <h4 class="mb-0">Incidencia #${incidencia.id}</h4>
                        <span class="badge ${incidencia.prioridad == 'alta' ? 'bg-danger' : 'bg-secondary'}">Prioridad ${incidencia.prioridad.toUpperCase()}</span>
                    </div>
                    <div class="card-body p-4">
                        <div class="row mb-4">
                            <div class="col-sm-6">
                                <label class="text-muted small text-uppercase fw-bold">Habitación</label>
                                <p class="h5">Habitación ${incidencia.habitacion.numero} (${incidencia.habitacion.tipo})</p>
                            </div>
                            <div class="col-sm-6 text-sm-end">
                                <label class="text-muted small text-uppercase fw-bold">Estado Actual</label>
                                <p class="h5 text-capitalize">${incidencia.estado}</p>
                            </div>
                        </div>

                        <div class="mb-4">
                            <label class="text-muted small text-uppercase fw-bold">Descripción del Problema</label>
                            <div class="p-3 bg-light rounded border">${incidencia.descripcion}</div>
                        </div>

                        <div class="row mb-4">
                            <div class="col-sm-4">
                                <label class="text-muted small text-uppercase fw-bold">Fecha Apertura</label>
                                <p><fmt:formatDate value="${incidencia.fechaApertura}" pattern="dd/MM/yyyy HH:mm" /></p>
                            </div>
                            <div class="col-sm-4">
                                <label class="text-muted small text-uppercase fw-bold">Fecha Cierre</label>
                                <p>${incidencia.fechaCierre != null ? incidencia.fechaCierre : '---'}</p>
                            </div>
                            <div class="col-sm-4">
                                <label class="text-muted small text-uppercase fw-bold">Coste Reparación</label>
                                <p class="text-success fw-bold">${incidencia.costeReparacion} €</p>
                            </div>
                        </div>

                        <div class="d-flex justify-content-between border-top pt-4">
                            <a href="<c:url value='/incidencias' />" class="btn btn-outline-secondary">Volver al listado</a>
                            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                <a href="<c:url value='/incidencias/editar/${incidencia.id}' />" class="btn btn-warning text-white">Editar Incidencia</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>