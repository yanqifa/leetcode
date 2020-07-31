import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private static Queue<Integer> queue = new LinkedList<>();
    private static final int CAPACITY = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition notFull = lock.newCondition();
    private static Condition notEmpty = lock.newCondition();

    public static void main(String[] args){
        new Producer(queue, CAPACITY, lock, notEmpty, notFull).start();
        new Consumer(queue, CAPACITY, lock, notEmpty, notFull).start();
    }
}

class Producer extends Thread{
    private Queue<Integer> queue;
    private int capacity;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;
    private int element = 0;

    Producer(Queue<Integer> queue, int capacity, Lock lock, Condition notEmpty, Condition notFull){
        this.queue = queue;
        this.capacity = capacity;
        this.lock = lock;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
    }

    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if (queue.size() == capacity) {
                    notFull.await();
                }
                System.out.println("Producer produce:" + element % 10);
                queue.offer(element++ % 10);
                notEmpty.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}

class Consumer extends Thread{
    private Queue<Integer> queue;
    private int capacity;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;

    Consumer(Queue<Integer> queue, int capacity, Lock lock, Condition notEmpty, Condition notFull){
        this.queue = queue;
        this.capacity = capacity;
        this.lock = lock;
        this.notEmpty = notEmpty;
        this.notFull = notFull;
    }

    @Override
    public void run() {
        while(true){
            lock.lock();
            try {
                if (queue.size() == 0) {
                    notEmpty.await();
                }
                int element = queue.poll();
                System.out.println("Consumer consume:" + element);
                notFull.signal();
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}

