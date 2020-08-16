package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:05
 * @desc lift操作符
 */
public class CallerLift<R,T> extends CallerWithUpstream<T,R> {
    private final CallerOperator<R,T> mOperator;
    public CallerLift(Caller<T> source,CallerOperator<R,T> operator) {
        super(source);
        this.mOperator=operator;
    }

    @Override
    protected void callActual(Callee<R> callee) {
        Callee<T> tCallee = mOperator.call(callee);
        source.call(tCallee);
    }
}
