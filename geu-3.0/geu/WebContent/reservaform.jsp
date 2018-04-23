<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
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
<h1> Inserir Espaços </h1>
</div>
	<form action="reservas" method="post">
		Espaço: 
		<select name="espaco" >
			<option value="" selected>Selecione</option>
			<c:forEach var="reserva" items="${lista}">
				<option value="${reserva.id}">${reserva.identificacao}</option>
			</c:forEach>
		</select>
		<br>
		Titulo: <input name="titulo" type="text" required><br>
		<br>
		Descrição: <input name="descricao" type="text" required><br>
		<br>
		Justificativa: <input name="justificativa" type="text" required><br>
		<br>
		Solicitante: <input name="solicitante" type="text" required><br>
		<br>
		Telefone: <input name="telefone" type="text" required><br>
		<br>
		Data (dd/MM/yyyy): <input name="data" type="text" required><br>
		<br>
		Inicio (Hora HH:MM): <input name="inicio" type="text" required><br>
		<br>
		Fim (Hora HH:MM): <input name="fim" type="text" required><br>
		<br>
		<button type="submit">Salvar</button>
	</form>
	<c:import url="rodape.jsp"></c:import>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

    <script src="/geu/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>