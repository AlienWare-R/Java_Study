package Base.My_Study.my_Thread;

public class my_Join {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("main start...");
        Thread t = new Thread(){
            public void run(){
                System.out.println("thread run...");
            };
        };
        t.start();
        t.join();
        /*try {
            t.join();
        }catch (InterruptedException e){};  // join注意异常报错*/ //在main函数中throws异常也可以
        System.out.println("main end...");
    }
}
/**
 * 2022年10月8日22:16:29
 */
