package coding.producerConsumer;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class MyBlockingQueue {

    int size = 10;
    private Queue<Integer> queue;
    final ReentrantLock lock = new ReentrantLock(true);
    final Condition notEmpty = lock.newCondition();
    final Condition notFull = lock.newCondition();


    public MyBlockingQueue(int max) {

        queue = new LinkedList<>();
        this.size = max;
    }

    private void put(Integer e) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == size) {
                log.info("Queue empty - {} waiting",Thread.currentThread().getName());
                notEmpty.await();
            }
            log.info("Adding to queue : {}", e);
            queue.add(e);
            notFull.signalAll();
        } finally {
            log.info("put : finally");
            lock.unlock();
        }

    }

    private Integer take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log.info("Queue full - {} waiting",Thread.currentThread().getName());
                notFull.await();

            }
            Integer item = queue.remove();
            notEmpty.signalAll();
            log.info("Removing from queue : {}",item);
            return item;
        } finally {
            log.info("take : finally");
            lock.unlock();
        }

    }

    public void start(int noOfProducer, int noOfConsumer) {
        Runnable producer = () -> {
            while (true) {
                int nextInt = new Random().nextInt(10);
                try {
                    put(nextInt);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        for (int i = 0; i < noOfProducer; i++) {
            new Thread(producer).start();
        }
        for (int i = 0; i < noOfConsumer; i++) {
            new Thread(consumer).start();
        }


    }
}
