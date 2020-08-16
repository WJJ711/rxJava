package rxJava1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 20:10
 * @desc 用于callbackOn
 */
public class OperatorObserveOn<T> implements Observable.Operator<T,T> {
    private final Switcher mSwitcher;

    public OperatorObserveOn(Switcher mSwitcher) {
        this.mSwitcher = mSwitcher;
    }

    @Override
    public Subscriber<T> call(Subscriber<T> tSubscriber) {
        return new CallbackOnSubscriber(tSubscriber,mSwitcher);
    }
    private static final  class CallbackOnSubscriber<T> extends Subscriber<T> implements Action0{
        private final Subscriber<T> mSubscriber;
        private final Switcher.Worker mWorker;
        private final Queue<T> mQueue=new LinkedList<>();

        public CallbackOnSubscriber(Subscriber<T> mSubscriber, Switcher switcher) {
            this.mSubscriber = mSubscriber;
            this.mWorker = switcher.createWorker();
        }

        @Override
        public void call() {
            T t = mQueue.poll();
            mSubscriber.onNext(t);
        }

        @Override
        public void onCompleted() {

        }

        @Override
        public void onEorror(Throwable t) {

        }

        @Override
        public void onNext(T t) {
            mQueue.offer(t);
            switches();
        }

        private void switches() {
            mWorker.swithes(this);
        }
    }
}
