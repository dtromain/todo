<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../css/commun.css">
	
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
		        <a  href="../index.jsp" class="navbar-brand active">
		        <span class="glyphicon glyphicon-film"></span> 
		        <span class="glyphicon glyphicon-film"></span> 
		        </a>
		          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		    </div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li ><a href="../index.jsp">Accueil</a></li>
					<li><a href="lister">Liste des films</a></li>
					<li><a href="ajouter">Ajouter un film</a></li>
					<li><a href="listerStyle">Styles</a></li>
					<li><a href="../geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>	
	
<div class="container">	
	<h1 class="bleu">Votre film</h1>
	<br><br>
		<div>
	<form:form cssClass="form-horizontal" modelAttribute="film">
				<div class="form-group">			
					<form:label path="titre" cssClass="col-xs-2 control-label">Titre :</form:label>
					<div class="col-xs-10">
						<form:input path="titre" readonly="true"   cssClass="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<form:label path="annee" cssClass="col-xs-2 control-label">Année :</form:label>
					<div class="col-xs-10">
						<form:input path="annee" readonly="true"    cssClass="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<form:label path="style.id" cssClass="col-xs-2 control-label">Style :</form:label>
					<div class="col-xs-10">
						<form:input path="style.libelle" readonly="true"    cssClass="form-control" /> 
					</div>
				</div>
				<div class="form-group">			
					<form:label path="real.prenom" cssClass="col-xs-2 control-label">Réalisateur :</form:label>
					<div class="col-xs-5">
						<form:input path="real.prenom"  readonly="true"   cssClass="form-control" /> 
					</div>
					<div class="col-xs-5">
						<form:input path="real.nom"  readonly="true" cssClass="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<form:label path="duree" cssClass="col-xs-2 control-label">Durée :</form:label>
					<div class="col-xs-10">
						<form:input path="duree" readonly="true"   cssClass="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<form:label path="vu" cssClass="col-xs-2 control-label">Vu :</form:label>
					<div class="col-xs-10">
						<input id="vu" value="${film.vu?'Oui':'Non'}" readonly   class="form-control" /> 
					</div>
				</div>


				<c:forEach items="${ film.acteurs}" var="act" varStatus="status">
					<div class="form-group">			
						<form:label path="duree" cssClass="col-xs-2 control-label">Acteur ${status.index + 1} :</form:label>
						<div class="col-xs-5">
							<input name="acteurs[${status.index}].prenom" readonly value="${act.prenom}"   class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input name="acteurs[${status.index}].nom" readonly value="${act.nom}"  class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<form:label path="synopsis" cssClass="col-xs-2 control-label">Synopsis :</form:label>
					<div class="col-xs-10">
						<form:textarea path="synopsis" rows="5" readonly="true"  cssClass="form-control" /> 
					</div>
				</div>
			
	</form:form>
	</div>
</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<ul class="nav navbar-nav  navbar-foot">
				<li class="pull-left"><a>© 2017 Copyright</a></li>
				<li class="pull-right"><a >Formation Eni</a></li>		
			</ul>
		</div>
	</nav>	
	
</body>
</html>