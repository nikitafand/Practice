package coding.producerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBQ {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        final Runnable producer = () -> {
            while (true){
                queue.add(new Random().nextInt(10));
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        final Runnable consumer = () -> {
            while (true){
                Integer take = null;
                try {
                    take = queue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(take);
            }
        };
        new  Thread(consumer).start();
        new Thread(consumer).start();
        Thread.sleep(1000);

    }
}
