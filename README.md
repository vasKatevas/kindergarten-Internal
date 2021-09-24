# kindergarten internal system  

## UML Class Diagram

![class diagram](/images/ClassDiagram.jpg "class diagram")

## Website Screenshot

![manager environment](/images/manager.png "manager environment")

## Requirements

 - java 11
 - mysql ( tested on version 5.7.33 )
 - [kindergarten-External](https://github.com/vasKatevas/kindergarten-External) for receiving applications

## Execution 
edit src/main/resources/application.properties for mysql information

 ```bash  
./mvnw package
java -jar target/Internal-system-0.0.1-SNAPSHOT.jar
 ```
## Deploy

 For deployment options visit [kindergarten-Deploy](https://github.com/vasKatevas/kindergarten-Deploy)
