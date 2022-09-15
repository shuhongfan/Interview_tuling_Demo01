package com.shf.lock;

public class MyLinkedList {
    int size = 0;
    Node head = null;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head; // 当前节点
            while (temp.getNext()!=null) {
                temp = temp.getNext(); // 当前节点先后移动
            }
//            循环结束： temp表示最后一个节点
            temp.setNext(newNode);
        }
        size++;
    }

    public void set(int index, Object value) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
//        temp定位到指定索引位置
        temp.setValue(value);
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
//        temp定位到指定索引位置
        return temp.getValue();
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void removeAttr(int index) {
        if (index == 0) {
            head = head.getNext();
        } else {
//            找到删除元素的前一个元素
            Node temp = head;
            for (int i = 0; i < index-1; i++) {
                temp = temp.getNext();
            }
//            循环结束，temp表示删除元素的前一个元素
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(5);
        list.add(8);

        list.set(1, 9);
        list.removeAttr(1);
        list.removeAttr(1);
        list.removeAttr(1);

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
