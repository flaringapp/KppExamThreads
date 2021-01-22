package com.flaringapp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing job...");

        SharedResource resource = new SharedResource();

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 5;i++) {
            Task task = new Task(resource);
            tasks.add(task);
        }

        System.out.println("Starting job...");

        tasks.forEach(Thread::start);

        tasks.forEach(task -> {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Job finished");
        System.out.println("Value: " + resource.getData());
    }
}