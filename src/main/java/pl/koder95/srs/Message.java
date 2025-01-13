package pl.koder95.srs;

public interface Message {

    int getStatusCode();
    String getText();

    default int getGroup() {
        return getStatusCode() / 100;
    }

    default boolean isInformational() {
        return getGroup() == 1;
    }

    default boolean isSuccess() {
        return getGroup() == 2;
    }

    default boolean isRedirection() {
        return getGroup() == 3;
    }

    default boolean isClientError() {
        return getGroup() == 4;
    }

    default boolean isServerError() {
        return getGroup() == 5;
    }

    default boolean isCustomError() {
        return getGroup() == 6;
    }

    default boolean isUnknownError() {
        return getGroup() == 9;
    }

    default boolean isError() {
        return isClientError() || isServerError() || isCustomError() || isUnknownError();
    }
}
