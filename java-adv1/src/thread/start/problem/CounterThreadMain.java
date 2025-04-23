package thread.start.problem;

import static thread.util.MyLogger.log;

public class CounterThreadMain {

    public static void main(String[] args) {
//        CounterThread thread = new CounterThread();
//        thread.start();
//        CounterRunnable counter = new CounterRunnable();
//        Thread thread = new Thread(counter, "counter");
//        thread.start();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 5; i++) {
//                    log("value: "+i);
//                    try{
//                        Thread.sleep(1000);
//                    }catch (InterruptedException e){
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        }, "counter");
//        thread.start();
        Thread threadA = new Thread(new loof("A", 1000), "Thread-A");
        Thread threadB = new Thread(new loof("B", 500), "Thread-B");

        threadA.start();
        threadB.start();

    }

    public static class loof implements Runnable {

        String name;
        int ms;

        public loof(String name, int ms) {
            this.name = name;
            this.ms = ms;
        }

        @Override
        public void run() {
            while(true){
                log(name);
                try {
                    Thread.sleep(ms);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class CounterRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value: "+i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class CounterThread extends Thread{

        @Override
        public void run() {
            for(int i=1; i<=5; i++) {
                try {
                    Thread.sleep(1000);
                    log("value: "+i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
