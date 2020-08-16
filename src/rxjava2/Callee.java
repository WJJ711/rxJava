package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 21:10
 * @desc 接电话的人
 */
public interface Callee<T> {
    void onCall(Release release);
    void onReceive(T t);
    void onCompleted();
    void onError(Throwable t);
}
