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
            <h2>Добавить правонарушение</h2>
            <p></p><p></p>
            <div class="in_div">
                <form action="<c:url value="/accidents/add"/>" method="post" id="frm" modelattribute="accident">
                    <div class="elem_div">
                        <label for="name">Название:</label>
                        <input class="form-control" id="name" name="name" placeholder="Введите название">
                    </div>
                    <div class="elem_div">
                        <label for="text">Сообщение:</label>
                        <textarea class="form-control" id="text" name="text" placeholder="Введите сообщение"></textarea>
                    </div>
                    <div class="elem_div">
                        <label for="address">Адрес:</label>
                        <input class="form-control" id="address" name="address" placeholder="Введите адрес">
                    </div>
                    <div class="elem_div">
                        <input type="button" class="btn btn-outline-success" value="Добавить" id="btn_add">
                    </div>
                </form>
            </div>
        </div>
    </body>
    <footer>
        <script src="<c:url value='/resources/js/js.js'/>"></script>
    </footer>
</html>