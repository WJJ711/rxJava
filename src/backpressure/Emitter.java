package backpressure;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 21:13
 * @desc 用于发射数据
 */
public interface Emitter<T> {
    void onReceive(T t);
    void onCompleted();
    void onError(Throwable t);
}
