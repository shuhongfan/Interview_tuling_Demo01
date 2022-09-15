package com.shf.lock;

public class Demo3 {
    public static void main(String[] args) {
        int[] ints = {2, 4, 7, 8, 10, 12, 16, 19, 20};

        int num = 4;
        int s = 0;
        int e = ints.length - 1;
        int m = 0;
        while (s <= e) {
            m = (s + e) / 2;
            if (num == ints[m]) {
                System.out.println("找到"+m);
                return;
            } else if (num < ints[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        System.out.println("不存在");
    }
}
