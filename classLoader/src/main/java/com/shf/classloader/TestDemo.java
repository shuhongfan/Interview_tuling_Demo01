package com.shf.classloader;

public class TestDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        MyClassLoader zhangFei = new MyClassLoader("ZhangFei", "C:\\CODE\\Interview_tuling_Demo01\\classLoader\\target\\classes\\com\\shf\\classloader\\");
        MyClassLoader wukong = new MyClassLoader(zhangFei,"wukong", "C:\\CODE\\Interview_tuling_Demo01\\classLoader\\target\\classes\\com\\shf\\classloader\\");

        Class<?> c = wukong.loadClass("com.shf.classloader.Demo");
        c.newInstance();
    }
}
