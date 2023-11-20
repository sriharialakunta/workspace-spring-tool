<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Student Welcome Page</title>
</head>
<body>
<div class="text-center">
<h1>Welcome to the Student Spring Security Page</h1>
<h3>To View Student details click here </h3>
<a href="${pageContext.request.contextPath}/stu/student">Student Details</a>
</div>

<div class="text-center">
<h3>To View All Student details click here </h3>
<a href="${pageContext.request.contextPath}/stu/admin">All Student Details</a>
</div>
</body>
</html>