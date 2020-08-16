package rxjava2;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 17:02
 * @desc 操作符接口
 */
public interface CallerOperator<T,R> {
    Callee<R> call(Callee<T> callee);
}
