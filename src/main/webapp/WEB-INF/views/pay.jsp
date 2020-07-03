<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<html lang="en">
<head>

    <meta charset="utf-8">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <style><%@include file="/css/style.css"%></style>
    <script type="text/javascript" src="js/payment.js"></script>

    <script>
        $(loadInfo());
    </script>

    <title>Payment</title>

</head>
<body>
<div class="container">
    <div class="row pt-3" id="chosenPlaceInfo">

    </div>
    <div class="row">
        <form class="form-signin" method='post' action="/order">
            <div class="form-group">
                <label for="fullName"  class="sr-only">Name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Name">
            </div>
            <div class="form-group">
                <label for="phone"  class="sr-only">Telephone number</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Telephone number">
            </div>
            <button type="submit" class="btn btn-success">Pay</button>
            <button type="button" class="btn btn-success" onclick="goToMain()">Main page</button>
        </form>
    </div>
</div>

</body>
</html>