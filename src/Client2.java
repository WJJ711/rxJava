import rxjava2.*;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 14:36
 */
public class Client2 {
    public static void main(String[] args) {
        Caller.create(new CallerOnCall<String>() {
            @Override
            public void call(CallerEmitter<String> callerEmitter) {
                callerEmitter.onReceive("test");
                callerEmitter.onCompleted();
            }
        }).call(new Callee<String>() {

            @Override
            public void onCall(Release release) {
                release.release();
                System.out.println("onCall："+release.isReleased());
            }

            @Override
            public void onReceive(String s) {
                System.out.println("onNext:"+s);
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }
}
