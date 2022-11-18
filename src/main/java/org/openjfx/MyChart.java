package org.openjfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Random;


public class MyChart extends VBox {


    static XYChart.Series<Double , Double> series = new XYChart.Series<>();
    private Random rdx = new Random();
    private static double x=0;
    private double x_max=10;

    NumberAxis xAxis = new NumberAxis ("Time Constant " , 0.0 , x_max , 1 );

    public MyChart() {
        getChildren().add(buildSampleLineChart());
        Button myButton= new Button("Click me");

        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                /*try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {

                }*/

                //for (int i = 0; i < 10000; i++) {
                    //series.getData().add(new XYChart.Data<>(rdx.nextDouble() * 5, rdx.nextDouble()));
                //}
            }
        });
        getChildren().add(myButton);
    }

    public static void add(Double valueOf) {
        series.getData().add(new XYChart.Data<>(x,valueOf));
        System.out.println(series);
        x+=1;
        System.out.println("x="+x);

    }

    public LineChart buildSampleLineChart(){
        /*XYChart.Series<Double , Double> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(0.0 ,0.0)) ;
        series.getData().add(new XYChart.Data<>(0.7 , 0.5)) ;
        series.getData().add(new XYChart.Data<>(1.0 , 0.632)) ;
        series.getData().add(new XYChart.Data<>(2.0 , 0.865)) ;
        series.getData().add(new XYChart.Data<>(3.0 , 0.95)) ;
        series.getData().add(new XYChart.Data<>(4.0 , 0.982)) ;
        series.getData().add(new XYChart.Data<>(5.0 , 0.993)) ;*/
        LineChart lc = new LineChart (
                xAxis ,
                new NumberAxis(" Voltage (Vs ) " , 0.0 , 1.0 , 0.1 )
        ) ;

        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable updater = new Runnable() {
                    @Override
                    public void run() {
                        //series.getData().add(new XYChart.Data<>(x, (Math.sin(x)+1)/2));
                        series.getData().add(new XYChart.Data<>(x, rdx.nextDouble()));
                        x+=0.1;
                        if(x>x_max){
                            series.getData().remove(0);
                            xAxis.setLowerBound(x-x_max);
                            xAxis.setUpperBound(x);


                        }
                    }
                };
                while(true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {

                    }
                    Platform.runLater(updater);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();*/

        lc.getData().add(series) ;
        return lc ;
    }

    public XYChart.Series<Double, Double> getSeries() {
        return series;
    }

    public Random getRdx() {
        return rdx;
    }


}
