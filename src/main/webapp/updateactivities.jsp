<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Activities</title>
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
            <li><a href="indexadmin.html">Home</a></li>
            <li><a href="activities.html">Activities</a></li>
        </ul>
        <div class="icon-color">
            <a href="#" style="font-size: 2em"><i class='bx bx-user-circle'></i></a>

        </div>
    </header>

    <section class="addact">
        <form class="addact-form" action="ActivityController" method="post">
            <input type="hidden" name="action" value="update">
            <h1>Update Activities</h1>
            <label>Id: </label>
            <input type="text" name="actid" value="${activity.actid}" size="50" readonly><br>
            <label>Name:</label>
            <input type="text" name="actname" value="${activity.actname}" size="50"><br>
            <label>Description:</label>
            <input type="text" name="actdesc" value="${activity.actdesc}" size="50"><br>
            <label>Price:</label>
            <input type="number" name="actprice" value="${activity.actprice}" step="0.01" size="50"><br>
            <label>Pax:</label>
            <input type="text" name="actpax" value="${activity.actpax}" size="50"><br>
            
            <br><br>
            <input class="btn btn-info" type="submit" value="Submit">
            <input class="btn btn-info" type="reset" value="Reset">
            <button class="btn btn-info" type="button" onclick="history.back()">Back</button>
        </form>
    </section>
    
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
