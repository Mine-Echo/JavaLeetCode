// package LeetCode;
//交替打印FooBar

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LeetCode1115 {
    class SynchronizedMethod {
        
        private int n;

        private Boolean flag = true;

        public SynchronizedMethod(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (!flag) {
                        this.wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = false;
                    this.notifyAll();
                }

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (flag) {
                        this.wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = true;
                    this.notifyAll();
                }
            }
        }
    }

    class ReentrantLockMethod {
    private int n;

    private Boolean flag = true;

    private ReentrantLock lock = new ReentrantLock();
    private Condition foo = lock.newCondition();
    private Condition bar = lock.newCondition();

    public ReentrantLockMethod(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag) {
                    foo.await();
                }
                printFoo.run();
                flag = false;
                bar.signal();
            } finally {
                lock.unlock();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag) {
                    bar.await();
                }
                printBar.run();
                flag = true;
                foo.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}
}
