package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 19:04
 * @desc 新线程的switcher
 */
public class NewThreadSwitcher extends Switcher {
    @Override
    public Worker createWorker() {
        return new NewThreadWorker();
    }
}
