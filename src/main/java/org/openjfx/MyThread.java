package org.openjfx;

public class MyThread implements Runnable {
    @Override
    public void run(){
        int i =0;
        for(i=0; 1<10; i++){
            System.out.println(i);
        }
    }

}
