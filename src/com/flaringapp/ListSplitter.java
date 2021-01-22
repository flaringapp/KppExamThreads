package com.flaringapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListSplitter {

    public <T> List<List<T>> split(List<T> listToSplit, int newListsCount) {
        ArrayList<List<T>> newLists = new ArrayList<>(4);
        newLists.add(listToSplit);

        while (newLists.size() < newListsCount) {
            var maxListOptional =  newLists.stream().max(Comparator.comparing(List::size));
            var maxSizeList = maxListOptional.orElseGet(() -> newLists.get(0));
            var splittingIndex = ThreadLocalRandom.current().nextInt(1, maxSizeList.size() - 1);

            var firstArray = maxSizeList.subList(0, splittingIndex);
            var secondArray = maxSizeList.subList(splittingIndex, maxSizeList.size());

            newLists.remove(maxSizeList);
            newLists.add(firstArray);
            newLists.add(secondArray);
        }

        return newLists;
    }
}
