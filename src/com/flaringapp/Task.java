package com.flaringapp;

public class Task extends Thread {

    private final SharedResource resource;

    public Task(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        performJob();
    }

    private void performJob() {
        for (int i = 0; i < 1000000; i++) {
            resource.incrementSharedData();
        }
    }

}
