package org.sqteam.ocrisk;

public class Main {
    static {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("ocrisk_native");
    }

    public void print(){
        long ptr = API.init();
        API.test(ptr);
    }

    public static void main(String[] args) {
        new Main().print();
    }
}