package rxjava2;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 13:40
 * @desc 实际的Caller
 */
public class CallerCreate<T> extends Caller<T> {
    private CallerOnCall<T> mCallerOnCall;

    public CallerCreate(CallerOnCall<T> mCallerOnCall) {
        this.mCallerOnCall = mCallerOnCall;
    }

    /**
     * 核心部分
     * @param callee
     */
    @Override
    protected void callActual(Callee<T> callee) {
        CreateEmitter<T> tCreateEmitter = new CreateEmitter<>(callee);
        callee.onCall(tCreateEmitter);
        mCallerOnCall.call(tCreateEmitter);
    }
    public static final class CreateEmitter<T> extends AtomicReference<Release> implements CallerEmitter<T>,Release{

        private Callee<T> mCallee;

        public CreateEmitter(Callee<T> mCallee) {
            this.mCallee = mCallee;
        }

        @Override
        public void onReceive(T t) {
            if (!isReleased()){
                mCallee.onReceive(t);
            }
        }

        @Override
        public void onCompleted() {
            if (!isReleased()){
                mCallee.onCompleted();
            }
        }

        @Override
        public void onError(Throwable t) {
            if (!isReleased()){
                mCallee.onError(t);
            }
        }

        @Override
        public boolean isReleased() {
            return ReleaseHelper.isReleased(get());
        }

        @Override
        public void release() {
            ReleaseHelper.release(this);
        }
    }
}
