import rxJava1.Observable;
import rxJava1.Func1;
import rxJava1.NewThreadSwitcher;
import rxJava1.Subscriber;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/3 20:45
 */
public class Client1 {
    public static void main(String[] args) {
        System.out.println("main-->"+Thread.currentThread());
        Observable.create(new Observable.Onsubscribe<String>() {
            @Override
            public void call(Subscriber<String> stringSubscriber) {
                if (!stringSubscriber.isUnsubscribed()){
                    System.out.println(Thread.currentThread());
                    stringSubscriber.onNext("2");
                    stringSubscriber.onNext("2");
                    stringSubscriber.onNext("2");
                    stringSubscriber.onNext("2");
                    stringSubscriber.onNext("2");
                    stringSubscriber.onCompleted();
                }
            }
        }).subscribeOn(new NewThreadSwitcher()).observeOn(new NewThreadSwitcher()).unify(new Observable.Converter<String, Integer>() {
            @Override
            public Observable<Integer> call(Observable<String> stringObservable) {
                return stringObservable.map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return Integer.parseInt(s);
                    }
                }).map(new Func1<Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer) {
                        return integer+1;
                    }
                });
            }
        }).call(new Subscriber<Integer>() {

            @Override
            public void onCompleted() {
                System.out.println("onCompleted-->"+Thread.currentThread());
                System.out.println("onCompleted");
            }

            @Override
            public void onEorror(Throwable t) {

            }

            @Override
            public void onNext(Integer integer) {

                System.out.println(Thread.currentThread()+""+integer+"-->"+integer.getClass());
            }
        });
    }
}
