package am.developer.spring.multitrading.utility;

public class DelayUtil {

    public static void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
