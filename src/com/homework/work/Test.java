package com.homework.work;

public class Test {

    public static void main(String[] args) {
        int[] ints = new int[] {8,1,-2,3,10,-4,7,2,-5};
        System.out.println(getMaxSum(ints));
    }
    
    private static int getMaxSum(int[] ints) {
        int lastMax = 0;
        int result = 0;
        for (int i : ints) {
            int temp = result + i;
            
            if (temp > result) {
                result = temp;
            } else {
                
            }
        }
        
        return result;
    }
}
