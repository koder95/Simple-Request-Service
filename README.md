# Simple Request Service
Projekt dostarcza interfejs dostawcy serwisu wysyłania żądań HTTP.
```xml
<dependency>
  <groupId>pl.koder95</groupId>
  <artifactId>srs</artifactId>
  <version>0.0.1</version>
</dependency>
```

Wykonywanie żądań dokonuje się za pomocą interfejsu `Call`, którego implementację dostarcza interfejs `CallHandler`.
Za jego pomocą usługa `Service` może obsługiwać kolejkę żądań `Request`. Odpowiedzi `Response` na żądania mogą być przechwycone
przez interfejs `Callback`, w celu ich dowolnej obsługi.

Biblioteka dostarcza również definicję wszystkich metod żądań HTTP (enumeracja `Method`).


## Uruchamianie usługi
Przykładowy kod uruchamiający serwis:
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
Usługa wykonuje w pętli pobieranie żądania z kolejki i wysyła je do obsługi wywołań `CallHandler` aż
do żądania zamknięcia usługi przez wywołanie metody `close()`.
Metoda `start()` uruchamia nowy wątek typu demon (działający w tle).

## Tworzenie żądań
Przykładowy kod tworzący nowe żądanie:

```java
Request request = Request.builder()
        .method(Method.GET) // domyślna wartość
        .path("/index.html") // wartość domyślna: "/"
        .protocol(Protocol.HTTP_1_1) // domyślna wartość
        .header("Content-type", "text/html")
        .body("") // domyślna wartość
        .build();
```
Tak utworzone żądanie można wysłać do serwisu:
```java
Service service;
// ...
service.send(request);
```
