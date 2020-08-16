package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 20:13
 * @desc 接电话的人
 */
public interface Observer<T> {
    void onCompleted();
    void onEorror(Throwable t);
    void onNext(T t);
}
