
Prerequisites:
-------------------
- Eclipse
- JDK 1.7 
- Maven

Building project
---------------
Go to directory \GoEuroTest
and run the following command in command prompt

  >> mvn clean install
  
  
Deploying App
---------------
Once build is completed, deploy GoEuroTest.jar file located at \GoEuroTest\target\  on any location. i.e c:\test

Running the jar
--------------
java -jar GoEuroTest.jar berlin 

Output
-------
city.csv file will be generated with city details on the same file location . 


Options:-
 You can change the output file name and web service URL by updating \GoEuroTest\src\main\resources\GoEuro.properties file.
 
 Setting up in Eclipse:-
 ---------------------

1. Prerequisites:

- Eclipse
- JDK 1.7 
- Maven

2. Open Eclipse and choose File-->Import-->Existing Maven Projects 
3. Select into GoEuroTest\pom.xml

 