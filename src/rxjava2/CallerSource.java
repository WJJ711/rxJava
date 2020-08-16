package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 16:51
 * @desc 返回源Caller
 */
public interface CallerSource<T>{
    Caller<T> source();
}
