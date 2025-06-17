package thread.collection.java;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> copyeSet = new CopyOnWriteArraySet<>();
        copyeSet.add(1);
        copyeSet.add(2);
        copyeSet.add(3);
        System.out.println("copyeSet = " + copyeSet);

        Set<Integer> skipSet = new ConcurrentSkipListSet<>();
        skipSet.add(1);
        skipSet.add(3);
        skipSet.add(2);
        System.out.println("skipSet = " + skipSet);

    }

}
