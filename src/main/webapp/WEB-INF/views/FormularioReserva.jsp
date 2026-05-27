<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>${reserva.id == null ? 'Nueva Reserva' : 'Editar Reserva'} | Baratié</title>

    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="card shadow mx-auto" style="max-width: 700px;">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0">${reserva.id == null ? 'Crear Nueva Reserva' : 'Modificar Reserva'}</h4>
            </div>
            <div class="card-body">
                <form:form action="${pageContext.request.contextPath}/reservas/guardar" method="post" modelAttribute="reserva">
                    
                    <input type="hidden" name="id" value="${reserva.id}" />
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Huésped</label>
                            <form:select path="huesped.id" class="form-select">
                                <form:options items="${listaHuespedes}" itemValue="id" itemLabel="nombre" />
                            </form:select>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Habitación</label>
                            <form:select path="habitacion.id" class="form-select">
                                <c:forEach var="hab" items="${listaHabitaciones}">
                                    <form:option value="${hab.id}">Hab. ${hab.numero} (${hab.tipo})</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Fecha Entrada</label>
                            <form:input type="date" path="fechaEntrada" class="form-control" required="required" />
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Fecha Salida</label>
                            <form:input type="date" path="fechaSalida" class="form-control" required="required" />
                        </div>
                    </div>

                    <div class="row mb-3">
                        <div class="col-md-4">
                            <label class="form-label">Nº Personas</label>
                            <form:input type="number" path="numPersonas" class="form-control" min="1" />
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Método Pago</label>
                            <form:select path="metodoPago" class="form-select">
                                <option value="tarjeta">Tarjeta</option>
                                <option value="efectivo">Efectivo</option>
                                <option value="transferencia">Transferencia</option>
                            </form:select>
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Total (€)</label>
                            <form:input type="number" step="0.01" path="totalReserva" class="form-control" />
                        </div>
                    </div>

                    <div class="d-flex justify-content-end gap-2">
                        <a href="<c:url value='/reservas' />" class="btn btn-secondary">Cancelar</a>
                        <button type="submit" class="btn btn-primary">Guardar Reserva</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>