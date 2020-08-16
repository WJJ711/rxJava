package backpressure;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:23
 * @desc 实际的Telephoner
 */
public final class TelephonerCreate<T> extends Telephoner<T>{
    private TelephonerOnCall<T> mTelephonerOnCall;

    public TelephonerCreate(TelephonerOnCall<T> mTelephonerOnCall) {
        this.mTelephonerOnCall = mTelephonerOnCall;
    }


    @Override
    protected void callActual(Receiver<T> receiver) {
        DropEmitter<T> tDropEmitter=new DropEmitter<>(receiver);
        receiver.onCall(tDropEmitter);
        mTelephonerOnCall.call(tDropEmitter);
    }

    private static class DropEmitter<T>
            extends AtomicLong
            implements TelephonerEmitter<T>,Drop{

        private Receiver<T> mReceiver;
        private volatile boolean mIsDropped;

        public DropEmitter(Receiver<T> mReceiver) {
            this.mReceiver = mReceiver;
        }

        @Override
        public void request(long n) {
            BackpressureHelper.add(this,n);
        }

        @Override
        public void drop() {
            mIsDropped=true;
        }

        @Override
        public void onReceive(T t) {
            if (get()!=0){
                mReceiver.onReceive(t);
                BackpressureHelper.produced(this,1);
            }
        }

        @Override
        public void onCompleted() {
            mReceiver.onCompleted();
        }

        @Override
        public void onError(Throwable t) {
            mReceiver.onError(t);
        }
    }
}
