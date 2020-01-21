<%@page import="pojos.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojos.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>foster web</title>
</head>
<body>

	<div class="container">
		<header>
			<div id="carouselExampleControls" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/slider1.png" class="d-block w-100" alt="slider1">
					</div>
					<div class="carousel-item">
						<img src="img/slider2.png" class="d-block w-100" alt="slider2">
					</div>
					<div class="carousel-item">
						<img src="img/slider3.png" class="d-block w-100" alt="slider3">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleControls"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleControls"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</header>
		<%
			ArrayList<Categoria> categorias = (ArrayList<Categoria>) session.getAttribute("categorias");
			
			
		%>
		
		<div class="row">
			<%
				for (Categoria categoria : categorias) {
			%>
			<div class="col-lg-4">
				<a href="Controller?op=dameproductos&idcat=<%=categoria.getId()%>">
					<div class="card">

						<div class="card-body" style="text-align: center;">
							<img src="img/<%=categoria.getNombre()%>.png"
								class="card-img-top" alt="">
							<p class="card-text"><%=categoria.getNombre()%></p>
						</div>

					</div>
				</a>
			</div>
			<%
				}
			%>
		</div>
		
	</div>
	<footer class="container px-10">
		<h1 class="text-center bg-warning text-white py-2 my-0">Foster
			Hollywood</h1>
	</footer>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>