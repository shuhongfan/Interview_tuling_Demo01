package com.shf.lock;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoLockOrder {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                @Override
                @SneakyThrows
                public void run() {
                    countDownLatch.await();
                    System.out.println(Thread.currentThread().getName() + " start"+getOrderNo());
                }
            });
        }
        countDownLatch.countDown();
        executorService.shutdown();
    }

    static int num = 0;
    public static String getOrderNo() {
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHMMSS");
        String format1 = format.format(new Date())+num++;
        return format1;
    }
}
