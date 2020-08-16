import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

/**
 * @author wjj
 * @version 1.0
 * @date 2020/8/7 18:26
 */
public class Client4 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1.1;
        }).thenAccept(result-> System.out.println(result));
        Thread.sleep(5000);
    }
}
