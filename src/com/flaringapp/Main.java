package com.flaringapp;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Initializing job...");

//        SharedResource resource = new SharedResource();
//
//        List<Task> tasks = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Task task = new Task(resource);
//            tasks.add(task);
//        }
//
//        System.out.println("Starting job...");
//
//        tasks.forEach(Thread::start);
//
//        tasks.forEach(task -> {
//            try {
//                task.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println("Job finished");
//        System.out.println("Value: " + resource.getData());

        var result = new ListSplitter().split(new ArrayList<Integer>(){{
            add(11);
            add(15);
            add(61);
            add(21);
            add(31);
            add(71);
            add(72);
            add(74);
            add(75);
            add(76);
            add(77);
            add(78);
            add(79);
            add(90);
        }}, 3);
    }

    private List<Integer> splitBalanced(int size, int count) {
        int countPerPart = count / size;
        List<Integer> parts = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            parts.add(countPerPart);
        }

        parts.set(size - 1, parts.get(size - 1) + count % size);

        return parts;
    }

//    private List<Integer> splitWithDifferentSize(int size, int count) {
//        validateSplitSize(size, count);
//    }

    private void validateSplitSize(int size, int count) {
        int minSize = 0;
        for (int i = 1; i <= count; i++) {
            minSize += count;
        }
        if (minSize > size) {
            throw new IllegalStateException("Split size is less that minimum based on count");
        }
    }
}
