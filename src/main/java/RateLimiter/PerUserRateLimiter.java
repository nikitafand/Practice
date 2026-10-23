package RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PerUserRateLimiter {

    public static void main(String[] args) throws InterruptedException {

        String userId="id1";
        for(int i = 0; i < 10; i++){
            if(allowRequest(userId)){
                System.out.println("Allowed request");
            }else {
                System.out.println("Denied request");
            }
        }
        Thread.sleep(1100);

        System.out.println("\nAfter waiting 1 second:");
        if (allowRequest(userId)) {
            System.out.println("Request 8: Allowed");
        }

    }

    private static final int MAX_REQUEST = 5;
    private static final long TIME_WINDOW_MS=  1000L;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<Long>> userTimeStampsRequest = new ConcurrentHashMap<>();
    private static boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();

        ConcurrentLinkedQueue<Long> timeStamps = userTimeStampsRequest.computeIfAbsent(userId, k -> new ConcurrentLinkedQueue<>());

        synchronized (timeStamps) {
          while(!timeStamps.isEmpty() && (now- timeStamps.peek())> TIME_WINDOW_MS){
              timeStamps.poll();
          }
          if(timeStamps.size()< MAX_REQUEST){
              timeStamps.offer(now);
              return true;
          }
        }
        return false;
    }

}
