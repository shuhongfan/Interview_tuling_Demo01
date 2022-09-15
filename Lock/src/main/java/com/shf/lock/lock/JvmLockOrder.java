package com.shf.lock.lock;

import com.shf.lock.Util.OrderLockService;
import com.shf.lock.task.OrderTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JvmLockOrder {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        OrderLockService orderLockService = new OrderLockService();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new OrderTask(countDownLatch,orderLockService));
        }

        countDownLatch.countDown();
        executorService.shutdown();
    }
}
