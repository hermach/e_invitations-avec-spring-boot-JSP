<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Collapsible sidebar using Bootstrap 4</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css'>
	<link rel="stylesheet" href="css/stylemail.css">
</head>
<body>
<!-- merci pour votre réponse -->

<div class="container">
	<div class="card">
		<p class="back">Back</p>
		<h3 class="headline">Merci d'avoir accepté l'invitation</h3> 
		<p class="welcometext">Nous sommes heureux de vous rencontrer, Bienvenue! <span>Bonne journée!<span></p>
			<p class="grats"></p>
			<p class="download" onClick="hiddenElement">Download your challenge as .txt</p>
		
	</div>
</div>


</body>
</html>