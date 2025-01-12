package pl.koder95.srs;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public interface CallHandler extends BiConsumer<Request, Callback>, Supplier<Call> {

    default void handle(Request request, Callback callback) {
        get().call(request, callback);
    }

    @Override
    default void accept(Request request, Callback callback) {
        handle(request, callback);
    }
}
