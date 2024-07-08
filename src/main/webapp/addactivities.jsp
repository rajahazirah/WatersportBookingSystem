<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Activity</title>
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
            <li><a href="indexstaff.html">Home</a></li>
            <li><a href="activities.html">Activities</a></li>
        </ul>
        <div class="icon-color">
            <a href="#" style="font-size: 2em"><i class='bx bx-user-circle'></i></a>

        </div>
    </header>

    <section class="addact">
        <form class="addact-form" action="ActivityController" method="post">
            <h2>Add Activities</h2>
            <input type="hidden" name="action" value="add">
            
            <input type="text" placeholder="Enter Name Activity" name="actname" required>
            <input type="text" placeholder="Enter Description" name="actdesc" required>
            <input type="number" placeholder="Enter Price" name="actprice" step="0.01" required>
            <input type="text" placeholder="Enter Pax" name="actpax" required>
         
<button class="btn btn-info" type="submit">Add Activities</button>
<button class="btn btn-info" type="button" onclick="location.href='ActivityController?action=list&view=admin'">Manage Activities</button><br><br>
<button class="btn btn-info" type="button" onclick="location.href='ActivityController?action=list'">Activities</button>

        </form>
    </section>
    
    <br><br><br><br><br><br><br>
    <br><br><br>
    <footer class="footer">
        <div class="row">

        </div>
    </footer>
</body>
</html>
