package com.shf.lock;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int[] ints = {7, 3, 8, 2, 1, 9, 4, 5};

//        i:1到最后
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] < ints[i - 1]) {
//                找到插入的位置
                for (int j = 0; j < i; j++) {
                    if (ints[i] < ints[j]) {
                        int temp = ints[i];
                        for (int k = i - 1; k >= j; k--) { //向后移动
                            ints[k + 1] = ints[k];
                        }
                        ints[j] = temp;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
