<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Acceso Personal | Baratié</title>
    
    <link rel="shortcut icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    <link rel="icon" type="image/png" href="<c:url value='/resources/images/favicon.png' />">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    
    <style>
        body {
            background: linear-gradient(135deg, #2c3e50 0%, #000000 100%);
            height: 100vh;
            display: flex;
            align-items: center;
        }
        .login-card {
            border: none;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.5);
        }
        .btn-login {
            background-color: #e67e22;
            border: none;
            color: white;
        }
        .btn-login:hover {
            background-color: #d35400;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5 col-lg-4">
                <div class="card login-card p-4">
                    <div class="text-center mb-4">
                        <span class="bi bi-door-open-fill text-warning" style="font-size: 3rem;"><span>
                        <h2 class="h4 mt-2 fw-bold">Grand Resort Baratié</h2>
                        <p class="text-muted small">Gestión Interna</p>
                    </div>

                    <c:if test="${not empty error}">
                        <div class="alert alert-danger py-2 small text-center" role="alert">
                            <span class="bi bi-exclamation-triangle-fill"><span> ${error}
                        </div>
                    </c:if>

                    <form:form action="${pageContext.request.contextPath}/login/autenticar" method="POST">
                        <div class="mb-3">
                            <label class="form-label small fw-bold text-uppercase">Usuario</label>
                            <div class="input-group">
                                <span class="input-group-text bg-light border-end-0"><span class="bi bi-person"><span></span>
                                <input name="username" type="text" class="form-control border-start-0 bg-light" required />
                            </div>
                        </div>
                        <div class="mb-4">
                            <label class="form-label small fw-bold text-uppercase">Contraseña</label>
                            <div class="input-group">
                                <span class="input-group-text bg-light border-end-0"><span class="bi bi-lock"><span></span>
                                <input name="password" type="password" class="form-control border-start-0 bg-light" required />
                            </div>
                        </div>
                        <div class="d-grid">
                            <button type="submit" class="btn btn-login btn-lg shadow-sm">Entrar al Panel</button>
                        </div>
                    </form:form>
                    
                    <div class="text-center mt-4">
                        <a href="<c:url value='/' />" class="text-decoration-none small text-muted">
                            <span class="bi bi-arrow-left"><span> Volver a la web pública
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>