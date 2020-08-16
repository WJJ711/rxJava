package backpressure;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:25
 */
public interface Receiver<T> {
    void onCall(Drop d);
    void onReceive(T t);
    void onError(Throwable t);
    void onCompleted();
}
