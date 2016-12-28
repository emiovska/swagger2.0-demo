# 1. Swagger overview
Swagger is a simple powerful tool for documentation and representation of a RESTful APIs. The best thing about Swagger is the ability to document APIs directly in the source code (Java) via annotations so that documentation and actual API implementations are never out of synchronization.

There are multiple benefits of using Swagger:
- **It's comprehensible for developers and non-developers** - Product managers, partners, and even the potential clients can have a look into the design the API.
- **Better understanding of the API** - The multiple annotations that Swagger offers, help developers to fast and easy understand and start using the API.

# 2. Swagger Setup
 The setup process of the Swagger is relatively fast and easy. For the purposes of this project, I am using Springfox implementation of the Swagger 2 specification. To start using Swagger in the project, first at all we should add the Springfox dependecy in out pom.xml file:
 ```
 <dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.4.0</version>
</dependency>
```
## 2.1 Integrating Swagger 2 into a Spring Boot Project
For the purpose od this project I decided to go with Spring Boot because of its easy configuration.
The entire Swagger configration is placed in the SwaggerConfig class which basically is a Spring @Configuration class. Swagger 2 is enabled through the @EnableSwagger2 annotation. 
```java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                ...
    }
}
```

Configuration of Swagger mainly centers around the Docket bean which id declared in the SwaggerConfig class. After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder, which provides a way to control the endpoints exposed by Swagger. Predicates for selection of RequestHandlers can be configured with the help of RequestHandlerSelectors and PathSelectors. Using this configuration is enough to integrate the basic functionalities of Swagger 2 into a Spring Boot project. 

## 2.2 Swagger 2 configuration without Spring Boot
Without Spring Boot, you don’t have the luxury of auto-configuration of your resource handlers. Swagger UI adds a set of resources which you must configure as part of a class that extends WebMvcConfigurerAdapter, and is annotated with @EnableWebMvc
```java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
      .addResourceLocations("classpath:/META-INF/resources/");
 
    registry.addResourceHandler("/webjars/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/");
}
```

## 2.3 Setup verification
After the above configuration is applied, to verify that Springfox is configured propertly, visit the following URL in your browser:

[http://localhost:8080/v2/api-docs](http://localhost:8080/v2/api-docs)

If the result is a JSON response with large number of key-value pairs then congratulation you successfully set up the Swagger 2 in your project :). The received JSON is relatively large which is not very human-readable. Fortunately, Swagger provides Swagger UI for this purpose. 


## 2.4 Swagger UI
Swagger UI is a built-in solution which makes user interaction with the Swagger-generated API documentation much easier. To enable Springfox’s Swagger UI one more dependency is required:

```
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.4.0</version>
</dependency>
```
After the Swagger UI dependency is added to the project, all resources for the API are now visualized through the Swagger UI tool which is available on the following link: 
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

# 3. Exploring Swagger Documentation

## 3.1 Swagger annotations
Swagger comes with a set of custom annotations which help to enrich the documentation with some implementation details.
In this project are covered the following annotations:

- [@Api](http://docs.swagger.io/swagger-core/current/apidocs/index.html?io/swagger/annotations/Api.html) - Marks a class as a Swagger resource.
The @Api annotation has the following attributes:
    - description - Custom defined API resource description
    - produces - Corresponds to the `produces` field of the operations under annotated resource.
    - tags - A list of tags for API documentation control
    - ...
    
- [@ApiOperation](http://docs.swagger.io/swagger-core/current/apidocs/index.html?io/swagger/annotations/Api.html) - Describes an operation or typically a HTTP endpoint against a specific path.

- [@ApiResponse](http://docs.swagger.io/swagger-core/current/apidocs/index.html?io/swagger/annotations/Api.html) - Describes a possible response of an operation

- [@ResponseHeader](http://docs.swagger.io/swagger-core/current/apidocs/index.html?io/swagger/annotations/Api.html) - Represents a header that can be provided as part of the response 

- [@ApiParam](http://docs.swagger.io/swagger-core/current/apidocs/index.html?io/swagger/annotations/Api.html) - 	Adds additional meta-data for operation parameters


