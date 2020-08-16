package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 20:23
 * @desc 被观察者
 */
public class Observable<T> {

    final Onsubscribe<T> onsubscribe;

    public Observable(Onsubscribe<T> onsubscribe) {
        this.onsubscribe = onsubscribe;
    }
    public static <T> Observable<T> create(Onsubscribe<T> onsubscribe){
        return new Observable<>(onsubscribe);
    }

    public Subscription call(Subscriber<T> subscriber){
        this.onsubscribe.call(subscriber);
        return subscriber;
    }

    public interface Onsubscribe<T> extends Action1<Subscriber<T>>{
    }
    public interface Operator<R,T> extends Func1<Subscriber<R>, Subscriber<T>>{
    }
    public interface Converter<T,R> extends Func1<Observable<T>, Observable<R>>{

    }
    public final <R> Observable<R> lift(final Operator<R,T> operator){
        return create(new OnsubscribeLift<>(onsubscribe,operator));
    }
    public final <R> Observable<R> map(Func1<T,R> func){
        return lift(new MapOperator<>(func));
    }
    public final Observable<T> subscribeOn(Switcher switcher){
        return create(new OperatorSubscribeOn<>(switcher,this));
    }

    public final Observable<T> observeOn(Switcher switcher){
        return lift(new OperatorObserveOn<>(switcher));
    }
    public final <R> Observable<R> unify(Converter<T,R> converter){
        return converter.call(this);
    }


}
