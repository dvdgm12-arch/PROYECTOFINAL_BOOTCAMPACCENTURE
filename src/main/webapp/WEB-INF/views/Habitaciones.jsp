<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Habitaciones | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@700&family=Roboto:wght@300;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    
    <style>
        body { font-family: 'Roboto', sans-serif; background-color: #f8f9fa; }
        .navbar-brand { font-family: 'Playfair Display', serif; font-size: 1.5rem; }
        .table-thead { background-color: #2c3e50; color: white; }
    </style>
</head>
<body>

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
            <h2 class="h3 mb-0 text-secondary">Listado de Habitaciones</h2>
            <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                <a href="<c:url value='/habitaciones/nuevo' />" class="btn btn-primary">
                    <i class="bi bi-plus-circle"></i> Nueva Habitación
                </a>
            </c:if>
        </div>

        <div class="card shadow-sm">
            <div class="card-body p-0">
                <table class="table table-hover mb-0">
                    <thead class="table-thead">
                        <tr>
                            <th>Nº Hab.</th>
                            <th>Planta</th>
                            <th>Tipo</th>
                            <th>Precio/Noche</th>
                            <th>Estado</th>
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="hab" items="${listaHabitaciones}">
                            <tr>
                                <td class="align-middle fw-bold">${hab.numero}</td>
                                <td class="align-middle text-muted">${hab.planta}ª</td>
                                <td class="align-middle text-capitalize">${hab.tipo}</td>
                                <td class="align-middle">${hab.precio}€</td>
                                <td class="align-middle">
                                    <c:choose>
                                        <c:when test="${hab.estado == 'disponible'}">
                                            <span class="badge bg-success">Disponible</span>
                                        </c:when>
                                        <c:when test="${hab.estado == 'limpieza'}">
                                            <span class="badge bg-warning text-dark">Limpieza</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-danger">Ocupada</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="text-center">
                                    <a href="<c:url value='/habitaciones/detalle/${hab.id}' />" class="btn btn-sm btn-info text-white"><i class="bi bi-eye"></i></a>
                                    <c:if test="${usuarioSesion.rol == 'recepcionista'}">
                                        <a href="<c:url value='/habitaciones/editar/${hab.id}' />" class="btn btn-sm btn-warning text-white"><i class="bi bi-pencil-square"></i></a>
                                        <a href="<c:url value='/habitaciones/eliminar/${hab.id}' />" class="btn btn-sm btn-danger" onclick="return confirm('¿Eliminar habitación?')"><i class="bi bi-trash"></i></a>
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