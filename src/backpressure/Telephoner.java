package backpressure;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:17
 * @desc 打电话的人
 */
public abstract class Telephoner<T> {

    public static <T> Telephoner<T> create(TelephonerOnCall<T> telephonerOnCall){
        return new TelephonerCreate<>(telephonerOnCall);
    }
    public void call(Receiver<T> receiver){
        callActual(receiver);
    }
    protected abstract void callActual(Receiver<T> receiver);
}
