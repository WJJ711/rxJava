package rxjava2;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 11:21
 * @desc 挂电话帮助类
 */
public enum ReleaseHelper implements Release {

    RELEASE;

    public static boolean isReleased(Release release) {
        return release == RELEASE;
    }

    public static boolean release(AtomicReference<Release> releaseAtomicReference) {
        Release current = releaseAtomicReference.get();
        Release d = RELEASE;
        if (current != d) {
            current = releaseAtomicReference.getAndSet(d);
            if (current != d) {
                if (current != null) {
                    current.release();
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean isReleased() {
        return true;
    }

    @Override
    public void release() {

    }
}
