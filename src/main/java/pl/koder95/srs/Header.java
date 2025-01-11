package pl.koder95.srs;

import lombok.*;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Data
public final class Header {

    private final String key;
    private final String value;
}
