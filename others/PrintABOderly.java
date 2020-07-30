import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABOderly {
    public static void main(String[] args){
        final Lock lock = new ReentrantLock();
        final Condition cond1 = lock.newCondition();
        final Condition cond2 = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    while(true) {
                        lock.lock();
                        cond1.await();
                        System.out.println("A");
                        cond2.signal();
                        lock.unlock();
                    }
                }catch(InterruptedException e){
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try{
                    while(true) {
                        lock.lock();
                        cond2.await();
                        System.out.println("B");
                        cond1.signal();
                        lock.unlock();
                    }
                }catch(InterruptedException e){
                }

            }
        }).start();

        lock.lock();
        cond1.signal();
        lock.unlock();

    }
}
