<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
	<h2>Show Data Page!</h2>
	<a href="AllFarmerReport" target="_blank">Display All Farmer Report</a>
	
	<table class="table table-striped">
			<thead>
				<tr>
				<td>Id</td>
					<td>Name</td>
					<td>Address</td>
						<td>Phone</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="current">
					<tr>
					<td><c:out value="${current.id}" /></td>
						<td><c:out value="${current.name}" /></td>
						<td><c:out value="${current.address}" /></td>
						<td><c:out value="${current.phone}" /></td>
						<td><a class="btn btn-primary" href="updateFarmer1?id=<c:out value="${current.id}" />" > Update</a></td>
						<td><a class="btn btn-danger" href="deleteFarmer?id=<c:out value="${current.id}" />"  > Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
