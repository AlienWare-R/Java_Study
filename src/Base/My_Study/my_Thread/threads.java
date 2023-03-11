package Base.My_Study.my_Thread;

import java.io.IOException;

public class threads {
    public static void main(String[] args) throws InterruptedException {
        var t1 = new AddThread();
        var t2 = new DecThread();

        t2.start();
        t1.start();
        t1.join();
        t2.join();
        System.out.println(counter.cnt);
        System.out.println("End...");
    }
}

class counter{
    // 用synchronize加锁
    public static final Object lock = new Object();
    public static int cnt = 0;
}

class AddThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            synchronized (counter.lock) {
                counter.cnt += 1;
                //System.out.println(counter.cnt);
            }
        }
    }
}
/*
它表示用Counter.lock实例作为锁，两个线程在执行各自的synchronized(Counter.lock) { ... }代码块时，必须先获得锁，才能进入代码块进行。
执行结束后，在synchronized语句块结束会自动释放锁。
 */
class DecThread extends Thread{
    @Override
    public void run(){
        for(int i = 0; i < 10000; i++){
            synchronized (counter.lock) {
                counter.cnt -= 1;
                //System.out.println(counter.cnt);
            }
        }
    }
}

/**
 * 2022年10月9日21:02:18
 */
