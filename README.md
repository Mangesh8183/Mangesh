Spring-Boot-Rest-API
This Project demonstrate how to create REST API in Spring-boot. All the basic Standards are followed in this project, like request validation, proper error handling, and return response with appropriate status code.

@RestController
It's a convenience annotation that combines @Controller and @ResponseBody.

@ResponseBody
The @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.

@RequestBody
this annotation enabling automatic deserialization of the inbound HttpRequest body onto a Java object.

@RequestMapping
This annotation maps HTTP requests to handler methods of REST controllers.

ResponseEntity<>()
ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.
