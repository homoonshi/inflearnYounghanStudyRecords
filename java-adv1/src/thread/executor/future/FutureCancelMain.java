package thread.executor.future;

import java.util.concurrent.*;

import static thread.util.MyLogger.log;
import static thread.util.ThreadUtils.sleep;

public class FutureCancelMain {

    private static boolean mayInterruptIfRunning = true;
//    private static boolean mayInterruptIfRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());
        log("Future.state: "+future.state());

        // 일정 시간 후 취소 시도
        sleep(3000);

        // cancel 호출
        log("future.cancel("+mayInterruptIfRunning+") 호출");
        boolean cancelResult = future.cancel(mayInterruptIfRunning);
        log("cancel("+mayInterruptIfRunning+") result: "+cancelResult);

        // 결과 확인
        try {
            log("Future result: "+future.get());
        } catch (CancellationException e) {
            log("Future은 이미 취소되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        es.close();
    }

    static class MyTask implements Callable<String> {

        @Override
        public String call() {
            for (int i = 0; i < 10; i++) {
                log("작업 중 : " + i);
                sleep(1000);
            }
            return "Completed";
        }
    }

}
