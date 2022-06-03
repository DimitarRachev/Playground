import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test5 {
    public static void main(String[] args) {


//        Thread tread = Thread.currentThread();
//        System.out.println(tread.getName());
//        System.out.println(tread.getState());
//
//        for (StackTraceElement element : tread.getStackTrace()) {
//            System.out.println(element);
//        }
//
        for (int i = 0; i < 10; i++) {
            Thread one = new Thread(new Hello());
            one.start();
        }

        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Hello());
        }
        executor.shutdown();
    }

    static class Hello implements Runnable {

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Thread name: " + name);
            System.out.println("Thread id: " + Thread.currentThread().getId());
            System.out.println("Thread state: " + Thread.currentThread().getState());
            try {
                System.out.println("Thread " + name + " sleep for 50000");
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Thread " + name + " sleep interrupted");
            }
        }
    }

}
