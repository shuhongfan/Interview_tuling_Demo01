package com.shf.lock.task;

import com.shf.lock.Util.OrderService;
import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

public class OrderTask implements Runnable{

    private CountDownLatch countDownLatch;
    private OrderService orderService;

    public OrderTask(CountDownLatch latch, OrderService orderService) {
        this.countDownLatch = latch;
        this.orderService = orderService;
    }

    @Override
    @SneakyThrows
    public void run() {
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " is running"+orderService.getOrderLockService());
    }
}
