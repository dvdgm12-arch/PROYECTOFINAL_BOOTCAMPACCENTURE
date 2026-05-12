<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>${huesped.id == 0 ? 'Registro de Huésped' : 'Edición de Huésped'} | Baratié</title>
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
     <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-lg border-0">
                    <div class="card-body p-5">
                        <h2 class="text-center mb-4">${huesped.id == 0 ? 'Inscribir Nuevo Huésped' : 'Actualizar Huésped'}</h2>
                        
                        <form:form action="${pageContext.request.contextPath}/huespedes/guardar" modelAttribute="huesped" method="POST">
                            <form:hidden path="id" />

                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label class="form-label fw-bold">Nombre</label>
                                    <form:input path="nombre" class="form-control" placeholder="Ej: Carlos" required="true" maxlength="20" />
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label fw-bold">Apellidos</label>
                                    <form:input path="apellidos" class="form-control" placeholder="Ej: Ruiz Zafón" required="true" maxlength="20" />
                                </div>
                            </div>

                            <div class="mb-3">
                                <label class="form-label fw-bold">DNI o Pasaporte</label>
                                <form:input path="dniPasaporte" class="form-control" placeholder="12345678A" required="true" maxlength="10" />
                            </div>

                            <div class="row">
                                <div class="col-md-7 mb-3">
                                    <label class="form-label fw-bold">Correo Electrónico</label>
                                    <form:input path="email" type="email" class="form-control" placeholder="nombre@ejemplo.com" required="true" maxlength="60" />
                                </div>
                                <div class="col-md-5 mb-4">
                                    <label class="form-label fw-bold">Teléfono de contacto</label>
                                    <form:input path="telefono" type="tel" class="form-control" placeholder="600123456" required="true" maxlength="20" />
                                </div>
                            </div>

                            <div class="d-flex justify-content-end gap-2 border-top pt-4">
                                <a href="<c:url value='/huespedes' />" class="btn btn-outline-secondary px-4">Cancelar</a>
                                <button type="submit" class="btn btn-success px-5">Finalizar Registro</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>