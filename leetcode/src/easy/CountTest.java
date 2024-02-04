package easy;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CountTest {

    static volatile int max = 0;
    static volatile int n = 0;
    static HashMap<Thread, Integer> map = new HashMap<>();
    static volatile AtomicInteger count = new AtomicInteger(0);
    static volatile AtomicInteger current = new AtomicInteger(0);
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        CountTest countTest = new CountTest();
        try (Scanner sc = new Scanner(System.in)) {
            max = sc.nextInt();
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                Thread thread = new Thread(countTest::run);
                map.put(thread, i);
            }
            for (Thread thread : map.keySet()) {
                thread.start();
            }
        }
    }

    private void run() {
        while (count.get() <= max) {
            if (lock.tryLock()) {
                try {
                    Integer integer = map.get(Thread.currentThread());
                    if (current.get() == integer) {
                        System.out.println(Thread.currentThread().getName() + "===" + count.get());
                        current.incrementAndGet();
                        count.incrementAndGet();
                        if (current.get() >= n) {
                            current.set(0);
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
