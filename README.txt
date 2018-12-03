1. What do you need to run this app:

 - JDK 1.8;
 - Apache Maven 3.6.0;
 - IntelliJ IDEA (or other IDE);
 - Mongodb 2008plus ssl 4.0.4;
 - Mongo Java driver 3.9.0;
 - Postman 6.5.2;
 - Robomongo studio-3t (optional).

2. Open project "BlogserverApp" with IntelliJ IDEA (or other IDE);
in "application.properties" you can set a name of your DataBase;
current DB name is setted there via parametr "spring.data.mongodb.database = webappdb".

3. Run "BlogsererApp.java";
Now our server app is running.

4. Launch Postman and import the file "BlogServerRequests.postman_collection.json".

5. Open request "BlogServerRequests -> Users -> Create New User".
In request's Body you can enter new user's name and his/her password.
After you send the request, server will create a record in "User" Collection of "webappdb" database.

6. In Users folder there are such templates of requests as "Show All users", "Edit the User" and etc.
To make your request edit parameters in request's Body.

7. Open request "BlogServerRequests -> Posts -> Create New Post".
In request's Body you can enter new post (message) and its autor's id (from Users collection).
After you send the request, server will create a record in "Posts" Collection of "webappdb" database.

6. In Posts folder there are such templates of requests as "Show All posts", "Show the post (by post' id)", "Edit the Post" and etc.
To make your request edit parameters in request's Body.