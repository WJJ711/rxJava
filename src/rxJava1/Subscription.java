package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 20:16
 * @desc 描述打电话
 */
public interface Subscription {
    void unsubscribe();
    boolean isUnsubscribed();
}
