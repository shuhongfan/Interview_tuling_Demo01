package com.shf.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String path; // 类加载器路径
    private String name; // 类加载器名称

    public MyClassLoader(String name, String path) {
        super(); // 让系统加载器为该类的父加载器
        this.path = path;
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent, String name, String path) {
        super(parent); // 显示指定该类的父加载器
        this.path = path;
        this.name = name;
    }


    /**
     * 加载我们自定义的类，通过我们自定义的这个ClassLoader
     *
     * @param name The <a href="#name">binary name</a> of the class
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = readClassFileToByteArray(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 获取 .class文件的字节数组
     *
     * @param name
     * @return
     */
    private byte[] readClassFileToByteArray(String name) {
        InputStream is = null;
        byte[] returnData = null;

        name = name.replace("\\.", "/");
        String filePath = this.path + name + ".class";

        File file = new File(filePath);

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            is = new FileInputStream(file);
            int tmp = 0;
            while ((tmp = is.read()) != -1) {
                os.write(tmp);
            }
            returnData = os.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return returnData;
    }
}
