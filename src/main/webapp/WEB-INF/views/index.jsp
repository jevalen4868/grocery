<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>grocery - index</title>
</head>
<body>
<c:if test="${not empty message}">
    <div class="alert alert-danger">${message}</div>
</c:if>

<c:if test="${not empty search}">
	Search: <input type="text" value="${search}" id="grocerySearch">
</c:if>
<c:if test="${empty search}">
	Search: <input type="text" id="grocerySearch">
</c:if>

	<input type="button" value="Search" id="searchBtn"/>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading row content">
				<div class="col-md-1">
					Display Id
				</div>
				<div class="col-md-2">
					Description
				</div>
				<div class="col-md-1">
					Last Sold
				</div>
				<div class="col-md-1">
					Shelf Life
				</div>
				<div class="col-md-1">
					Department
				</div>
				<div class="col-md-1">
					Price
				</div>
				<div class="col-md-1">
					Unit
				</div>
				<div class="col-md-1">
					x for
				</div>
				<div class="col-md-1">
					Cost
				</div>
			</div>
			<div class="panel-body row content">
				<c:forEach items="${groceryList}" var="grocery">
					<div class="row">
						<div class="col-md-1">
                                ${grocery.displayId}
						</div>
						<div class="col-md-2">
								${grocery.description}
						</div>
						<div class="col-md-1">
								${grocery.lastSold}
						</div>
						<div class="col-md-1">
								${grocery.shelfLife}
						</div>
						<div class="col-md-1">
								${grocery.department}
						</div>
						<div class="col-md-1">
								${grocery.price}
						</div>
						<div class="col-md-1">
								${grocery.unit}
						</div>
						<div class="col-md-1">
								${grocery.xFor}
						</div>
						<div class="col-md-1">
								${grocery.cost}
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
<script src='<s:url value="/resources/js/index.js" />'></script>
</html>