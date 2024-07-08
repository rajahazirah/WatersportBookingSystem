<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
    
        .confirmation-content {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h2 {
            color: #333;
        }
        p {
            color: #555;
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
    <div class="confirmation-content">
        <h2>Booking Confirmation</h2>
        <!-- Display or fetch the activities information that are selected from book.jsp -->
        <p>Click here to make the payment</p>
        <p>Thank you for choosing our service.</p>
        <button type="button" onclick="window.location.href='index.html'">Go to Home</button>
    </div>
        <footer class="footer">
    <div class="row">

    </div>
</footer>
</body>
</html>
