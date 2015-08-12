<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page isELIgnored="false" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<title>Product Management Application</title>
	<style type="text/css">
	body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	
	</style>
</head>
<body>
	<form id="products">
		<div class="container">
			<div class="row bg-success txt-success">
				<div class="col-md-12" style="border:1px solid black;text-align:center;border-radius:10px">
					<h2 class="text-error text-uppercase">Rakuten Product Management System</h2>
				</div>
			</div>
			<div class="row">&nbsp;</div>
			<div class="row">
				<div class="col-md-8" style="border:0px solid black;text-align:left;">
					<span class="text-uppercase txt-danger" style="margin-right:15px;"><strong>Sort By</strong></span>
					<a href="<c:url value="/sort/pricehightolow" />" style="width:190px;" class="btn btn-primary btn-sm text-uppercase sort-by-pricehightolow" role="button">Price High to Low&nbsp;&nbsp;<span class="glyphicon glyphicon-menu-down">&nbsp;</span></a>
					<a href="<c:url value="/sort/pricelowtohigh" />" style="width:190px;" class="btn btn-primary btn-sm text-uppercase sort-by-pricelowtohigh" role="button">Price Low to High&nbsp;&nbsp;<span class="glyphicon glyphicon-menu-up">&nbsp;</span></a>
					<a href="<c:url value="/sort/popularity" />" style="width:190px;" class="btn btn-primary btn-sm text-uppercase sort-by-popularity active" role="button">Popularity</a>
				</div>
				<div class="col-md-4" style="border:0px solid black;text-align:right">
					<a href="<c:url value="/login" />" class="btn btn-success btn-sm active text-uppercase login-button" role="button"><strong>Login</strong></a>				
					<security:authorize ifAnyGranted="ROLE_SUPERUSER">
						<a href="<c:url value="/product/add" />" class="btn btn-warning btn-sm glyphicon glyphicon-plus add-product" role="button" title="Add Product"></a>
						<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-success btn-sm active text-uppercase logout-button" role="button"><strong>Logout</strong></a>
					</security:authorize>
					<security:authorize ifAnyGranted="ROLE_USER">
						<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-success btn-sm active text-uppercase" role="button"><strong>Logout</strong></a>
					</security:authorize>
				</div>
			</div>
			<div class="row product-delete-message">
				<div class="col-md-4">&nbsp;</div>
				<div class="col-md-6"><h3><span class="label label-danger"><c:out value="${productname}"/>&nbsp;[<c:out value="${productid}"/>] has been removed successfully.</span></h3></div>
				<div class="col-md-2">&nbsp;</div>
			</div>				
			<div class="row">&nbsp;</div>
			<div class="row" style="padding-right:1%;padding-left:5%;">
			<c:forEach var="product" items="${products}" varStatus="columnNum">
				<div class="col-md-3" style="border:1px solid black;text-align:center;padding-bottom:10px;border-radius:7px;margin-top:5px;margin-bottom:5px;">
					<h3><a href="<c:url value="/product/"/><c:out value="${product.id}"/>" class="show-product-detail"><c:out value="${product.name}"/></a></h3>
					<h4><c:out value="${product.description}"/>&nbsp;</h4>
					<h5><c:out value="${product.price}"/></h5>
					<security:authorize ifAnyGranted="ROLE_SUPERUSER">
						<!-- <button type="button" class="btn btn-warning btn-sm glyphicon glyphicon-trash delete-product" value="<c:out value="${product.id}"/>"></button> -->
						<a href="<c:url value="/product/delete/"/><c:out value="${product.id}"/>/name/<c:out value="${product.name}"/>" class="btn btn-warning btn-sm glyphicon glyphicon-trash delete-product" role="button"></a>
					</security:authorize>
				</div>
				<div class="col-md-1" style="border:0px solid black;text-align:center;">&nbsp;</div>
			</c:forEach>
			</div>
			<div class="row">&nbsp;</div>
		</div>
	</form>
</body>
<script src="<c:url value="/resources/js/jquery.js" />"/></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript">
	$( document ).ready(function() {
		$(".delete-product").click(function( event ) {
			var isYes = confirm('Are you sure to Delete?');
			if(isYes){
				$("#products").submit();
			} else {
				event.preventDefault();
			}
		});
		
		$(".show-product-detail").click(function( event ) {
			$("#products").attr("action", "productdetail");
			$("#products").submit();
		});
		/*
		$(".sort-by-pricelowtohigh").click(function( event ) {
			$("#products").attr("action", "sort/"+$(".sort-by-pricelowtohigh").val());
			$("#products").submit();
		});
		
		$(".sort-by-pricehightolow").click(function( event ) {
			$("#products").attr("action", "sort/"+$(".sort-by-pricehightolow").val());
			$("#products").submit();
		});
		
		$(".sort-by-popularity").click(function( event ) {
			$("#products").attr("action", "sort/"+$(".sort-by-popularity").val());
			$("#products").submit();
		});
		
		$(".add-product").click(function( event ) {
			$("#products").attr("action", "productdetail/-1");
			$("#products").submit();
		});
		*/
		$(".product-delete-message").hide();
		<c:if test="${null ne productdeletemessage}">
			$(".product-delete-message").show();
		</c:if>
		
		if($('.logout-button').is(':visible'))
		{
			$(".login-button").hide();
		}
		
		<c:choose>
			<c:when test="${'PriceLowToHigh' eq sortBy}">
				$(".sort-by-pricehightolow").removeClass('active');
				$(".sort-by-popularity").removeClass('active');
				$(".sort-by-pricelowtohigh").addClass('active');
			</c:when>
			<c:when test="${'PriceHighToLow' eq sortBy}">
				$(".sort-by-pricehightolow").addClass('active');
				$(".sort-by-popularity").removeClass('active');
				$(".sort-by-pricelowtohigh").removeClass('active');
			</c:when>
			<c:otherwise>
				$(".sort-by-pricehightolow").removeClass('active');
				$(".sort-by-popularity").addClass('active');
				$(".sort-by-pricelowtohigh").removeClass('active');
			</c:otherwise>
		</c:choose>
	});
	
	
		
</script>
</html>
