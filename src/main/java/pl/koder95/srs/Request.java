package pl.koder95.srs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public final class Request {

    private final Method method;
    private final String path;
    private final Protocol protocol;
    private final Set<Header> headers;
    private final String body;

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return this.getMethod() + " " + this.getPath() + " " + this.getProtocol().getText() + "\n" +
                this.getHeaders().stream().map(Header::toString).collect(Collectors.toList()) + "\n" + this.getBody();
    }

    public static class Builder {
        private Method method;
        private String path;
        private Protocol protocol;
        private final Set<Header> headers = new LinkedHashSet<>();
        private String body;

        private Builder() {}

        public Builder method(Method method) {
            this.method = method;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder header(String key, String value) {
            this.headers.add(new Header(key, value));
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Request build() {
            return new Request(
                    this.method == null? Method.GET : this.method,
                    this.path == null || this.path.isEmpty()? "/" : this.path,
                    this.protocol == null? Protocol.HTTP_1_1 : this.protocol,
                    Collections.unmodifiableSet(this.headers),
                    this.body == null? "" : this.body);
        }

        public String toString() {
            return "Request.Builder(" +
                    "method=" + this.method + ", " +
                    "path=" + this.path + ", " +
                    "protocol=" + this.protocol + ", " +
                    "headers=" + this.headers + ", " +
                    "body=" + this.body + ")";
        }
    }
}
