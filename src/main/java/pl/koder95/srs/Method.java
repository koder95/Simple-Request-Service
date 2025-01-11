package pl.koder95.srs;

import lombok.Getter;

/**
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc2616">RFC 2616 – Hypertext Transfer Protocol -- HTTP/1.1</a>
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc7231">RFC 7231 – Hypertext Transfer Protocol (HTTP/1.1): Semantics and Content</a>
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc5789">RFC 5789 – PATCH Method for HTTP</a>
 */
@Getter
public enum Method {

    GET(true, true, true),
    HEAD(true, true, true),
    OPTIONS(true, true, false),
    TRACE(true, true, false),
    DELETE(false, true, false),
    PUT(false, true, false),
    POST(false, false, true),
    PATCH(false, false, true),
    CONNECT(false, false, false);

    private final boolean safe, idempotent, cacheable;

    Method(boolean safe, boolean idempotent, boolean cacheable) {
        this.safe = safe;
        this.idempotent = idempotent;
        this.cacheable = cacheable;
    }
}
