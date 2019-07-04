package com.homework.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort {

    public static void main(String[] args) {
        Integer[] ints = new Integer[] {101,3,5,9,15,22,1,999,1500,12000};
        System.out.println(quickSort(Arrays.asList(ints)));
        
    }
    
    private static List<Integer> quickSort(List<Integer> source) {
        if (source.size() < 2) {
            return source;
        }

        int target = source.get(0);
        List<Integer> low = new LinkedList<>();
        List<Integer> high = new LinkedList<>();

        for (int i = 1; i < source.size(); i++) {
            if (source.get(i) > target) {
                high.add(source.get(i));
            } else {
                low.add(source.get(i));
            }
        }

        List<Integer> result = quickSort(low);
        result.add(target);
        result.addAll(high);

        return result;
    }
}
