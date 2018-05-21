<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM Gestion des Clients</title>
</head>
<body>

	<div id="wrapper">
		<div id="enTete"></div>
		<h2>Liste des Clients</h2>
	</div>

	<div id="contenant">
		<div id="contenu">
			<table>
				<tr>
					<td>Prenom</td>
					<td>Nom</td>
					<td>Email</td>
				</tr>
			<!-- une boucle pour obtenir la liste des clients depuis le controlleur -->
				<c:forEach var="tempClients" items="${listClientJSP}">
					<tr>
						<td>${tempClients.prenom}</td>
						<td>${tempClients.nom}</td>
						<td>${tempClients.email}</td>
					</tr>
				</c:forEach>

			</table>


		</div>
	</div>
</body>
</html>