package backpressure;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:18
 * @desc 当打电话的时候
 */
public interface TelephonerOnCall<T> {
    void call(TelephonerEmitter<T> tTelephonerEmitter);
}
