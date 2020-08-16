package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:08
 * @desc 文件描述
 */
public interface Function<T,R> {
    R call(T t);
}
