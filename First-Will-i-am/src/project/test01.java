package project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;



/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/test01")
public class test01 extends HttpServlet {
	private  int userId=0;
	private String areaId;
	private static ShowParkingSpace showSpaces;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test01() {
        super();
        // TODO Auto-generated constructor stub
        showSpaces=new ShowParkingSpace(userId);
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
//		request.setAttribute("user_id", userId);
//		request.setAttribute("checkInStatus", false);
//		request.setAttribute("areaId", null);
//		ShowParkingSpace showSpaces=new ShowParkingSpace(userId);
	    PrintWriter out = response.getWriter();
//		String title = 'Fasilkom UI parking system';
//	    if((((boolean) request.getSession().getAttribute("checkInStatus"))==false)&& 
//	    		 (request.getSession().getAttribute("areaid")==null)){
//	    String docType = "<!DOCTYPE html> <html lang='en'><head>"+
//	       "<meta charset='utf-8'>"+
//	       "<title>Fasilkom UI parking system</title>"+
//	       " <meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
//	       "<meta name='description' content=''><meta name='author' content=''>"+
//	       
//	     	"<!--link rel='stylesheet/less' href='less/bootstrap.less' type='text/css' /-->"
//	     	+ "<!--append ‘#!watch’ to the browser URL, then refresh the page. -->"
//	     	+ "<link href='css/bootstrap.min.css' rel='stylesheet'>"
//	     	+ "<link href='css/style.css' rel='stylesheet'>"
//	     	+ "<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->"
//	     	+ "<!--[if lt IE 9]>"
//	     	+ "<script src='js/html5shiv.js'></script>"
//	     	+ "<![endif]-->"
//	     	+ "<!-- Fav and touch icons -->"
//	     	+ "<link rel='apple-touch-icon-precomposed' sizes='144x144' href='img/apple-touch-icon-144-precomposed.png'>"
//	     	+ "<link rel='apple-touch-icon-precomposed' sizes='114x114' href='img/apple-touch-icon-114-precomposed.png'>"
//	     	+ "<link rel='apple-touch-icon-precomposed' sizes='72x72' href='img/apple-touch-icon-72-precomposed.png'>"
//	     	+ "<link rel='apple-touch-icon-precomposed' href='img/apple-touch-icon-57-precomposed.png'>"
//	     	+ "<link rel='shortcut icon' href='img/favicon.png'>"
//	     	+ "<script type='text/javascript' src='js/jquery.min.js'></script>"
//	     	+ "<script type='text/javascript' src='js/bootstrap.min.js'></script>"
//	     	+ "<script type='text/javascript' src='js/scripts.js'></script>"
//	     	+ "</head>";
//	     	
////	     	<!--link rel='stylesheet/less' href='less/responsive.less' type='text/css' /-->
////	     	<!--script src='js/less-1.3.3.min.js'></script-->
//
//	     out.println(docType+"<body>"
//	     		+ "<div class='row clearfix'>"
//	     		+ "<div class='col-md-12 column' style='background-color:#ecf0f1'>"
//	     		+ "<div class='row clearfix'>"
//	     		+ "<div class='col-md-12 column'>"
//	     		+ "<ul class='nav nav-pills' style='background-color:black'>"
//	     		+ "<li class='active'>"
//	     		+ "<a href='index.html'>HOME</a>"
//	     		+ "</li>"
////	     		+ "<li class='active'>"
////	     		+ "<a href='Checkin.html'>CHECK IN</a>"
////	     		+ "</li>"
//	     		+ "<li class='active pull-right'>"
//	     		+ "<a href='index.html'>Logout</a></li>"
//	     		+ "<li class='active pull-right'>"
//	     		+ "<a href='?'>Login as Agungwy</a>"
//	     		+ "</li>"
//	     		+ "</ul>"
//	     		+ "</div></div>"
//	     		+ "<div class='row clearfix'>"
//	     		+ "<div class='col-md-12 column'>"
//	     		+ "<div class='carousel slide' id='carousel-922664'>"
//	     		+ "<ol class='carousel-indicators'>"
//	     		+ "<li data-slide-to='0' data-target='#carousel-922664'>"
//	     		+ "</li>"
//	     		+ "<li data-slide-to='1' data-target='#carousel-922664' class='active'>"
//	     		+ "</li>"
//	     		+ "<li data-slide-to='2' data-target='#carousel-922664'>"
//	     		+ "</li>"
//	     		+ "</ol>"
//	     		+ "<div class='carousel-inner'>"
//	     		+ "<div class='item'>"
//	     		+ "<img alt='' src='img/fasilkom1.jpg' style='width:1600px;height:500px'/>"
//	     		+ "<div class='carousel-caption'>"
//	     		+ "<h4>First Thumbnail label</h4>"
//	     		+ "<p>"
//	     		+ "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."
//	     		+ "</p>"
//	     		+ "</div>"
//	     		+ "</div>"
//	     		+ "<div class='item active'>"
//	     		+ "<img alt='' src='img/fasilkom2.jpg' style='width:1600px;height:500px'/><div class='carousel-caption'>"
//	     		+ "<h4>Second Thumbnail label</h4>"
//	     		+ "<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>"
//	     		+ "</div></div>"
//	     		+ "<div class='item'>"
//	     		+ "<img alt='' src='img/fasilkom3.jpg' style='width:1600px;height:500px' />"
//	     		+ "<div class='carousel-caption'>"
//	     		+ "<h4>Third Thumbnail label</h4>"
//	     		+ "<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>"
//	     		+ "</div></div>"
//	     		+ "</div> <a class='left carousel-control' href='#carousel-922664' data-slide='prev'><span class='glyphicon glyphicon-chevron-left'></span></a> <a class='right carousel-control' href='#carousel-922664' data-slide='next'><span class='glyphicon glyphicon-chevron-right'></span></a>"
//	     		+ "</div></div></div>"
//	     		+ "<div class='row clearfix'><div class='col-md-12 column'><div class='row clearfix' style='margin-top:10px'>"
//	     		+ "<div class='col-md-2 column'></div><div class='col-md-6 column'><div class='list-group'>");
//	     		+ "<a class='list-group-item active'>SPACES</a>");
//	     		+ "<div class='list-group-item'>Check in to spaces</div>");

	    
//	    Object data = "Some data, can be a String or a Javabean";

	     
	     
	     Map p= (Map) showSpaces.getList().get(0);
	    
	     Object data="<form action=test02 method=GET >"
	     		+ "<a class='list-group-item active'><span class='badge'>"+p.size()+"</span>SPACES</a>";
	     		
//	     out.println();
//	     out.println(request.getSession().getAttribute("checkInStatus"));
//	     out.println(request.getSession().getAttribute("area_id"));
//	     out.println(request.getSession().getAttribute("user_id"));
	     for (int i=0; i<=12;i++){
	    	 try{
				String front="a";
				if(i<10){
					front+="0";
					front+=i;
					int value=(int) p.get(front);
					if(value==0){
						
						data+="<div class='list-group-item'>" 
								+ "Area ID: "+front+"<br/></br>"
								+ "Status: Empty"
								+ "<br/>"
								+ "<br/>"
								+ "<button type='submit' name='areaId' value='"+front+"'>Check In</button>"
								+ "</div>";
					}
					
				}
				else{
					front+=i;
					int value=(int) p.get(front);
					if(value==0){
						
						data+="<div class='list-group-item'>" 
								+ "Area ID: "+front+"<br/></br>"
								+ "Status: Empty"
								+ "<br/>"
								+ "<br/>"
								+ "<button type='submit' name='areaId' value='"+front+"'>Check In</button>"
								+ "</div>";
					}
				}
			} catch(Exception e){
				
			}
	     }
		    request.setAttribute("data", data);
		    request.getRequestDispatcher("/Checkin.jsp").forward(request, response);
//	     }else{
////	    	 String site = new String();
////
////	         response.setStatus(response.SC_MOVED_TEMPORARILY);
////	         response.setHeader("Location", site);
////	         
//	         
//	         String newURL = response.encodeRedirectURL("http://localhost:8080/First/test02?areaId="
//		    	 		+ request.getSession().getAttribute("areaId"));
//	         response.sendRedirect(newURL);
//	     }
	     
	     
	     
	     
	     
	     
	     
//	     out.println("<div class='list-group-item'><span class='badge'>14</span>Help</div>"
//	    		+ "</form>"
//	     		+ "<a class='list-group-item active'><span class='badge'>14</span>Help</a></div></div>"
//	     		+ "<div class='col-md-4 column'></div></div></div></div>"
//	     		+ "<div class='row clearfix' style='background-color:black;margin-top:10px;margin-left:0px;margin-right=0px'>"
//	     		+ "<div class='col-md-8 column' style='color:white;margin-top:10px'>"
//	     		+ " <address> <strong>FASILKOM UI</strong><br /> Universitas Indonesia <br /> Depok, Indonesia<br /> <abbr title='Phone'>P:</abbr> 081316477140</address>"
//	     		+ "</div><div class='col-md-4 column' style='color:white'>"
//	     		+ "<blockquote><p>Made By Group 3</p> <small>Agung Wirayogi <cite>1306439094</cite></small>"
//	     		+ "<small>Daniel Manurung <cite>1306439106</cite></small>"
//	     		+ "<small>Izhar Almizan <cite>NPM</cite></small>"
//	     		+ "<small>Nauval Adiyasa <cite>NPM</cite></small>"
//	     		+ "<small>William Henry <cite>NPM</cite></small>"
//	     		+ "</blockquote></div></div></div>"
//	     		+ "</div></body></html>"
//
//	     
//);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}

