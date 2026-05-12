<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Legal | Baratié</title>

    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="card border-0 shadow-sm mx-auto" style="max-width: 700px;">
            <div class="card-body p-5">
                <h1 class="h3 mb-4 fw-bold">Política del Grand Resort Baratié</h1>
                <p>El uso de este sistema implica la aceptación de las políticas de privacidad y protección de datos (RGPD). Los datos de facturación son privados y solo accesibles bajo perfil de Recepcionista.</p>
                <div class="text-center mt-5">
                    <a href="<c:url value='/login/principal' />" class="btn btn-dark px-5">He leído y acepto</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>