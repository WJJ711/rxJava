package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:39
 * @desc map操作符的接收者
 */
public class MapSubscriber<T,R> extends Subscriber<T> {
    private final Subscriber<R> actual;
    private final Func1<T,R> mapper;

    public MapSubscriber(Subscriber<R> actual, Func1<T, R> mapper) {
        this.actual = actual;
        this.mapper = mapper;
    }

    @Override
    public void onCompleted() {
        this.actual.onCompleted();
    }

    @Override
    public void onEorror(Throwable t) {
        this.actual.onEorror(t);
    }

    @Override
    public void onNext(T t) {
        R tR = this.mapper.call(t);
        this.actual.onNext(tR);
    }
}
