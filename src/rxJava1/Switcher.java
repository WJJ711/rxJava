package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 18:58
 * @desc 用于线程切换
 */
public abstract class Switcher {

    public abstract Worker createWorker();
    public static abstract class Worker implements Subscription {
        public abstract Subscription swithes(Action0 action0);
    }
}
