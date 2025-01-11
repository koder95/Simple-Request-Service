package pl.koder95.srs;

import lombok.Getter;

/**
 * Wspierane wersje protokołu HTTP.
 */
@Getter
public enum Protocol {

    /**
     * @see <a href="https://datatracker.ietf.org/doc/html/rfc2616">RFC 2616 – Hypertext Transfer Protocol -- HTTP/1.1</a>
     */
    HTTP_1_1("HTTP/1.1");

    private final String text;

    Protocol(String text) {
        this.text = text;
    }
}
