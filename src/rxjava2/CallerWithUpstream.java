package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 16:50
 * @desc Caller用于操作符的类
 */
public abstract class CallerWithUpstream<T,R> extends Caller<R> implements CallerSource<T>{
    protected final Caller<T> source;

    public CallerWithUpstream(Caller<T> source) {
        this.source = source;
    }

    @Override
    public Caller<T> source() {
        return source;
    }
}
