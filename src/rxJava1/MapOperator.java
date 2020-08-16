package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:36
 * @desc map操作符
 */
public class MapOperator<T,R> implements Observable.Operator<R,T> {
    private final Func1<T,R> mapper;

    public MapOperator(Func1<T, R> mapper) {
        this.mapper = mapper;
    }


    @Override
    public Subscriber<T> call(Subscriber<R> rSubscriber) {
        return new MapSubscriber<>(rSubscriber,this.mapper);
    }
}
