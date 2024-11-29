<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- Para hacer la página responsiva -->
    <title>Sitzungsformular</title>
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
        form {
            max-width: 400px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        div {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #6a1b9a; /* Color morado para las etiquetas */
        }
        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #6a1b9a; /* Color morado para el botón */
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #ab47bc; /* Color morado más claro al pasar el mouse */
        }
    </style>
</head>
<body>

<h1>Anmeldeformular</h1>
<form action="/Warenkorb/login" method="post">
    <div>
        <label for="username">Username</label>
        <input type="text" name="username" id="username" required>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required>
    </div>
    <div>
        <input type="submit" value="Enviar">
    </div>
</form>

</body>
</html>