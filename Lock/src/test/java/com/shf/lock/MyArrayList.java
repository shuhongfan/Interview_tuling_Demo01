package com.shf.lock;

public class MyArrayList {
    Object[] objs = new Object[4];
    int size = 0;

    public int size() {
        return size;
    }

    public void add(Object value) {
//        放不放的下
        if (size >= objs.length) {
            Object[] temp = new Object[objs.length * 2];
//            搬家
            for (int i = 0; i < objs.length; i++) {
                temp[i] = objs[i];
            }
            objs = temp;
        }
        objs[size] = value;
        size++;
    }

    public void set(int index, Object value) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("超出范围");
        }
        objs[index] = value;
    }

    public Object get(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("超出范围");
        }
        return objs[index];
    }

    public void clear() {
        size = 0;
        objs = new Object[4];
    }

    public void removeAt(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("超出范围");
        }
        for (int i = index + 1; i<size; i++) {
            objs[i-1] = objs[i];
        }
        size--;
    }

    public static void main(String[] args) throws Exception {
        MyArrayList list = new MyArrayList();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(5);
        list.add(8);

        list.set(1, 9);

        list.removeAt(1);
        list.removeAt(1);
        list.removeAt(1);

        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i)+" ");
        }

    }
}
