FSE is a flight search engine application which intially reads the set of flights
info from a csv file and put the records in  postgres.

#FSE operations:
* Search By Name
* Search By Airlines
* Search By Price Range
* Search By No of stops

 
#Requirements: 

* JDK : 12
* Maven https://maven.apache.org/install.html
* Postgress

#How To Run The Project
* Download the repo
* Move to the project
    * Example: Lets say my download path ~/Downloads, you should move inside FSE before running proejct
    * Path: cd ~/Downloads/FSE
* To Install the dependencies:
 
        mvn install
  
* Compile the project: 
    
         mvn clean compile
    
* To Run  the application

         mvn package exec:java  -Dexec.args="postgress_host databasename username password"

   ####Note: You need to provide db details while running the project
   * Example:
    
           mvn package exec:java  -Dexec.args="localhost:5432 fse alti 123"
    postgress_host = localhost:5432
    
    databasename= fse
    
    username = alti
    
    password = 123