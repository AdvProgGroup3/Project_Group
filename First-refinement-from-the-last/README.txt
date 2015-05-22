This is a new improvement from the previous sprint
What is the new features?
1. Already connected to the HTML
2. Included Servlet Filter
3. Included access validation system
4. Included junit test case (5 test cases)
5. We can see number of parking space ledt

How to use this program?
1. Download the files
2. Download the xampp (with tomcat). if you are using mac, please download external tomcat
3. Find tomcat-users.xml and uncomment the tomcat-users. In addition, please add command below
   <role rolename="manager"/>
   <role rolename="admin"/>
   <role rolename="manager-gui"/>
   <user username="tomcat" password="tomcat" roles="admin,manager-gui,manager"/>
4. start the tomcat, apache, mysql
5. open localhost/phpmyadmin, and import the sql file
6. open localhost:8080/manager
7. type in your username and password 
8. once you are in, scroll down to WAR fie to deploy. Choose the WAR file 'First.war' and click Deploy
9. See if there is First application in the tomcat's application list
10. Open new browser tab and open localhost:8080/First/SpacesList
11. Enjoy!


WARNING:
1. The database must be 'adprog.sql' database in this folder. it's because the other 'adprog.sql' file is error
2. It is better to use eclipse ide for Java EE developer.
3. Once you have downloaded the eclipse for Java EE developer, you have to include the servlet.api external jar from your 
   tomcat folder and also you have to include mysql-connector-java-5.1.18-bin external jar that you can find
   in this First/WebContent/WEB-INF/lib folder
4. Attention! Move the 'mysql-connector-java-5.1.18-bin' external jar in the tomcat lib. If you put it on the WEB-INF/lib folder
   it can make a memory leak (See the tomcat console. There is a warning of memory leak detection).