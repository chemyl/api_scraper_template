## api-response scraper ###
* SpringBoot
* Java 11
* Maven
* Apache POI
* Rest-Assured
* Lombok
* Log4j
### functionalities
* Scheduled
* Store URLs in application.properties
* ApiController sends prepared CRUD request to API 
* Response schema validation
* DataStorageImpl convert Response to POJO
* Create XLSX or find existed file in project dir 
* Add new row of POJO Data to the end of the file.

### how to run
* Create Maven project
* Add dependencies
* Configure project directories
* Start as SpringBoot Application
  * Save as .jar file
  * Create Docker Image
  * Run as Docker Container
