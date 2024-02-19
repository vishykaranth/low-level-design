package SystemDesign.RateLimiter.LeakyBucket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        UserBucketCreator userBucketCreator = new UserBucketCreator(1);
        ExecutorService executors = Executors.newFixedThreadPool(12);
        for (int i = 0; i < 12; i++) {
            if (i % 5 == 0) {
                Thread.sleep(1000);
            }
            executors.execute(() -> userBucketCreator.accessApplication(1));

        }
        executors.shutdown();
    }
}
