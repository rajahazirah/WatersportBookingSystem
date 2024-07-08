<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Staff</title>
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
            <a href="#" style="font-size: 2em"><i class='bx bx-user-circle' ></i></a>
        </div>
    </header>
    
    <section class="view">
        <div class="view-form">
            <h2>Staff Info</h2>
            <table border="1" class="styled-table">
                <tr style="font-weight: bold;">
                    <td>Id</td>
                    <td>Name</td>
                    <td>Username</td>
                    <td>Password</td>
                    <td>Email</td>
                </tr>
                <tr>
                    <td><c:out value="${staffID}"/></td>
                    <td><c:out value="${staffName}"/></td>
                    <td><c:out value="${staffUsername}"/></td>
                    <td><c:out value="${staffPassword}"/></td>
                    <td><c:out value="${staffEmail}"/></td>
                </tr>
            </table>
        </div>
    </section>
    
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
