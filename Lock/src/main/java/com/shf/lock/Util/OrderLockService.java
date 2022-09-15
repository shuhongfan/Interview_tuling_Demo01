package com.shf.lock.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderLockService implements OrderService{
    static int num = 0;

    @Override
    public String getOrderLockService() {
        SimpleDateFormat data = new SimpleDateFormat("YYYYMMDDHHMMSS");
        return data.format(new Date())+num++;
    }
}
