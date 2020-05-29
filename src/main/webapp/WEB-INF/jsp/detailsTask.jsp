<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
            <a href="../index.jsp" class="navbar-brand active">
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
                <li><a href="../index.jsp">Accueil</a></li>
                <li><a href="listTasks">Tasks</a></li>
                <li><a href="createCategory">Categories</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <h1 class="bleu">Votre film</h1>
    <br><br>
    <div>
        <form:form cssClass="form-horizontal" modelAttribute="task">
            <div class="form-group">
                <form:label path="name" cssClass="col-xs-2 control-label">Name :</form:label>
                <div class="col-xs-10">
                    <form:input path="name" readonly="true" cssClass="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="description" cssClass="col-xs-2 control-label">Description :</form:label>
                <div class="col-xs-10">
                    <form:input path="description" readonly="true" cssClass="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="date" cssClass="col-xs-2 control-label">Date :</form:label>
                <div class="col-xs-10">
                    <form:input path="date" type="date" readonly="true" cssClass="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <form:label path="done" cssClass="col-xs-2 control-label">Durée :</form:label>
                <div class="col-xs-10">
                    <form:checkbox readonly="true" path="done" cssClass="form-control"/>
                </div>
            </div>

        </form:form>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="container">
        <ul class="nav navbar-nav  navbar-foot">
            <li class="pull-left"><a>© 2017 Copyright</a></li>
            <li class="pull-right"><a>Formation Eni</a></li>
        </ul>
    </div>
</nav>

</body>
</html>