<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<title>Rakuten Product Management Application</title>
	<style type="text/css">
	body {
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #eee;
	}
	</style>
</head>
<body>
	<form:form id="productDetail" class="form-horizontal" method="post" modelAttribute="productForm">
	<div class="container">
		<div class="row bg-success txt-success">
			<div class="col-md-12" style="border:1px solid black;text-align:center;border-radius:10px">
				<h2 class="text-error text-uppercase">Rakuten Product Management System</h2>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row">
			<div class="col-md-8" style="border:0px solid black;text-align:left;">
				<h3>
					<c:forTokens items="${product.categoryPath}" delims="/" var="name">
					   <span class="label label-default text-uppercase" style="margin-right:15px;"><c:out value="${name}"/></span>/
					</c:forTokens>
				</h3>
			</div>
			<div class="col-md-4" style="border:0px solid black;text-align:right">
				<a href="<c:url value="/"/>" class="btn btn-warning btn-sm glyphicon glyphicon-home" role="button"></a>
				<security:authorize ifAnyGranted="ROLE_SUPERUSER">
					<a href="<c:url value="/productdetail/-1" />" class="btn btn-warning btn-sm glyphicon glyphicon-plus add-product" role="button" title="Add Product"></a>
					<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-success btn-sm active text-uppercase" role="button"><strong>Logout</strong></a>
				</security:authorize>
				<security:authorize ifAnyGranted="ROLE_USER">
					<a href="<c:url value="/j_spring_security_logout" />" class="btn btn-success btn-sm active text-uppercase" role="button"><strong>Logout</strong></a>
				</security:authorize>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row" style="padding-right:1%;padding-left:5%;">
			<div class="col-md-3">&nbsp;</div>
			<div class="col-md-6" style="border:1px solid black;text-align:center;padding-bottom:10px;border-radius:7px;">
				<img class="img-responsive center-block" src="<c:url value="/resources/img/tag.png" />" alt="" style="width:200px;height:200px;">
			</div>
			<div class="col-md-3">&nbsp;</div>
		</div>
		<div class="row">&nbsp;</div>
		<div class="row product-detail-label" style="padding-right:1%;padding-left:5%;">
			<div class="col-md-12" style="border:1px solid black;text-align:center;padding-bottom:10px;border-radius:7px">
				<h3><c:out value="${product.name}"/></h3>
				<h4><c:out value="${product.description}"/></h4>
				<h5><c:out value="${product.price}"/></h3>
			</div>
		</div>
		<div class="row product-detail" style="padding-right:1%;padding-left:5%;">
			<div class="col-md-12" style="border:1px solid black;text-align:center;padding-bottom:10px;border-radius:7px">
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-md-1">&nbsp;</div>
					<div class="col-md-10"><input type="text" name="name" maxlength="100" class="form-control" value="<c:out value="${product.name}"/>" placeholder="Product Name" title="Product Name"></input></div>
					<div class="col-md-1">&nbsp;</div>	
				</div>
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-md-1">&nbsp;</div>
					<div class="col-md-10"><textarea name="description" class="form-control" value="<c:out value="${product.description}"/>" placeholder="Description" title="Description"></textarea></div>
					<div class="col-md-1">&nbsp;</div>
				</div>
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-md-1">&nbsp;</div>
					<div class="col-md-10">
						<input type="text" id="txtPrice" name="price" class="form-control" value="<c:out value="${product.price}"/>" placeholder="Price" title="Price"></input>
						<label id="errPrice"></label>
					</div>
					<div class="col-md-1">&nbsp;</div>	
				</div>
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-md-1">&nbsp;</div>
					<div class="col-md-10"><input type="text" maxlength="200" name="categoryPath" class="form-control" value="<c:out value="${product.categoryPath}"/>" placeholder="Category Path" title="Category Path"></input></div>
					<div class="col-md-1">&nbsp;</div>	
				</div>
				<div class="row">&nbsp;</div>
				<div class="row">
					<div class="col-md-1">&nbsp;</div>
					<div class="col-md-10">
						<input type="text" id="txtPopularity" name="popularity" class="form-control" value="<c:out value="${product.popularity}"/>" placeholder="Popularity" title="Popularity" required></input>
					</div>
					<div class="col-md-1">&nbsp;</div>	
				</div>
				<input name="id" type="hidden" value='<c:out value="${product.id}"/>'></input>
			</div>
		</div>
		<div class="row">&nbsp;</div>
		<security:authorize ifAnyGranted="ROLE_SUPERUSER">
			<div class="row" style="padding-right:1%;padding-left:5%;">
				<div class="col-md-5">&nbsp;</div>
				<div class="col-md-1" style="border:0px solid black;text-align:center;padding-bottom:10px;border-radius:7px">
					<button type="reset" class="btn btn-warning btn-sm glyphicon glyphicon-repeat cancel" title="Cancel"></button>
					<button type="button" class="btn btn-warning btn-sm glyphicon glyphicon-pencil edit-product" title="Edit"></button>
				</div>
				<div class="col-md-1" style="border:0px solid black;text-align:center;padding-bottom:10px;border-radius:7px">
					<!--  <a href="<c:url value="/productsave/" />" class="btn btn-warning btn-sm glyphicon glyphicon-save" role="button" title="Save"></a>-->
					<button type="button" class="btn btn-warning btn-sm glyphicon glyphicon-save save-product" title="Save"></button>
				</div>
				<div class="col-md-5">&nbsp;</div>
			</div>
		</security:authorize>
		
	</div>
	</form:form>
</body>
<script src="<c:url value="/resources/js/jquery.js" />"/></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
	$( document ).ready(function() {
		$(".cancel").hide();
		$(".product-detail").toggle();
		$(".edit-product").click(function(){
			$(".product-detail").toggle();
			$(".product-detail-label").toggle();
		});
		
		$(".save-product").click(function(){
			var popularity = $('#txtPopularity').val();
			var numericValue = /[^0-9]/g;    
			if ( numericValue.test(popularity) ){  
			    alert('Please enter a numeric value in Popularity');
			    return false;
			}
			
			var price = $('#txtPrice').val();
			var decimalValue = /[^0-9.]/g;    
			if ( decimalValue.test(price) ){  
			    alert('Please enter a numeric value in Price');
			    return false;
			}
			
			$("#productDetail").attr("action",'<c:url value="/product" />'); 
			$("#productDetail").submit();
		});
		
		<c:if test="${null eq product.id}">
			$(".edit-product").click();
			$(".edit-product").hide();
			$(".cancel").show();
		</c:if>
		
		
	});
</script>
</html>
