
<%@ page contentType="text/html; charset=ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Customers</title>
    
    <link rel="stylesheet" type="text/css" href="css/table.css">
    
    
    <style>

  body {
    background-image: url('images/listback.jpg'); /* Replace 'your-background-image.jpg' with your image file path */
    background-size: 100% auto; /* This will make the image cover the entire body */
    background-position: center; /* This centers the image */
    background-repeat: no-repeat; /* Prevents repeating the image */
  }
</style>
    

</head>
<body>

<%@ include file="adminNavbar.jsp" %>

<br>
<br>
<br>
    <section>
        <h1>View All Customers</h1>
        <div class="tbl-header">
            <table cellpadding="0" cellspacing="0" border="0">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>FullName</th>
                        <th>Gender</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Contact No</th>
                    </tr>
                </thead>
            </table>
        </div>
        <div class="tbl-content">
            <table cellpadding="0" cellspacing="0" border="0">
                <tbody>
                 <c:forEach items="${cdata}" var="c">
                    <tr>
                        <td><c:out value="${c.id}" /></td>
                        <td><c:out value="${c.fullname}" /></td>
                         <td><c:out value="${c.gender}" /></td>
                         <td><c:out value="${c.username}" /></td>
                         <td><c:out value="${c.email}" /></td>
                         <td><c:out value="${c.phonenumber}" /></td>
                    </tr>
                    </c:forEach>
                    <!-- Add more data rows as needed -->
                </tbody>
            </table>
        </div>
    </section>

    
</body>
</html>
