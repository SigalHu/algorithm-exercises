package com.sigalhu.ae.test.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huxujun
 * @date 2020/7/26
 */
public class Test01 {

/*
 问题：写一段java多线程代码，完成如下逻辑，同时启动3个线程从1开始打印递增数字，每次每个线程打印3次，
 打印到36程序结束，输出如下：

线程1：1
线程1：2
线程1：3

线程2：4
线程2：5
线程2：6

线程3：7
线程3：8
线程3：9

线程1：10
线程1：11
线程1：12

......

线程3：34
线程3：35
线程3：36
*/

    private static class Worker extends Thread {
        private static ReentrantLock lock = new ReentrantLock();
        private static Condition condition = lock.newCondition();
        private static Condition printCondition = lock.newCondition();
        private static AtomicLong num = new AtomicLong(1);
        private static ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue<>(1);

        private int id;
        private int count;

        public Worker(int id, int count) {
            this.id = id;
            this.count = count;
        }

        public static void signal() {
            lock.lock();
            try {
                condition.signal();
            } finally {
                lock.unlock();
            }
        }

        public static void signalPrint() {
            lock.lock();
            try {
                printCondition.signal();
            } finally {
                lock.unlock();
            }
        }

        public static Long takeFromQueue() throws InterruptedException {
            return queue.take();
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    for (int ii = 0; ii < count; ++ii) {
                        long n = num.getAndIncrement();
                        queue.put(n);
                        printCondition.await();
                        System.out.println("线程" + id + "：" + n);
                    }
                    condition.await();
                } catch (InterruptedException ignored) {
                    return;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    private static void stopAllWorker(List<Worker> workers) throws InterruptedException {
        if (workers == null) {
            return;
        }
        for (Worker worker : workers) {
            worker.interrupt();
            worker.join();
        }
    }

    private static boolean checkIfNeedStopWorker(int count, long num) throws InterruptedException {
        while (--count >= 0) {
            if (Worker.takeFromQueue() > num) {
                return true;
            }
            Worker.signalPrint();
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Worker> workers = new ArrayList<>(3);
        int count = 3;
        long num = 35;

        for (int ii = 1; ii <= 3; ++ii) {
            Worker worker = new Worker(ii, count);
            worker.start();
            workers.add(worker);
            if (checkIfNeedStopWorker(count, num)) {
                stopAllWorker(workers);
            }
        }
        do {
            Worker.signal();
        } while (!checkIfNeedStopWorker(count, num));
        stopAllWorker(workers);
    }
}
