<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activities</title>
<!-- css -->
<link rel="stylesheet" href="style.css">
<!-- Box Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
</head>
<body class="global-styles">
    <!-- Header -->
    <header>
        <a href="#" class="logo"><img src="image/logo.png" alt=""></a>
        
        <div class="bx bx-menu" id="menu-icon"></div>
        
        <ul class="navbar">
            <li><a href="index.html">Home</a></li>
            <li><a href="activities.jsp">Activities</a></li>
        </ul>
        <div class="icon-color">
            <a href="#" style="font-size: 2em"><i class='bx bx-user-circle'></i></a>
        </div>
    </header>
    
    <section class="activities" id="activities">
        <div class="hh">
            <h2>Our Activities</h2><br>
        </div>
        <div class="activities-container">
            <c:forEach var="act" items="${acts}">
                <a href="ActivityController?action=view&actid=${act.actid}" class="box">
                    <div class="box-img">
                        <c:choose>
                            <c:when test="${act.actname == 'Banana Boat'}">
                                <img src="image/banana.jpg" alt="${act.actname}">
                            </c:when>
                            <c:when test="${act.actname == 'Tour Boat'}">
                                <img src="image/boat2.jpg" alt="${act.actname}">
                            </c:when>
                            <c:when test="${act.actname == 'Jet Boat'}">
                                <img src="image/jetboat.jpg" alt="${act.actname}">
                            </c:when>
                            <c:when test="${act.actname == 'Donut Boat'}">
                                <img src="image/donutboat.jpg" alt="${act.actname}">
                            </c:when>
                            <c:when test="${act.actname == 'Band Boat'}">
                                <img src="image/bandboat.jpg" alt="${act.actname}">
                            </c:when>
                        </c:choose>
                    </div>
                    <h3>${act.actname}</h3>
                    <p>Number of Pax: ${act.actpax}</p>
                    <p>Description: ${act.actdesc}</p>
                    <p>Price: RM${act.actprice}</p>
                </a>
            </c:forEach>
        </div><br>
        <button class="btn btn-info" type="button" onclick="history.back()">Back</button>
        <button class="btn btn-info" type="button" onclick="location.href='ActivityController?action=list'">Activities</button>
        <button class="btn btn-info" type="button" onclick="location.href='ActivityController?action=book'">Book Your Ride</button>

        
      
    </section>
    
    <br><br><br><br><br><br><br>
    <br><br><br>
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
