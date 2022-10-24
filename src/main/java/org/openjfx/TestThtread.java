package org.openjfx;

public class TestThtread {
    public static void main ( String[] args ) {
        Thread t = new Thread (new MyThread());
        t.start() ;
    }
}
