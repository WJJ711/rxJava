package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:08
 * @desc map操作符
 */
public class CallerMap<T,R> extends CallerWithUpstream<T,R> {
    private Function<T,R> mFunction;
    public CallerMap(Caller<T> source,Function<T,R> function) {
        super(source);
        mFunction=function;
    }

    @Override
    protected void callActual(Callee<R> callee) {

    }
}
