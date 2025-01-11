package pl.koder95.srs;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public final class Header {

    private final String key;
    private final String value;

    public String toString() {
        return this.getKey() + ": " + this.getValue();
    }
}
