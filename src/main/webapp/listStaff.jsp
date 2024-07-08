<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff List</title>
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
    
    <section class="act">
        <form class="act-form">
        <h1>Staff List</h1>
        <table border="1" class="styled-table">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th colspan="3">Action</th>
        </tr>
        <c:forEach items="${staffs}" var="staff" varStatus="staffs">
        <tr>
            <td><c:out value="${staff.staffID}"/></td>
            <td><c:out value="${staff.staffName}"/></td>
            <td><c:out value="${staff.staffUsername}"/></td>
            <td><c:out value="${staff.staffPassword}"/></td>
            <td><c:out value="${staff.staffEmail}"/></td>      
            <td><a class="btn btn-info" href="CustomerController?action=viewStaff&staffID=<c:out value='${staff.staffID}'/>">Update</a></td>
            <td>
                <button class="btn btn-danger" id="${staff.staffID}" onclick="confirmation(${staff.staffID})">Delete</button>
            </td>
        </tr>
        </c:forEach>
        </table>
        <script>
        function confirmation(staffID) {
            console.log(staffID);
            var r = confirm("Are you sure you want to delete?");
            if (r == true) {
                location.href = 'CustomerController?action=deleteStaff&staffID=' + staffID;
                alert("Staff successfully deleted");
            } else {
                return false;
            }
        }
        </script>
        </form>
    </section>
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
