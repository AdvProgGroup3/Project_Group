<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!doctype html>

<html>
	<head>
		
		<title>Fasilkom UI parking system</title>
		<link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="jquery.seat-charts-master.css">
	  	<link rel="stylesheet" type="text/css" href="style.css">
	    <meta charset="utf-8">
  
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
		<div class="wrapper">
			<div class="container">
				<div id="seat-map">
					<div class="front-indicator">Front</div>
					
				</div>
				<div class="booking-details">
					<h2>Booking Details</h2>
					
					<h3> Selected Seats (<span id="counter">0</span>):</h3>
					<ul id="selected-seats"></ul>
					
					
					<form action="BookServlet" action="GET">
					<button class="checkout-button" name=areaId >Checkout &raquo;</button>
					</form>
					<div id="legend"></div>
				</div>
			</div>
		</div>
		
		<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
		<script src="jquery.seat-charts.js"></script>
		
		<script>
			var firstSeatLabel = 1;
			
			var notAvailable=<%=
					(List)request.getAttribute("data2")%>;
					
					var c=[];
		            
		            
		            for ( i=0; i<notAvailable.length;i++){
		                alert(parseInt(notAvailable[i].slice(-2)));
		                if(parseInt(notAvailable[i].slice(-2))<5){
		                
		                    c.push("1_"+parseInt(notAvailable[i].slice(-2)));
		                }else if(parseInt(notAvailable[i].slice(-2))<9 && parseInt(notAvailable[i].slice(-2))>=5){
		                    c.push("2_"+(parseInt(notAvailable[i].slice(-2))-4));
		                }else{
		                    c.push("3_"+(parseInt(notAvailable[i].slice(-2))-8));
		                }
		            }
			$(document).ready(function() {
				var $cart = $('#selected-seats'),
					$counter = $('#counter'),
					$total = $('#total'),
					sc = $('#seat-map').seatCharts({
					map: [
						'ffff',
						'ffff',
						'ffff'
					],
					seats: {
						f: {
							
							classes : 'first-class', //your custom CSS class
							category: 'First Class'
						},
						e: {
							
							classes : 'economy-class', //your custom CSS class
							category: 'Economy Class'
						}					
					
					},
					naming : {
						top : false,
						getLabel : function (character, row, column) {
							return firstSeatLabel++;
						},
					},
					legend : {
						node : $('#legend'),
					    items : [
							[ 'f', 'available',   'Parking Spot' ],
							[ 'f', 'unavailable', 'Already Booked']
					    ]					
					},
					click: function () {
						if (this.status() == 'available'&& sc.find('selected').length==0) {
                            alert(sc.find('selected').length);
							//let's create a new <li> which we'll add to the cart items
							$('<li>'+this.data().category+' Seat # '+this.settings.label+'<a href="#" class="cancel-cart-item">[cancel]</a></li>')
								.attr('id', 'cart-item-'+this.settings.id)
								.data('seatId', this.settings.id)
								.appendTo($cart);
							alert(this.settings.label);
							if(parseInt(this.settings.label)<10){
                            	$("button").val("a0".concat(this.settings.label));
						}else{
							$("button").val("a".concat(this.settings.label));
						}
							/*
							 * Lets update the counter and total
							 *
							 * .find function will not find the current seat, because it will change its stauts only after return
							 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
							 */
							$counter.text(sc.find('selected').length+1);
//							$total.text(recalculateTotal(sc)+this.data().price);
							
							return 'selected';
						} else if (this.status() == 'selected') {
							//update the counter
							$counter.text(sc.find('selected').length-1);
							//and total
//							$total.text(recalculateTotal(sc)-this.data().price);
						
							//remove the item from our cart
							$('#cart-item-'+this.settings.id).remove();
						
							//seat has been vacated
							return 'available';
						} else if (this.status() == 'unavailable') {
							//seat has been already booked
							return 'unavailable';
						} else {
							return this.style();
						}
					}
				});

				//this will handle "[cancel]" link clicks
				$('#selected-seats').on('click', '.cancel-cart-item', function () {
					//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
					sc.get($(this).parents('li:first').data('seatId')).click();
				});

				//let's pretend some seats have already been booked
				sc.get(c).status('unavailable');
	
		});

//		function recalculateTotal(sc) {
//			var total = 0;
//		
//			//basically find every selected seat and sum its price
//			sc.find('selected').each(function () {
//				total += this.data().price;
//			});
//			
//			return total;
//		}
		
		</script>
		
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
