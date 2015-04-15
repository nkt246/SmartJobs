<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Seeker Details</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="well well-lg">Smart Jobs</div>
	<table class="table table-striped table-hover" style="margin-top: 50px">
		<!-- <thead>
			<tr>
				<th>#</th>
				<th>Column heading</th>
				<th>Column heading</th>
				<th>Column heading</th>
			</tr>
		</thead> -->

		<tbody>
			<c:forEach var="name" items="${jname}" varStatus="cnt">
				<tr class="success">
					<td><c:out value="${cnt.count}"></c:out></td>
					<td><c:out value="${name}"></c:out></td>
					<td><a href="#" class="btn btn-primary btn-xs">View
							Details</a></td>
					<!-- <td>Column content</td>
					<td>Column content</td> -->
				</tr>
			</c:forEach>

		</tbody>

	</table>
</body>
</html>