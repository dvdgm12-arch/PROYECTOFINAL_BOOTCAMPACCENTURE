<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${habitacion.id == 0 ? 'Nueva Habitación' : 'Editar Habitación'} | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    
    <style>
        body { font-family: 'Roboto', sans-serif; background-color: #f4f7f6; }
        .hotel-title { font-family: 'Playfair Display', serif; color: #2c3e50; }
        .card-form { border: none; border-radius: 15px; box-shadow: 0 10px 30px rgba(0,0,0,0.08); }
        .form-label { font-weight: 500; color: #34495e; }
    </style>
</head>
<body>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8 col-lg-6">
                
                <div class="text-center mb-4">
                    <h1 class="hotel-title">
                        <c:choose>
                            <c:when test="${habitacion.id == 0}">Registro de Habitación</c:when>
                            <c:otherwise>Modificar Habitación #${habitacion.numero}</c:otherwise>
                        </c:choose>
                    </h1>
                </div>

                <div class="card card-form p-4">
                    <div class="card-body">
                        <form:form action="${pageContext.request.contextPath}/habitaciones/guardar" 
                                   modelAttribute="habitacion" method="POST">
                            
                            <form:hidden path="id" />

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Número de Habitación</label>
                                    <form:input path="numero" type="number" class="form-control" placeholder="Ej: 101" required="true" />
                                </div>
                                
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Planta</label>
                                    <form:input path="planta" type="number" class="form-control" placeholder="1, 2, 3..." required="true" />
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Tipo de Habitación</label>
                                    <form:select path="tipo" class="form-select">
                                        <form:option value="individual">Individual</form:option>
                                        <form:option value="doble">Doble</form:option>
                                        <form:option value="suite">Suite</form:option>
                                    </form:select>
                                </div>

                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Estado Actual</label>
                                    <form:select path="estado" class="form-select">
                                        <form:option value="disponible">Disponible</form:option>
                                        <form:option value="ocupada">Ocupada</form:option>
                                        <form:option value="limpieza">En Limpieza</form:option>
                                    </form:select>
                                </div>
                            </div>

                            <div class="mb-4">
                                <label class="form-label">Precio por Noche (€)</label>
                                <div class="input-group">
                                    <span class="input-group-text">€</span>
                                    <form:input path="precio" type="number" step="0.01" class="form-control" placeholder="0.00" required="true" />
                                </div>
                            </div>

                            <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                                <a href="<c:url value='/habitaciones' />" class="btn btn-outline-secondary px-4">Cancelar</a>
                                <button type="submit" class="btn btn-primary px-5">
                                    <i class="bi bi-check-lg"></i> Guardar Cambios
                                </button>
                            </div>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>