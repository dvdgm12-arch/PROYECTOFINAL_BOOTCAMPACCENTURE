<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detalle Habitación ${habitacion.numero} | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    
    <style>
        body { font-family: 'Roboto', sans-serif; background-color: #f4f7f6; }
        .hotel-title { font-family: 'Playfair Display', serif; color: #2c3e50; }
        .card-detalle { border: none; border-radius: 15px; box-shadow: 0 10px 30px rgba(0,0,0,0.08); }
        .info-label { font-weight: bold; color: #7f8c8d; text-transform: uppercase; font-size: 0.8rem; }
        .info-value { font-size: 1.2rem; color: #2c3e50; margin-bottom: 1.5rem; }
        .status-badge { font-size: 1rem; padding: 0.5rem 1rem; border-radius: 50px; }
    </style>
</head>
<body>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                
                <div class="text-center mb-4">
                    <h1 class="hotel-title display-5">Ficha de Habitación</h1>
                    <p class="text-muted">Gestión Interna - Grand Resort Baratié</p>
                </div>

                <div class="card card-detalle p-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-6">
                                <p class="info-label">Número</p>
                                <p class="info-value"># ${habitacion.numero}</p>
                            </div>
                            <div class="col-6 text-end">
                                <c:choose>
                                    <c:when test="${habitacion.estado == 'Disponible'}">
                                        <span class="badge bg-success status-badge">Disponible</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge bg-danger status-badge">${habitacion.estado}</span>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <hr class="my-3">

                        <div class="row">
                            <div class="col-6">
                                <p class="info-label">Tipo de Estancia</p>
                                <p class="info-value"><i class="bi bi-door-open me-2"></i>${habitacion.tipo}</p>
                            </div>
                            <div class="col-6">
                                <p class="info-label">Precio por Noche</p>
                                <p class="info-value text-primary fw-bold">${habitacion.precio} €</p>
                            </div>
                        </div>

                        <div class="mt-4 d-flex justify-content-between">
                            <a href="<c:url value='/habitaciones' />" class="btn btn-outline-secondary">
                                <i class="bi bi-arrow-left"></i> Volver al listado
                            </a>

                            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                <div>
                                    <a href="<c:url value='/habitaciones/editar/${habitacion.id}' />" class="btn btn-warning text-white me-2">
                                        <i class="bi bi-pencil"></i> Editar
                                    </a>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>

                <p class="text-center mt-4 text-muted small">
                    ID Interno de Registro: ${habitacion.id}
                </p>

            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>