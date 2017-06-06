# SQLInjectionDemo

> Pre-requsite

* Java 7
* MySql 5.x
* Tomcat 7
* Eclipse

> Database Setup

* Change the database connection line as per your setup.

```
jdbc:mysql://localhost:3306/sqlinjection", "root", "root"
```

* By default, the connection string uses below configuration:

- **DB Port:** 3306
- **DB User Name:** root
- **DB User Password:** root
- **DB:** sqlinjection

* Create a table named **user_details** with two columns **username** and **password** of type VARCHAR(50).
* Insert records, sample ("gokulnath", "testpass").

> To Test:

* Deploy the project in Tomcat.
* Open the link http://localhost:8080/sqlinjection/jsp/index.jsp
* Provide credentials in login page, sample(gokulnath, testpass)

> To Test SQL Injection:

* Provide **username** as **gokulnath**
* Provide **password** as **test' OR '1'='1**

> To fix SQL Injection:

* Open LoginServlet.doPost()
* Use ```MySQLDBHelper.validateUserUsingPreparedStatement()```
* Uncomment below line:

```
boolean isUserAuthenticated = MySQLDBHelper.validateUserUsingPreparedStatement(username, password);
```

* Comment below line:

```
boolean isUserAuthenticated = MySQLDBHelper.validateUser(username, password);
```

### Author

- Gokul Nath KP
