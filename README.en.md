# Simple Request Service
[![pl](https://img.shields.io/badge/lang-pl-ff0000)](https://github.com/koder95/Simple-Request-Service/blob/master/README.md)
[![en](https://img.shields.io/badge/lang-en-blue)](https://github.com/koder95/Simple-Request-Service/blob/master/README.en.md)

The project provides an interface for an HTTP request sending service provider.
```xml
<dependency>
  <groupId>pl.koder95</groupId>
  <artifactId>srs</artifactId>
  <version>0.1.1</version>
</dependency>
```

Requests are executed using the `Call` interface, whose implementation is provided by the `CallHandler` interface. Using it, the `Service` can handle the `Request` queue. `Response` to requests can be intercepted by the `Callback` interface for custom handling.

The library also provides definitions for all HTTP request methods (enumeration `Method`).


## Running the service
Example code to start the service:
```java
package com.example.app;

import pl.koder95.srs.Response;
import pl.koder95.srs.Service;

import java.util.concurrent.LinkedBlockingDeque;

public class App {
    public static void main(String[] args) {
        Service service = new Service("My service",
                () -> request -> Response.builder().build(),
                (request, response) -> System.out.println(response),
                new LinkedBlockingDeque<>()
        );
        service.start();
    }
}
```
The service continuously fetches requests from the queue and sends them to the `CallHandler` for handling until a request to close the service is made by calling the `close()` method. The `start()` method starts a new daemon thread (running in the background).

## Creating requests
Example code to create a new request:

```java
Request request = Request.builder()
        .method(Method.GET) // default value
        .path("/index.html") // default value: "/"
        .protocol(Protocol.HTTP_1_1) // default value
        .header("Content-type", "text/html")
        .body("") // default value
        .build();
```
The created request can be sent to the service:
```java
Service service;
// ...
boolean inQueue = service.enqueue(request);
```
