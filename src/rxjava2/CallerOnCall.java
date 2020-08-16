package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 11:10
 * @desc 当打电话的时候
 */
public interface CallerOnCall<T> {
    void call(CallerEmitter<T> callerEmitter);
}
