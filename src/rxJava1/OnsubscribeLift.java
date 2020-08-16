package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:31
 * @desc 做变换用的OnCall
 */
public class OnsubscribeLift<T,R> implements Observable.Onsubscribe<R> {
    private final Observable.Onsubscribe<T> parent;
    private final Observable.Operator<R,T> operator;

    public OnsubscribeLift(Observable.Onsubscribe<T> parent, Observable.Operator<R, T> operator) {
        this.parent = parent;
        this.operator = operator;
    }

    /**
     * 最精华的部分
     * @param subscriber
     */
    @Override
    public void call(Subscriber<R> subscriber) {
        Subscriber<T> tSubscriber = this.operator.call(subscriber);
        this.parent.call(tSubscriber);
    }
}
