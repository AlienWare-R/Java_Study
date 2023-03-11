package Base.My_Study.my_Thread;

/**
 * 2022年10月8日22:17:04
 */
// 简单实例
/*public class my_ThreadInterrept {
    public static void main(String[] args) throws InterruptedException{
        Thread  t = new my_Thread();
        t.start();
        Thread.sleep(3000);
        t.interrupt();  // 中断t线程
        t.join();       // 等待t线程结束
        System.out.println("end...");
    }
}
class my_Thread extends Thread{
    @Override
    public void run(){
        int n = 0;
        while(!isInterrupted()){
            n++;
            System.out.println(n+"Thread t！");
        }
    }
}*/

/*
    如果线程处于等待状态，比如t.join()会让main线程处于等待状态，那么此时对main线程调用interrupt，join()会立刻抛出异常；因此目标线程只要捕获到
    join()抛出的异常，就说明有其他线程对其调用了interrupt()，通常该进程应当立即结束。
 */

public class my_ThreadInterrept {
    public static void main(String[] args) throws InterruptedException{
        Thread t = new testThreaad();
        t.start();
        Thread.sleep(5000);
        t.interrupt();
        t.join();
        System.out.println("End...");
    }
}
class testThreaad extends Thread{
    @Override
    public void run(){
        Thread t0 = new join_Thread();
        t0.start();
        try {
            t0.join();
        }catch (InterruptedException e){
            System.out.println("join_thread interrupt!");
        };
        t0.interrupt();
        //main中调用t.interrupt()通知t线程中断，此时t线程处于t0.join()中，所以立马返回异常（打印出来）；通常情况下t线程会结束，结束时调用t0.interrupt()
        //中断join_thread，如果去掉这一行（47行）则join_thread仍然会继续运行，jvm也不会退出。
    }
}

class join_Thread extends Thread{
    @Override
    public void run(){
        int n = 0;
        while(!isInterrupted()){
            n++;
            System.out.println(n+"join_thread!");
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                break;
            }
        }
    }
}

// 使用running标志位中断线程
/*public class my_ThreadInterrept {
    public static void main(String[] args)throws InterruptedException {
        test0_Thread t = new test0_Thread();
        t.start();
        Thread.sleep(2000);
        t.running = false;
    }
}
class test0_Thread extends Thread{
    public volatile boolean running = true;
    public  void run(){
        int n = 0;
        while(running){
            n++;
            System.out.println(n+"join_thread!");
        }
        System.out.println("thread end...");
    }
}*/
//注意到HelloThread的标志位boolean running是一个线程间共享的变量。线程间共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值。
/*
为什么要对线程间共享的变量用关键字volatile声明？
    在Java虚拟机中，变量的值保存在主内存中，但是，当线程访问变量时，它会先获取一个副本，并保存在自己的工作内存中。如果线程修改了变量的值，虚拟机会在某个
    时刻把修改后的值回写到主内存，但是，这个时间是不确定的！这会导致如果一个线程更新了某个变量，另一个线程读取的值可能还是更新前的。例如，主内存的变量
    a = true，线程1执行a = false时，它在此刻仅仅是把变量a的副本变成了false，主内存的变量a还是true，在JVM把修改后的a回写到主内存之前，其他线程读取
    到的a的值仍然是true，这就造成了多线程之间共享的变量不一致。
volatile关键字的目的是告诉虚拟机：
    每次访问变量时，总是获取主内存的最新值；
    每次修改变量后，立刻回写到主内存。
volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。
如果我们去掉volatile关键字，运行上述程序，发现效果和带volatile差不多，这是因为在x86的架构下，JVM回写主内存的速度非常快，但是，换成ARM的架构，就会有显著的延迟。
 */

/**
 * 2022年10月8日23点21分
 */