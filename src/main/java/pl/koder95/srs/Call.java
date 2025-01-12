package pl.koder95.srs;

public interface Call {

    Response call(Request request);

    default void call(Request request, Callback callback) {
        callback.callback(request, call(request));
    }
}
