<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Activities</title>
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
            <li><a href="activities.html">Activities</a></li>
        </ul>
        <div class="icon-color">
            <a href="#" style="font-size: 2em"><i class='bx bx-user-circle'></i></a>

        </div>
    </header>

    <section class="view">
        <div class="view-form">
            <h1>View Activities Info</h1>
            <table border="1" class="styled-table">
                <tr style="font-weight: bold;">
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Pax-person</th>
                </tr>
                <tr>
                    <td><c:out value="${activity.actid}"/></td>
					<td><c:out value="${activity.actname}"/></td>
                    <td><c:out value="${activity.actdesc}"/></td>
                    <td><c:out value="${activity.actprice}"/></td>
                    <td><c:out value="${activity.actpax}"/></td>
                </tr>
            </table>
            <button class="btn btn-info" type="button" onclick="history.back()">Back</button>
        </div>
    </section>
    
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
