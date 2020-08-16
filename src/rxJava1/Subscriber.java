package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 20:18
 * 接受信息的人
 */
public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private volatile boolean unCalled;

    @Override
    public void unsubscribe() {
        unCalled = true;
    }

    @Override
    public boolean isUnsubscribed() {
        return unCalled;
    }
}
