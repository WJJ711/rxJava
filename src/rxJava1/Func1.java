package rxJava1;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:26
 * @desc function调用
 */
public interface Func1<T,R> {
    R call(T t);
}
