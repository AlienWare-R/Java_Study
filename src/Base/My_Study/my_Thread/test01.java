package Base.My_Study.my_Thread;

/**
 * 线程启动指定的代码
 */
// 方法一：从Thread派生一个自定义类，然后覆写run()方法：
/*public class test01 {
    public static void main(String[] args){
        Thread t = new my_Thread01();
        t.start();  // start方法内部调用run方法  此处直接使用 t.run()也可以
    }
}
class my_Thread01 extends Thread{   //从Thread类派生一个自定义类 覆写run方法
    public void run(){
        System.out.println("Start the thread!");
    }
}*/

// 方法二：创建Thread实例时 传入一个Runnable实例
/*public class test01 {
    public static void main(String[] args){
        Thread t = new Thread(new my_Runnable());
        t.start();
    }
}
class my_Runnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Start the Thread!----->Runnable");
    }
}*/

// 特殊的 java8 lambda语法
/*public class test01 {
    public static void main(String[] args){
        Thread t = new Thread(()->{
            System.out.println("Start the Thread!----->lambda");
        });
        t.start();
    }
}*/

// 使用线程打印的语句和直接在main中打印的语句区别？
public class test01 {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread(){
            public void run(){
                System.out.println("thread run...");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){}   // 注意还有一个大括号
                System.out.println("thread end...");
            }
        };
        t.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){}
        System.out.println("main end...");
    }
}
/**
 * main start...会先打印    main end在thread start之前 之后打印无法确定 因为从t线程开始运行后 主线程和t线程就同时运行了 由OS调度
 * 若要对上述代码模拟并发效果 可以调用Thread.sleep()函数 注意异常 发现java很多时候都在强调异常 （可能是之前学C++的时候没有注意 C++也有不少）
 */
