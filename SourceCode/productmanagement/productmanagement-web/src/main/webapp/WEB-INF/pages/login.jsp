<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	.form-signin {
	  max-width: 330px;
	  padding: 15px;
	  margin: 0 auto;
	}
	.form-signin .form-signin-heading,
	.form-signin .checkbox {
	  margin-bottom: 10px;
	}
	.form-signin .checkbox {
	  font-weight: normal;
	}
	.form-signin .form-control {
	  position: relative;
	  height: auto;
	  -webkit-box-sizing: border-box;
	     -moz-box-sizing: border-box;
	          box-sizing: border-box;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
	</style>
</head>
<body>
	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<form class="form-signin" name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
       <h2 class="form-signin-heading" style="text-align:center">LOGIN</h2>
       <label for="inputEmail" class="sr-only">Email address</label>
       <input type='text' name='username' id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
       <label for="inputPassword" class="sr-only">Password</label>
       <input type='password' name='password' id="inputPassword" class="form-control" placeholder="Password" required>
       <button class="btn btn-lg btn-primary btn-block" name="submit" type="submit"	value="submit">Sign in</button>
     </form>
</body>
<script src="<c:url value="/resources/js/jquery.js" />"/></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</html>
