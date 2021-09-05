package com.algorithms.util;

public class StopWatch {
    private int time;
    private Long startTime;
    private Long endTime;
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    public void prettyPrint(){
        Long totalTime = endTime - startTime;
        System.out.println("------------------running time(millis) is "+totalTime+"---------------");
    }
}
