package org.sqteam.ocrisk;

public class Main {
    static {
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("ocrisk_native");
    }

    API api;

    public Main(){
        this.api = new API();
    }
    public void print(){
        this.api.test();
    }

    public static void main(String[] args) {
        new Main().print();
    }
}