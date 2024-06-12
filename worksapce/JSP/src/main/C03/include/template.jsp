<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<style>
		*{margin :5px;}
		header{
			height : 100px; border:1px solid;
		}
		main{
			height:500px; border : 1px solid;
		}
		footer{
			height : 300px; border : 1px solid;
		}
	</style>
<body>

	
	<div class="wrapper">
		<header>
			<%@include file="fragments/topHeader.jsp" %>
			<%@include file="fragments/nav.jsp" %>
		</header>
		<main>
			<section></section>
			<section></section>
			<section></section>
		</main>
		<%@include file="fragments/footer.jsp" %>
	</div>

</body>
</html>