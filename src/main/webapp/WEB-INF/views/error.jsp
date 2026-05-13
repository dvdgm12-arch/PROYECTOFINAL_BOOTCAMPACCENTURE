<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" xml:lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error - Grand Hotel Spring</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow border-0">
                    <div class="card-body text-center p-5">
                        <h1 class="text-danger mb-4">${errorTitle}</h1>
                        <p class="lead mb-4">${mensaje}</p>
                        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Volver al Inicio</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>