<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Confirmation</title>
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
            margin-top: 20px;
        }
        .content p {
            margin: 5px 0;
        }
        .activity-info, .payment-info {
            margin-top: 20px;
        }
        table {
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
        <h2>Booking Confirmation</h2>
    </div>

    <div class="content">
        <p><strong>Customer ID:</strong> ${sessionScope.customer.custId}</p>

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
            <h3>Payment Information</h3>
            <p><strong>Payment ID:</strong> ${sessionScope.payment.paymentId}</p>
            <p><strong>Payment Type:</strong> ${sessionScope.payment.paymentType}</p>
        </div>
    </div>

    <div class="buttons">
        <button type="button" onclick="window.print()">Print Receipt</button>
        <button type="button" onclick="window.location.href='index.html'">Go to Home</button>
    </div>
</div>
<footer class="footer">
    <div class="row">

    </div>
</footer>
</body>
</html>
