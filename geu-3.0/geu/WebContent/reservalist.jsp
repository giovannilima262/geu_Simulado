<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gerenciador de Reservas</title>

    <link href="/geu/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/geu/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/geu//css/app.css" rel="stylesheet">
    

</head>
<body>
	<c:import url="topo.jsp"></c:import>
<div class="container">

<div class="page-header">
<h1> Lista de Reservas </h1>
</div>
<table class="table" >
<tr>
<th>Espaço</th>
<th>Data</th>
<th>Hora Inicio</th>
<th>Hora Fim</th>
<th>Titulo</th> 
<th>Solicitante</th>
</tr>

<c:forEach var="r" items="${lista}">
<tr>
 <td>${r.espaco.identificacao}</td>
 <td>${r.data}</td>
 <td>${r.inicioHorario}</td>
 <td>${r.fimHorario}</td>
 <td>${r.titulo}</td>
 <td>${r.solicitante}</td>
<tr>
</c:forEach>
</table>
</div>

<c:import url="rodape.jsp"></c:import>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="/geu/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>