package coding.producerConsumer;

public class ProducerConsumer {
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue= new MyBlockingQueue(5);
        myBlockingQueue.start(10,2);

    }
}
