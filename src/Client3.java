import backpressure.*;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:52
 */
public class Client3 {
    public static void main(String[] args) {
        Telephoner.create(new TelephonerOnCall<String>() {
            @Override
            public void call(TelephonerEmitter<String> telephonerEmitter) {
                telephonerEmitter.onReceive("test");
                telephonerEmitter.onReceive("test1");
                telephonerEmitter.onReceive("test2");
                telephonerEmitter.onReceive("test3");
                telephonerEmitter.onReceive("test4");
                telephonerEmitter.onCompleted();
            }
        }).call(new Receiver<String>() {
            @Override
            public void onCall(Drop d) {
                d.request(Long.MAX_VALUE);
                System.out.println("onCall");
            }

            @Override
            public void onReceive(String s) {
                System.out.println("onNext:"+s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }
        });
    }
}
