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
@WebServlet("/test02")
public class test02 extends HttpServlet {
	private  int userId=0;
	private String areaId;
	private static ShowParkingSpace showSpaces;
	private static CheckInData checkInData;
	private static CheckIn checkIn;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test02() {
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
		
		areaId=request.getParameter("areaId");
		request.setAttribute("areaId", areaId);
		checkInData=new CheckInData(userId, Area.valueOf(areaId.toUpperCase()));
//		ShowParkingSpace showSpaces=new ShowParkingSpace(userId);
	    PrintWriter out = response.getWriter();
//		String title = 'Fasilkom UI parking system';
	    String docType = "<!DOCTYPE html> <html lang='en'><head>"+
	       "<meta charset='utf-8'>"+
	       "<title>Fasilkom UI parking system</title>"+
	       " <meta name='viewport' content='width=device-width, initial-scale=1.0'>"+
	       "<meta name='description' content=''><meta name='author' content=''>"+
	       
	     	"<!--link rel='stylesheet/less' href='less/bootstrap.less' type='text/css' /-->"
	     	+ "<!--append ‘#!watch’ to the browser URL, then refresh the page. -->"
	     	+ "<link href='css/bootstrap.min.css' rel='stylesheet'>"
	     	+ "<link href='css/style.css' rel='stylesheet'>"
	     	+ "<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->"
	     	+ "<!--[if lt IE 9]>"
	     	+ "<script src='js/html5shiv.js'></script>"
	     	+ "<![endif]-->"
	     	+ "<!-- Fav and touch icons -->"
	     	+ "<link rel='apple-touch-icon-precomposed' sizes='144x144' href='img/apple-touch-icon-144-precomposed.png'>"
	     	+ "<link rel='apple-touch-icon-precomposed' sizes='114x114' href='img/apple-touch-icon-114-precomposed.png'>"
	     	+ "<link rel='apple-touch-icon-precomposed' sizes='72x72' href='img/apple-touch-icon-72-precomposed.png'>"
	     	+ "<link rel='apple-touch-icon-precomposed' href='img/apple-touch-icon-57-precomposed.png'>"
	     	+ "<link rel='shortcut icon' href='img/favicon.png'>"
	     	+ "<script type='text/javascript' src='js/jquery.min.js'></script>"
	     	+ "<script type='text/javascript' src='js/bootstrap.min.js'></script>"
	     	+ "<script type='text/javascript' src='js/scripts.js'></script>"
	     	+ "</head>";
	     	
//	     	<!--link rel='stylesheet/less' href='less/responsive.less' type='text/css' /-->
//	     	<!--script src='js/less-1.3.3.min.js'></script-->

	     out.println(docType+"<body>"
	     		+ "<div class='row clearfix'>"
	     		+ "<div class='col-md-12 column' style='background-color:#ecf0f1'>"
	     		+ "<div class='row clearfix'>"
	     		+ "<div class='col-md-12 column'>"
	     		+ "<ul class='nav nav-pills' style='background-color:black'>"
	     		+ "<li class='active'>"
	     		+ "<a href='index.html'>HOME</a>"
	     		+ "</li>"
//	     		+ "<li class='active'>"
//	     		+ "<a href='Checkin.html'>CHECK IN</a>"
//	     		+ "</li>"
	     		+ "<li class='active pull-right'>"
	     		+ "<a href='index.html'>Logout</a></li>"
	     		+ "<li class='active pull-right'>"
	     		+ "<a href='?'>Login as Agungwy</a>"
	     		+ "</li>"
	     		+ "</ul>"
	     		+ "</div></div>"
	     		+ "<div class='row clearfix'>"
	     		+ "<div class='col-md-12 column'>"
	     		+ "<div class='carousel slide' id='carousel-922664'>"
	     		+ "<ol class='carousel-indicators'>"
	     		+ "<li data-slide-to='0' data-target='#carousel-922664'>"
	     		+ "</li>"
	     		+ "<li data-slide-to='1' data-target='#carousel-922664' class='active'>"
	     		+ "</li>"
	     		+ "<li data-slide-to='2' data-target='#carousel-922664'>"
	     		+ "</li>"
	     		+ "</ol>"
	     		+ "<div class='carousel-inner'>"
	     		+ "<div class='item'>"
	     		+ "<img alt='' src='img/fasilkom1.jpg' style='width:1600px;height:500px'/>"
	     		+ "<div class='carousel-caption'>"
	     		+ "<h4>First Thumbnail label</h4>"
	     		+ "<p>"
	     		+ "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."
	     		+ "</p>"
	     		+ "</div>"
	     		+ "</div>"
	     		+ "<div class='item active'>"
	     		+ "<img alt='' src='img/fasilkom2.jpg' style='width:1600px;height:500px'/><div class='carousel-caption'>"
	     		+ "<h4>Second Thumbnail label</h4>"
	     		+ "<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>"
	     		+ "</div></div>"
	     		+ "<div class='item'>"
	     		+ "<img alt='' src='img/fasilkom3.jpg' style='width:1600px;height:500px' />"
	     		+ "<div class='carousel-caption'>"
	     		+ "<h4>Third Thumbnail label</h4>"
	     		+ "<p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>"
	     		+ "</div></div>"
	     		+ "</div> <a class='left carousel-control' href='#carousel-922664' data-slide='prev'><span class='glyphicon glyphicon-chevron-left'></span></a> <a class='right carousel-control' href='#carousel-922664' data-slide='next'><span class='glyphicon glyphicon-chevron-right'></span></a>"
	     		+ "</div></div></div>"
	     		+ "<div class='row clearfix'><div class='col-md-12 column'><div class='row clearfix' style='margin-top:10px'>"
	     		+ "<div class='col-md-2 column'></div><div class='col-md-6 column'><div class='list-group'>");
//	     		+ "<a class='list-group-item active'>SPACES</a>");
//	     		+ "<div class='list-group-item'>Check in to spaces</div>");

	    
	     
	     		checkIn=new CheckIn(checkInData);
	     		boolean status=checkIn.checkIn();
	     		out.println("<a class='list-group-item active'><span class='badge'>14</span>SPACES</a>");
	     		request.setAttribute("checkInStatus", status);
	     		out.println("<div class='list-group-item'>" 
						 +status+"</div>");
	     
//	     Map p= (Map) showSpaces.getList().get(0);
//	     out.println("<form action=send method=GET>");
//	     out.println("<a class='list-group-item active'><span class='badge'>"+p.size()+"</span>SPACES</a>");
//	     for (int i=1; i<=p.size();i++){
//				String front="a";
//				if(i<10){
//					front+="0";
//					front+=i;
//					if(p.get(front).equals(0)){
//						
//						out.println("<div class='list-group-item'>" 
//								+"Area ID: "+front+"<br/></br>"
//								+ "Status: Empty"
//								+"</div>");
//					}
//				}
//				else{
//					front+=i;
//					if(p.get(front).equals(0)){
//						
//						out.println("<div class='list-group-item'>" 
//								+"Area ID: "+front+"<br/></br>"
//								+ "Status: Empty"
//								+"</div>");
//					}
//				}
//			}
	     
	     
	     
	     
	     
	     
	     out.println("<div class='list-group-item'><span class='badge'>14</span>Help</div>"
//	    		+ "</form>"
	     		+ "<a class='list-group-item active'><span class='badge'>14</span>Help</a></div></div>"
	     		+ "<div class='col-md-4 column'></div></div></div></div>"
	     		+ "<div class='row clearfix' style='background-color:black;margin-top:10px;margin-left:0px;margin-right=0px'>"
	     		+ "<div class='col-md-8 column' style='color:white;margin-top:10px'>"
	     		+ " <address> <strong>FASILKOM UI</strong><br /> Universitas Indonesia <br /> Depok, Indonesia<br /> <abbr title='Phone'>P:</abbr> 081316477140</address>"
	     		+ "</div><div class='col-md-4 column' style='color:white'>"
	     		+ "<blockquote><p>Made By Group 3</p> <small>Agung Wirayogi <cite>1306439094</cite></small>"
	     		+ "<small>Daniel Manurung <cite>1306439106</cite></small>"
	     		+ "<small>Izhar Almizan <cite>NPM</cite></small>"
	     		+ "<small>Nauval Adiyasa <cite>NPM</cite></small>"
	     		+ "<small>William Henry <cite>NPM</cite></small>"
	     		+ "</blockquote></div></div></div>"
	     		+ "</div></body></html>"

	     
);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}

