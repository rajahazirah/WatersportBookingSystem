<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Activities</title>
<!-- css -->
<link rel="stylesheet" href="style.css">
<!-- Box Icons -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<script>
    function confirmDelete(actId) {
        if (confirm("Are you sure you want to delete this activity?")) {
            window.location.href = 'ActivityController?action=delete&actid=' + actId;
        }
    }
</script>
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
            <h1>Activities List</h1>
            <table border="1" class="styled-table">
                <tr style="font-weight: bold;">
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Pax-person</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="act" items="${acts}">
                    <tr>
                        <td><c:out value="${act.actid}"/></td>
                        <td><c:out value="${act.actname}"/></td>
                        <td><c:out value="${act.actdesc}"/></td>
                        <td><c:out value="${act.actprice}"/></td>
                        <td><c:out value="${act.actpax}"/></td>
                        <td>
                            <a class="btn btn-info" href="ActivityController?action=view&actid=${act.actid}">View</a>
							<a class="btn btn-info" href="ActivityController?action=edit&actid=${act.actid}">Update</a>
							<a class="btn btn-info" href="javascript:confirmDelete(${act.actid})">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button class="btn btn-info" type="button" onclick="history.back()">Back</button>
        </div>
    </section>
    
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
    <script>
    function confirmDelete(actId) {
        if (confirm("Are you sure you want to delete this activity?")) {
            window.location.href = 'ActivityController?action=delete&actid=' + actId;
        }
    }
</script>
</body>
</html>
