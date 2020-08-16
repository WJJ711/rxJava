package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 19:35
 * @desc 用于callOn的OnCall
 */
public class OperatorSubscribeOn<T> implements Observable.Onsubscribe<T> {

    private final Switcher mSwitcher;
    private final Observable<T> mObservable;

    public OperatorSubscribeOn(Switcher mSwitcher, Observable<T> mObservable) {
        this.mSwitcher = mSwitcher;
        this.mObservable = mObservable;
    }

    @Override
    public void call(Subscriber<T> tSubscriber) {
        Switcher.Worker tWorker=mSwitcher.createWorker();
        tWorker.swithes(new Action0() {
            @Override
            public void call() {
                mObservable.call(tSubscriber);
            }
        });
    }
}
