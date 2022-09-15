package com.shf.lock;

import lombok.Data;

@Data
public class Node {
//    数据
    Object value;

    //    对象引用
    Node next;

    public Node(Object value) {
        this.value = value;
    }
}
