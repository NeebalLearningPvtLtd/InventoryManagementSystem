# InventoryManagementSystem
> Rest based Inventory Management System build on Spring Boot Framework 
## Setup
* Clone the Repository
 ```shell
 git clone --recursive https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem.git
 ```
* Import in eclipse
 <code>File > import > General > Projects from Folder or Archive </code>
* Init DB Schema
  * locate init.py in src/main/resources/database_files/
  * run init.py
  ```shell
   python3 init.py
  ```
## Description
 * This is the code to create an Inventory management automated system for Kossine's physical classrooms .
 * Design pattern used is M ~V~ C of spring boot's starter web .
 > <b>Note</b> : Views are not done yet .
 * Controller's can be found [here](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/tree/master/src/main/java/com/kossine/ims/controllers) , 
 paging support is also added can be accessed using
 ``` html
  http://domain/controller_mapping/get/all?page=0&size=50
 ``` 
 it fetches first 50 rows from first slot , for next slot page=1 and so-on
 > <b>Note</b> size can be varied 
 
 * Complete controller code for say Model [Laptop](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/models/Laptop.java) can be found [here](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/controllers/LaptopController.java) which contains all the Request mappings for 
        <code>GET , POST , PUT ,DELETE </code> is done .
    
 * Exception handling of Api is done using <code> @RestControllerAdvice </code>  annotation , code can be found [here](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/exceptions/CustomRestExceptionHandler.java)
 * Hibernate framework was used for DAO layer and was implemented using JPA standards as well as spring data JPA .
    * JPA's EntityManager way used in [GenericRepo](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/repository/GenericRepo.java) , [LaptopRepo](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/repository/LaptopRepo.java) , [AdapterRepo](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/repository/AdapterRepo.java) 
 
    * Spring Data Jpa was used in [LaptopUsedByRepo](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/repository/LaptopUsedByRepo.java) , [AdapterUsedByRepo](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/src/main/java/com/kossine/ims/repository/AdapterUsedByRepo.java)
    
 * Inventory is abstract class for all the inventories .
 * Testing was done using Junit 4 and  <code>@SpringBootTest</code> annotation provided by spring boot 
 > <b> Note </b> : H2 Inmemory Db was used during testing , but some queries were incompatible with H2 that runs with no problem in MySql/MariaDb
 ## dependency
 > see [pom.xml](https://github.com/NeebalLearningPvtLtd/InventoryManagementSystem/blob/master/pom.xml) 
 ## sub-modules
 > [Excel-to-POJO](https://github.com/NeebalLearningPvtLtd/Excel-to-POJO) was used for maping excel data to POJO's found in models package
