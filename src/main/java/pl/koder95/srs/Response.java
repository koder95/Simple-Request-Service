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
public final class Response {

    private final Message message;
    private final Set<Header> headers;
    private final String body;

    @Override
    public String toString() {
        return this.getMessage().getStatusCode() + " " + this.getMessage().getText() + "\n" +
                this.getHeaders().stream().map(Header::toString).collect(Collectors.toList()) + "\n" + this.getBody();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Message message;
        private final Set<Header> headers = new LinkedHashSet<>();
        private String body;

        private Builder() {}

        public Builder message(Message message) {
            this.message = message;
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

        public Response build() {
            return new Response(
                    this.message == null? StandardMessage.STATUS_444 : this.message,
                    Collections.unmodifiableSet(this.headers),
                    this.body
            );
        }
    }
}
