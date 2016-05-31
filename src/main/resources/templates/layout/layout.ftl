<#macro layout>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Starter Template for Bootstrap</title>

    <script src="/webjars/jquery/2.1.3/jquery.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/formvalidation/0.6.1/js/formValidation.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/formvalidation/0.6.1/js/framework/bootstrap.min.js"></script>

    <script src="/webjars/bootstrap/3.3.4/js/bootstrap.js"></script>
    <script src="/webjars/bootstrap-datepicker/1.6.1/js/bootstrap-datepicker.min.js"></script>
    <script src="/webjars/momentjs/2.12.0/moment.js"></script>
    <script src="/webjars/bootstrap-daterangepicker/2.1.19/daterangepicker.js"></script>

    <link href="/webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
    <link href="/webjars/bootstrap-datepicker/1.6.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <link href="/webjars/bootstrap-daterangepicker/2.1.19/daterangepicker.css" rel="stylesheet">

</head>

<body>


<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Сеть отелей</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
                <li><a href="/corpuses">Корпусы</a></li>
                <li><a href="/visitors">Посетители</a></li>
                <li><a href="#">Жалобы</a></li>
                <li><a href="/partners">Партнеры</a></li>
                <li><a href="/booking">Бронирование</a></li>
            </ul>
        </div>
    </nav>


</div>


<div class="container">

    <div class="starter-template">
        <#nested>
    </div>

</div>

</body>
</html>
</#macro>