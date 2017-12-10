<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Бронирование нового билета</title>
    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h3>Добавление нового билета</h3>

<table cellspacing="4" style="text-align:left">
    <form:form action="addTicket.do" commandName="ticketForm">

        <tr>
            <td align="left" width="20%">Название фильма:</td>
            <td align="left" width="40%"><form:input path="film" size="30"/></td>
            <td align="left"><form:errors path="film" cssClass="error"/></td>
        </tr>
        <tr>
            <td align="left" width="20%">ФИО:</td>
            <td align="left" width="40%"><form:input path="name" size="30"/></td>
            <td align="left"><form:errors path="name" cssClass="error"/></td>
        </tr>
        <tr>
            <td align="left" width="20%">Эл. почта:</td>
            <td align="left" width="40%"><form:input path="email" size="30"/></td>
            <td align="left"><form:errors path="email" cssClass="error"/></td>
        </tr>
        <tr>
            <td align="left" width="20%">Зал:</td>
            <td align="left" width="40%"><form:input path="hall" size="30"/></td>
            <td align="left"><form:errors path="hall" cssClass="error"/></td>
        </tr>
        <tr>
            <td align="left" width="20%">Ряд:</td>
            <td align="left" width="40%"><form:input path="row" size="30"/></td>
            <td align="left"><form:errors path="row" cssClass="error"/></td>
        </tr>
        <tr>
            <td align="left" width="20%">Место:</td>
            <td align="left" width="40%"><form:input path="place" size="30"/></td>
            <td align="left"><form:errors path="place" cssClass="error"/></td>
        </tr>
        <tr>
            <td align="left" width="20%">Статус билета:</td>
            <td align="left" width="40%"><form:input path="status" size="30"/></td>
            <td align="left"><form:errors path="status" cssClass="error"/></td>
        </tr>
        <tr>
            <td></td>
            <td align="center"><input type="submit" value="Отправить"/>
            <input type="button" onclick="ListTickets()" value="Отмена"/></td>
            <td></td>
        </tr>
    </form:form>
</table>

<script>function ListTickets() {
    window.location.replace(window.location.protocol + '//' + window.location.host);
}</script>
</body>
</html>
