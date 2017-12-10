<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Бронирование билетов</title>
</head>

<body>

<h3>Список билетов в системе</h3>

<table id="main_table" style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#d3dce3">
    <tr>
        <th>Номер билета</th>
        <th>Название фильма</th>
        <th>ФИО</th>
        <th>Эл. почта</th>
        <th>Зал</th>
        <th>Ряд</th>
        <th>Место</th>
        <th>Статус</th>
        <th></th>
        <th></th>
        <!--
                <th colspan="2">Edit/Remove</th>
                <th>Empty</th>
                <th>Empty</th>
                <th colspan="3"></th>
        -->
    </tr>
    </thead>
    <tbody style="background:#ccc">
    <tr></tr>
    </tbody>

</table>

<a id="status_receive"></a>

<br/>

<form action="/sys/addTicket" method="get">
    <button type="button" onclick="GetTickets()">Get Tickets</button>
    <button type="submit">Add New Ticket</button>
</form>

<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/table.js"></script>
<script>$(document).ready(GetTickets());</script>

</body>

</html>