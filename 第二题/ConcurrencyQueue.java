package vmware;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

public class ConcurrencyQueue {

    private ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
    @Test
    public void test1() throws InterruptedException {


    	ConcurrencyQueue testQueue = new ConcurrencyQueue();
        Producer producer = testQueue.new Producer();
        Consumer consumer = testQueue.new Consumer();
        Consumer consumer2 = testQueue.new Consumer();
        Consumer consumer3 = testQueue.new Consumer();

        producer.start();
        consumer.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(500000);

    }



    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {
            String name = Thread.currentThread().getName()+"-consumer";
            Random random = new Random();
            while(true){
                try {
                    Thread.sleep(1000*(random.nextInt(5)));
                    System.out.println("��"+name+"��׼�������ȡһ��Ԫ��");
                    Integer poll = queue.poll();
                    System.out.println("��"+name+"���Ӷ���ȡ��һ��Ԫ��"+poll);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            String name = Thread.currentThread().getName()+"-producer";
            while(true){
                try {
                    Thread.sleep(2000);
                    queue.offer(1);
                    System.out.println("��"+name+"�������ȡ�в���һ��Ԫ��)");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
