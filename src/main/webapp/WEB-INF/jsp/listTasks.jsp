<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <script src="../js/commun.js"></script>
    <link rel="stylesheet" href="../css/commun.css">

    <style type="text/css">


        .centre {
            text-align: center;
        }


        img {
            vertical-align: bottom;
        }
    </style>
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
    <h1 class="bleu">Tasks list</h1>
    <br><br>
    <table class="table table-hover table-striped">
        <tr>
            <th><a href="sortTasks?type=tA"><span class="glyphicon glyphicon-menu-down"></span></a> Name <a
                    href="sortTasks?type=tD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
            <th></th>
            <th><a href="sortTasks?type=dA"><span class="glyphicon glyphicon-menu-down"></span></a> Date <a
                    href="sortTasks?type=dD"><span class="glyphicon glyphicon-menu-up"></a></th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${tasks}" var="t" varStatus="bStatus">
            <tr>
                <td><a href="detailsTask?index=${t.id}">${t.name}</a></td>
                <td>${t.description}</td>
                <td>${t.date}</td>
                <td>${t.done?"Yes":"No"}</td>
                <td class="centre">
                    <span class="modif glyphicon glyphicon-edit vert" id="m${f.id}"></span>
                </td>
                <td class="centre">
                    <span class="glyphicon glyphicon-remove rouge supp" id="s${f.id}"></span>
                </td>
            </tr>
        </c:forEach>
    </table>


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