<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>${incidencia.id == 0 ? 'Nueva Incidencia' : 'Modificar Incidencia'} | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-7">
                <div class="card shadow border-0">
                    <div class="card-body p-4">
                        <h2 class="mb-4 text-center">${incidencia.id == 0 ? 'Reportar Incidencia' : 'Editar Incidencia'}</h2>
                        
                        <form:form action="${pageContext.request.contextPath}/incidencias/guardar" 
                                   modelAttribute="incidencia" method="POST">
                            
                            <form:hidden path="id" />

                            <div class="mb-3">
                                <label class="form-label fw-bold">Seleccionar Habitación</label>
								<form:select path="habitacion.id" class="form-select"
									required="true">
									<form:option value="0" label="-- Elegir habitación --" />
									<c:forEach var="hab" items="${listaHabitaciones}">
										<form:option value="${hab.id}"
											label="Hab. ${hab.numero} - ${hab.tipo}" />
									</c:forEach>
								</form:select>
							</div>

                            <div class="mb-3">
                                <label class="form-label fw-bold">Descripción</label>
                                <form:textarea path="descripcion" class="form-control" rows="3" required="true" />
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label fw-bold">Estado</label>
                                    <form:select path="estado" class="form-select">
                                        <form:option value="abierta">Abierta</form:option>
                                        <form:option value="en curso">En curso</form:option>
                                        <form:option value="cerrada">Cerrada</form:option>
                                    </form:select>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label fw-bold">Prioridad</label>
                                    <form:select path="prioridad" class="form-select">
                                        <form:option value="baja">Baja</form:option>
                                        <form:option value="media">Media</form:option>
                                        <form:option value="alta">Alta</form:option>
                                    </form:select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label fw-bold">Coste Reparación (€)</label>
                                    <form:input path="costeReparacion" type="number" step="0.01" class="form-control" />
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label fw-bold">Fecha Apertura</label>
                                    <form:input path="fechaApertura" type="datetime-local" class="form-control" />
                                </div>
                            </div>

                            <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-4">
                                <a href="<c:url value='/incidencias' />" class="btn btn-outline-secondary">Cancelar</a>
                                <button type="submit" class="btn btn-primary px-4">Guardar Registro</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>