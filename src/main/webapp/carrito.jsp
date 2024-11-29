<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="models.*" %>

<html>
<head>
  <title>Warenkorb</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f3e5f5; /* Color de fondo suave */
      margin: 0;
      padding: 20px;
    }
    h1 {
      text-align: center;
      color: #6a1b9a; /* Color morado para el título */
    }
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #5c0a73; /* Color de fondo morado para encabezados */
      color: white; /* Color del texto de encabezados */
    }
    tr:nth-child(even) {
      background-color: #e1bee7; /* Color de fondo alternativo para filas */
    }
    a {
      color: #6a1b9a; /* Color morado para enlaces */
      text-decoration: none;
    }
    a:hover {
      text-decoration: underline; /* Subrayado al pasar el mouse */
      color: #ab47bc; /* Color morado más claro al hacer hover */
    }
  </style>
</head>
<body>
<h1>Warenkorb</h1>

<c:set var="carrito" value="${sessionScope.carro}" />

<c:choose>
  <c:when test="${empty carro || empty carrito.items}">
    <p>Leider befinden sich keine Produkte im Warenkorb!.</p>
  </c:when>
  <c:otherwise>
    <table>
      <tr>
        <th>ID PRODUCTO</th>
        <th>NOMBRE</th>
        <th>PRECIO</th>
        <th>CANTIDAD</th>
        <th>TOTAL</th>
      </tr>
      <c:forEach var="item" items="${carrito.items}">
        <tr>
          <td>${item.productos.idProducto}</td>
          <td>${item.productos.nombre}</td>
          <td>${item.productos.precio}</td>
          <td>${item.cantidad}</td>
          <td>${item.sbtotal}</td>
        </tr>
      </c:forEach>
      <tr>
        <td colspan="4" style="text-align: right">Total</td>
        <td>${carrito.total}</td>
      </tr>
    </table>
  </c:otherwise>
</c:choose>

<p><a href="${pageContext.request.contextPath}/productos">seguir comprando</a></p>
<p><a href="${pageContext.request.contextPath}/index.html">Ir al inicio</a></p>

</body>
</html>