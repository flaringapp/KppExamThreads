package com.flaringapp;

public class SharedResource {

    private final Object lock = new Object();

    private int someSharedData = 0;

    public void incrementSharedData() {
        synchronized (lock) {
            someSharedData++;
        }
    }

    public int getData() {
        return someSharedData;
    }
}
