# Simple Request Service
Projekt dostarcza interfejs dostawcy serwisu wysyłania żądań HTTP.

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
