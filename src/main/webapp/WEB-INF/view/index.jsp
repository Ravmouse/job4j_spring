<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Accidents</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/css.css'/>">
    </head>

    <body>
        <div class="container">
            <h2>Правонарушения</h2>
            <p></p><p></p>
            <table class="table table-bordered" id="tab">
                <thead>
                    <tr>
                        <th>Номер</th>
                        <th>Название</th>
                        <th>Сообщение</th>
                        <th>Адрес</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${accidents}" var="accs" varStatus="status">
                        <tr>
                            <td>${accs.id}</td>
                            <td>${accs.name}</td>
                            <td>${accs.text}</td>
                            <td>${accs.address}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="<c:url value='/accidents/add'/>">
                <input type="submit" class="btn btn-outline-primary" value="Добавить" style="float: left">
            </form>
            <input type="button" class="btn btn-outline-primary" value="Выход" style="float: right"
                   onclick="window.location.href = '<c:url value="/logout"/>'">
        </div>
    </body>
</html>