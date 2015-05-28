<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Fasilkom UI parking system</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <META Http-Equiv="Cache-Control" Content="no-cache">
<META Http-Equiv="Pragma" Content="no-cache">
<META Http-Equiv="Expires" Content="0"> 

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
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
							<a href="index.html">HOME</a>
						</li>
						
						<!--  <li class="active">
							<a href="Checkin.html">CHECK IN</a>
						</li>-->
						<li class="active pull-right">
							<a href="index.html">Logout</a>
						</li>
						<li class="active pull-right">
							<a href="?">Login as Agungwy</a>
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
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row clearfix" style="margin-top:10px">
						<div class="col-md-2 column">
						</div>
						<div class="col-md-6 column">
							<div class="list-group">
								<br>
								<br>
					
								<h2>Admin Account Manager</h2>
								<br>
								<br>
								
								<form action="DeleteAccount" method="get">
									<div class="form-group">
									 <label for="exampleInputEmail1">Username</label>
									 <input class="form-control" id="exampleInputEmail1" type="text" name="inputusername"/>
								</div>
									<button type="submit" class="btn btn-info" >Search</button>
								</form>
								<br>
								<br>
								<form action="DeleteAccount" method="get">
								<table>
									<tr>
										<td>ID</td>
										<td>Username</td>
										<td>Faculty</td>
										<td></td>
									</tr>
								<%
								if(request.getAttribute("list")!=null){
									List list=(List)request.getAttribute("list");
									if(list.size()>0){
										for (int i=0; i<list.size();i++){
											List list2=(List)list.get(i);
											out.println("<tr>");
											int number=0;
											for(int j=0; j<list2.size();j++){
												
												if(list2.get(j) instanceof Integer){
													number=(Integer)list2.get(j);
												}
												out.println("<td>"+list2.get(j)+"</td>");
												}
												out.println("<td>"+"<button type='submit' class='btn btn-danger' name='deleteId' value="+number+">Delete</button> "+"</td>");
											
											out.println("</tr>");
										}
									}
								}
								

								%>
								</table>
								</form>
								<br>
								<br>
								<a class="btn btn-primary" href="SpacesList" role="button">Check In</a>
							</div>
						</div>
						<div class="col-md-4 column">
						</div>
					</div>
				</div>
			</div>
			<div class="row clearfix" style="background-color:black;margin-top:10px;margin-left:0px;margin-right:0px">
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
