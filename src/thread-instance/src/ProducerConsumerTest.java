public class ProducerConsumerTest {
    public  static void main(String[] args){
        CubbyHole hole = new CubbyHole();
        Producer producer = new Producer(hole,1);
        Consumer consumer = new Consumer(hole,1);

        producer.start();
        consumer.start();
    }
}
