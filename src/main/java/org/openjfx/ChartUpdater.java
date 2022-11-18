package org.openjfx;

import javafx.application.Platform;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChartUpdater extends Thread {
    private MyChart myChart;

    public ChartUpdater(MyChart myChart) {
        this.myChart = myChart;

    }

    @Override
    public void run() {


        Thread updater = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    ServerSocket ss = new ServerSocket(6666);
                    Socket s = ss.accept();
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    String str = (String) dis.readUTF();
                    System.out.println("message = " + str);
                    MyChart.add(Double.valueOf(str));
                    System.out.println("val " + Double.valueOf(str));
                    ss.close();
                    //this.setDaemon(true);
                    //this.start();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }


        });

        Platform.runLater(updater);


    }

}
