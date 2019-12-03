# casestudy
This repository contains a maven project which is based on B2C company requirement.

This project is an SpringBoot app which is using h2 databse in the backend.

I have inserted the dummy data in h2 database by using following files
src/main/resources/schema.sql
src/main/resources/data.sql

I have created three tables in schema.sql:
PRODUCTS
SELLERS
PRODUCTS_SELLERS

Following is the main contoller class of Project
src/main/java/com/xyz/casestudy/controller/ProductsCatalogueController.java

This project also has caching enabled in it.
Cache is also scheduled to be refreshed in 2 hous and with evey update and delete.Caching is enabled in following class
src/main/java/com/xyz/casestudy/cache/ProductsCatalogueService.java

To Run this project on your local mahine you need to download it and then run the following command from command prompt:

mvnw clean spring-boot:run

above command will start the rest api on http://localhost:8080/

Please find the details of end points in the rest API below:

1. http://localhost:8080/
This endpoint will fetch all the product details and return a json.

2.http://localhost:8080/findBySKU/skuId/{skuId}
This endpoint will fetch one product details according to the skuId of the product and return a json.

3.http://localhost:8080/findProductsByCategory/category/{category}
This endpoint will fetch all the product details of a specific category and return a json.
for EX. i have added products of three categories in sample data - SHIRT,PANT,SHOES
so if we want to fetch all the SHOES in database,we need to call the rest API in following way
http://localhost:8080/findProductsByCategory/category/SHOES

4.http://localhost:8080/findAvailableNoOfProductBySeller/skuId/{skuId}/sellerId/{sellerId}
This endpoint will fetch no of products a seller has of a particular product.

5.http://localhost:8080/findProductsByCategoryGroupByParams/category/{category}
This is an post end point in this we will need to pass the categoy and paameters on the basis on which we want to group the poducts.
we will be passing the groupParams in a JSON format. for this sample code i have conigured grouping of poducts on the basis of 
following four params : 
COLOR,BRAND,SIZE,PRICE

For EX : If we want to  group the products of category 'PANT' by the  blue color  and M size
we can pass following json on this uri : http://localhost:8080/findProductsByCategoryGroupByParams/category/PANT
{"COLOR":"BLUE","SIZE":"M"}



