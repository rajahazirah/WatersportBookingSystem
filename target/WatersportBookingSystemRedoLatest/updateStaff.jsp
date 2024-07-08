<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Staff</title>
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
    <section class="register">
        <form class="register-form" action="CustomerController?action=updateStaff" method="post">
    		<input type="hidden" name="staffID" value="${staff.staffID}">
    		<label for="staffName">Name:</label>
    		<input type="text" id="staffName" name="staffName" value="${staff.staffName}" required>
    		<label for="staffUsername">Username:</label>
    		<input type="text" id="staffUsername" name="staffUsername" value="${staff.staffUsername}" required>
    		<label for="staffPassword">Password:</label>
    		<input type="password" id="staffPassword" name="staffPassword" value="${staff.staffPassword}" required>
    		<label for="staffEmail">Email:</label>
    		<input type="email" id="staffEmail" name="staffEmail" value="${staff.staffEmail}" required>
    		<button type="submit" class="btn btn-primary">Update Staff</button>
		</form>

    </section>
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
