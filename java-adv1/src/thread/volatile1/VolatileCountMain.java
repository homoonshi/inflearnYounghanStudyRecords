package thread.volatile1;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        t.start();

        sleep(1000);

        task.flag = false;
        log("flag = "+task.flag+", count = "+task.count+" in main");


    }

    static class MyTask implements Runnable {

//        boolean flag = true;
//        long count;

        volatile boolean flag = true;
        volatile long count;

        @Override
        public void run() {
            while (flag) {
                count++;
                // 1억번에 한번 씩 출력
                if (count % 100000000 == 0){
                    log("flag = "+ flag + ", count = "+ count + " in while()");
                }
            }
            log("flag = "+flag+", count = "+count+" 종료");
        }
    }

}
