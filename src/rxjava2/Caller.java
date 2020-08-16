package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 21:04
 * @desc 打电话的人
 */
public abstract class Caller<T> {
    public static <T> Caller create(CallerOnCall<T> callerOnCall){
        return new CallerCreate<>(callerOnCall);
    }
    public void call(Callee<T> callee){
        callActual(callee);
    }
    protected abstract void callActual(Callee<T> callee);

    public <R> Caller<R> lift(CallerOperator<R,T> operator){
        return new CallerLift<>(this,operator);
    }
}
