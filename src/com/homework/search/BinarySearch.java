package com.homework.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] ints = new int[] {1,3,5,9,15,22,101,999,1500,12000};
        int target = 1;
        System.out.println(binarySearch(ints, target));
        
    }
    
    private static Boolean binarySearch(int[] ints, int target) {
        int low = 0;
        int high = ints.length - 1;
        int count = 1;
        while (low <= high) {
            System.out.println("第" + count++ + "次搜索");
            int mid = (low + high) / 2;
            if (ints[mid] == target) {
                return true;
            } else if (ints[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        
        return false;
    }
}
