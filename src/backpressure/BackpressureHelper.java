package backpressure;

import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:35
 * @desc 处理背压的帮助类
 */
public final class BackpressureHelper {
    public static void add(AtomicLong requested,long n){
        long r = requested.get();
        if (r==Long.MAX_VALUE){
            return;
        }
        long u=r+n;
        if (u<0L){
            u=Long.MAX_VALUE;
        }
        requested.compareAndSet(r,u);
    }
    public static void produced(AtomicLong requested,long n){
        long current = requested.get();
        if (current==Long.MAX_VALUE){
            return;
        }
        long update=current-n;
        if (update<0L){
            update=0L;
        }
        requested.compareAndSet(current,update);
    }
}
