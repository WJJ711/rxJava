package rxJava1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 19:05
 * @desc 新线程的工作类
 */
public class NewThreadWorker extends Switcher.Worker{

    private volatile boolean mIsUnCalled;

    private final ExecutorService mExecutor= Executors.newScheduledThreadPool(2, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"Async");
        }
    });
    @Override
    public Subscription swithes(Action0 action0) {
        SwitcherAction switcherAction = new SwitcherAction(action0);
        mExecutor.submit(switcherAction);
        return switcherAction;
    }

    @Override
    public void unsubscribe() {
        mIsUnCalled=true;
    }

    @Override
    public boolean isUnsubscribed() {
        return mIsUnCalled;
    }
    private static class SwitcherAction implements Runnable, Subscription {
        private final Action0 mAction0;

        private volatile boolean mIsUnCalled;
        public SwitcherAction(Action0 mAction0) {
            this.mAction0 = mAction0;
        }

        @Override
        public void run() {
            mAction0.call();
        }

        @Override
        public void unsubscribe() {
            mIsUnCalled=true;
        }

        @Override
        public boolean isUnsubscribed() {
            return mIsUnCalled;
        }
    }
}
