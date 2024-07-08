<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment</title>
    <!-- css -->
<link rel="stylesheet" href="style.css">
<!-- Box Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body class="global-styles">
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        .header {
            text-align: center;
            margin-bottom: 20px;
        }
        .header h2 {
            margin: 0;
        }
        .content {
            display: flex;
            justify-content: space-between;
        }
        .activity-info, .payment-info {
            width: 45%;
        }
        .activity-info table, .payment-info table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .payment-method {
            margin-top: 20px;
        }
        .payment-method input[type="radio"] {
            margin-right: 10px;
        }
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        .buttons button {
            padding: 10px 20px;
            background-color: #185B72;
            color: #fff;
            border: none;
            cursor: pointer;
            margin: 5px;
        }
    </style>
    <header>
    <a href="#" class="logo"><img src="image/logo.png" alt=""></a>
    
    <div class="bx bx-menu" id="menu-icon"></div>
    
    <ul class="navbar">
        <li><a href="index.html">Home</a></li>
        <li><a href="activities.html">Activities</a></li>

    </ul>
    <div class="icon-color">
        <a href="#" style="font-size: 2em"><i class='bx bx-user-circle' ></i></a>

    </div>
</header>
</head>
<body>

<div class="container">
    <div class="header">
        <h2>Payment Details</h2>
    </div>

    <div class="content">
        <div class="activity-info">
            <h3>Selected Activities</h3>
            <table>
                <thead>
                    <tr>
                        <th>Activity ID</th>
                        <th>Booking Date</th>
                        <th>Booking Time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="booking" items="${sessionScope.bookings}">
                        <tr>
                            <td>${booking.actId}</td>
                            <td><fmt:formatDate value="${booking.bookingDate}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${booking.bookingTime}" pattern="HH:mm:ss"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="payment-info">
            <h3>Choose your payment method</h3>
            <form action="PaymentController" method="post">
                <div class="payment-method">
                    <label>
                        <input type="radio" name="payment" value="card" checked> Credit & Debit Cards
                    </label><br>
                    <label>
                        <input type="radio" name="payment" value="applepay"> Apple Pay
                    </label><br>
                    <label>
                        <input type="radio" name="payment" value="fpx"> FPX
                    </label><br>
                    <label>
                        <input type="radio" name="payment" value="grabpay"> GrabPay
                    </label>
                </div>
                <div class="buttons">
                    <button type="submit">Place Order</button>
                </div>
            </form>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="row">

    </div>
</footer>

</body>
</html>
