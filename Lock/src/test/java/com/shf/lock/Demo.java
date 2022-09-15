package com.shf.lock;

public class Demo {
    public static void main(String[] args) {
        int[] ints = new int[6];
        ints[ints.length - 1] = 2;
        ints[ints.length - 2] = 3;
        ints[ints.length - 3] = 7;
        int num = 16;

        int[] demo = demo(ints, num);

        for (int i = 0; i < demo.length; i++) {
            System.out.print(ints[i]);
        }
    }

    static int[] demo(int[] ints, int num) {
        //        计算每一位
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= num;
        }

//        进和留
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i - 1] += ints[i] / 10;
            ints[i] = ints[i] % 10;
        }
        return ints;
    }
}
