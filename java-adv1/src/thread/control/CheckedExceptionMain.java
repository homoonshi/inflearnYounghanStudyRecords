package thread.control;

import thread.util.ThreadUtils;

import static thread.util.ThreadUtils.sleep;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception{
        throw new Exception();
    }

    static class CheckedRuunable implements Runnable {

        @Override
        public void run() /** throws Exception**/{
//            throw new Exception();
            sleep(1000);
        }
    }

}
