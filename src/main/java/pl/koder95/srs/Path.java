package pl.koder95.srs;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.unmodifiableList;
import static pl.koder95.srs.Method.*;

@Getter
public final class Path {

    private final String resource;
    private final List<Method> availables;

    public Path(String resource, Method... availables) {
        this.resource = resource;
        this.availables = unmodifiableList(Arrays.stream(availables).sorted().collect(Collectors.toList()));
    }

    public boolean isAvailable(Method method) {
        return availables.contains(method);
    }
}
