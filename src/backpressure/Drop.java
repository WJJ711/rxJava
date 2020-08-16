package backpressure;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/4 15:26
 * @desc 丢弃
 */
public interface Drop {
    void request(long n);
    void drop();
}
