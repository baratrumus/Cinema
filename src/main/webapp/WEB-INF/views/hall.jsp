<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html lang="en">
<head>
    <title>Booking of cinema places.</title>
    <meta charset="utf-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script type="text/javascript" src="js/cinema.js"></script>
    <style><%@include file="/css/style.css"%></style>

</head>
<body>


<script>
    $(document).ready(function () {
        loadBuzyPlaces();
        setInterval(function() {loadBuzyPlaces() }, 10000);
    });
</script>


<h2 align="center">Booking of places.</h2>

<c:set var = "orderInfo" scope = "session" value = "${sessionScope.orderInfo}"/>

<c:if test="${orderInfo != null}">
    <div class="centred"><b><c:out value="${sessionScope.orderInfo}"/></b></div>
</c:if>
<br>
<div class="container">
    <div class="row pt-3">

        <table class="table table-bordered">
            <thead>
            <tr>
                <th class="wd">Row / Place</th>
                <th>1</th>
                <th>2</th>
                <th>3</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>1</th>
                <td><input type="radio" name="place" value="11"> Row 1, Place 1</td>
                <td><input type="radio" name="place" value="12"> Row 1, Place 2</td>
                <td><input type="radio" name="place" value="13"> Row 1, Place 3</td>
            </tr>
            <tr>
                <th>2</th>
                <td><input type="radio" name="place" value="21"> Row 2, Place 1</td>
                <td><input type="radio" name="place" value="22"> Row 2, Place 2</td>
                <td><input type="radio" name="place" value="23"> Row 2, Place 3</td>
            </tr>
            <tr>
                <th>3</th>
                <td><input type="radio" name="place" value="31"> Row 3, Place 1</td>
                <td><input type="radio" name="place" value="32"> Row 3, Place 2</td>
                <td><input type="radio" name="place" value="33"> Row 3, Place 3</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row float-right">
        <button type="submit" class="btn btn-success" onclick="orderPlace()">Pay</button>
    </div>
</div>
    <div class="container">
    <h3  align="center">Buzy places:</h3>
    <table class="table" id="buzyT">
        <thead>
        <tr>
            <th>Row</th>
            <th>Place</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>


</body>
</html>