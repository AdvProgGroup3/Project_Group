<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Fasilkom UI parking system</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append â€ک#!watchâ€™ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>

<body>

	<div class="row clearfix">
		<div class="col-md-12 column" style="background-color:#ecf0f1">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<ul class="nav nav-pills" style="background-color:black">
						<li class="active">
							<a href="LoginSuccess.jsp">HOME</a>
						</li>
						<li class="active pull-right">
							<a href="#">Register</a>
						</li>
						<li class="active pull-right">
							<form action="LogoutServlet" method="post">
								<input type="submit" class="btn btn-primary" value="Logout" >
							</form>
						</li>
						<li class="active pull-right">
						<%
										//allow access only if session exists
										String user = (String) session.getAttribute("user");
										String userName = null;
										String sessionID = null;
										String id=null;
										String role=null;
										String faculty=null;
										Cookie[] cookies = request.getCookies();
										if(cookies !=null){
										for(Cookie cookie : cookies){
										    if(cookie.getName().equals("user")) userName = cookie.getValue();
										    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
										    if(cookie.getName().equals("id")) id=cookie.getValue();
										    if(cookie.getName().equals("role")) role=cookie.getValue();
										    if(cookie.getName().equals("faculty")) faculty=cookie.getValue();
										}
										}
									%>
							<a href="#">Login as <%=user %></a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="carousel slide" id="carousel-922664">
						<ol class="carousel-indicators">
							<li data-slide-to="0" data-target="#carousel-922664">
							</li>
							<li data-slide-to="1" data-target="#carousel-922664" class="active">
							</li>
							<li data-slide-to="2" data-target="#carousel-922664">
							</li>
						</ol>
						<div class="carousel-inner">
							<div class="item">
								<img alt="" src="img/fasilkom1.jpg" style="width:1600px;height:500px"/>
								<div class="carousel-caption">
									<h4>
										First Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
							<div class="item active">
								<img alt="" src="img/fasilkom2.jpg" style="width:1600px;height:500px"/>
								<div class="carousel-caption">
									<h4>
										Second Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="img/fasilkom3.jpg" style="width:1600px;height:500px" />
								<div class="carousel-caption">
									<h4>
										Third Thumbnail label
									</h4>
									<p>
										Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
									</p>
								</div>
							</div>
						</div> <a class="left carousel-control" href="#carousel-922664" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-922664" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
				</div>
			</div>
			<div class="row clearfix" style="margin-top:10px">
				<div class="col-md-12 column">
					<div class="row clearfix">
						<div class="col-md-2 column">
						</div>
						<div class="col-md-6 column">
							<form role="form" action="RegisterServletMaster" method="get">
								<div class="form-group">
									 <label for="exampleInputEmail1">NPM</label><input class="form-control" id="exampleInputEmail1" type="text" name="inputnpm" maxlength="10" minlength="10" pattern="[0-9]+" required/>
								</div>
								<div class="form-group">
									 <label for="exampleInputEmail1">Username</label><input class="form-control" id="exampleInputEmail1" type="name" name="inputusername" pattern="[A-Za-z-0-9]+" required/>
								</div>
								<div class="form-group">
									 <label for="exampleInputPassword1">Password</label><input class="form-control" id="exampleInputPassword1" type="password" name="inputpassword" pattern="[A-Za-z-0-9]+" required/>
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>
						</div>
						<div class="col-md-4 column">
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix" style="background-color:black;margin-top:10px;margin-left:0px;margin-right=0px">
				<div class="col-md-8 column" style="color:white;margin-top:10px">
					 <address> <strong>FASILKOM UI</strong><br /> Universitas Indonesia <br /> Depok, Indonesia<br /> <abbr title="Phone">P:</abbr> 081316477140</address>
				</div>
				<div class="col-md-4 column" style="color:white">
					<blockquote>
						<p>
							Made By Group 3
						</p> <small>Agung Wirayogi <cite>1306439094</cite></small>
						<small>Daniel Manurung <cite>1306439106</cite></small>
						<small>Izhar Almizan <cite>NPM</cite></small>
						<small>Nauval Adiyasa <cite>NPM</cite></small>
						<small>William Henry <cite>NPM</cite></small>
					</blockquote>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
