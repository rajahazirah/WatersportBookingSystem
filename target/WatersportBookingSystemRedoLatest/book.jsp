<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Your Rides</title>
    <!-- css -->
<link rel="stylesheet" href="style.css">
<!-- Box Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body class="global-styles">
    <style>
    body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f0f0f0;
        }
        .container {
            display: flex;
            max-width: 1200px;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
        .book-content {
            font-family: Arial, sans-serif;
            margin: 20px;            
        }
        
        h2 {
            color: #333;
        }
        p {
            color: #555;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
            text-align: left;
        }
        .option {
            display: flex;
            align-items: center;
        }
        .option input[type="datetime-local"],
        .option select {
            margin-left: 10px;
        }
        .option span {
            margin-left: 10px;
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
    <div class="book-content">
        <h2>Book Your Rides Today</h2>
        <p>Save time and skip the queue by booking your rides online</p>
        <div class="book-form">
            <form action="BookingController" method="post">
                <table>
                    <thead>
                        <tr>
                            <th>Checkbox</th>
                            <th>Activities</th>
                            <th>Date</th>
                            <th>Duration/Round</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="activity" items="${activities}">
                            <tr>
                                <td><input type="checkbox" id="${activity.actname}" name="selectedActivities" value="${activity.actid}"></td>
                                <td><label for="${activity.actname}">${activity.actname}</label></td>
                                <td><input type="datetime-local" name="${activity.actid}_date"></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${activity.actname == 'Tour Boat'}">
                                            <select name="${activity.actid}_duration">
                                                <option value="15">15 minutes</option>
                                                <option value="30">30 minutes</option>
                                                <option value="60">1 hour</option>
                                            </select>
                                        </c:when>
                                        <c:otherwise>
                                            <select name="${activity.actid}_round">
                                                <option value="1">1 round</option>
                                                <option value="2">2 rounds</option>
                                                <option value="3">3 rounds</option>
                                            </select>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td><span>Price: ${activity.actprice}</span></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table><br>
                <button type="submit">Book Now</button>
            </form>
        </div>
    </div>
    <footer class="footer">
    <div class="row">

    </div>
</footer>
</body>
</html>
