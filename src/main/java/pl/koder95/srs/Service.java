package pl.koder95.srs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class Service implements Runnable {

    @Getter
    private final String name;
    @Getter
    private final CallHandler callHandler;
    @Getter
    private final Callback callback;

    private final Queue<Request> requestQueue;
    private boolean closeRequest = false;

    public final Thread start() {
        Thread thread = new Thread(this, getName() + " #" + Long.toHexString(System.currentTimeMillis()));
        thread.setDaemon(true);
        thread.start();
        return thread;
    }

    @Override
    public void run() {
        while (!closeRequest) {
            if (!requestQueue.isEmpty())
                callHandler.accept(requestQueue.poll(), callback);
            else {
                try {
                    wait(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void close() {
        this.closeRequest = true;
    }

    public boolean enqueue(Request request) {
        return requestQueue.add(request);
    }
}
