package com.homework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test16 {

    public static void main(String[] args) {
        Test16 test = new Test16();
        System.out.println(test.threeSumClosest(new int[] { -1,2,1,-4 }, 1));
    }

    /**
     * 
     * 
     * @param nums
     * @param target
     * @return
     * @author lei.zhang
     * @date 2018年8月22日
     */
    public int threeSumClosest(int[] nums, int target) {
        Integer result = null;
        if (nums.length < 3) return target;
        List<Integer> list = new LinkedList<Integer>();
        for (Integer num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        int last = 0;
        for (int i = 0; i < list.size() - 2; i++) {
            if (i > 0 && list.get(i - 1) == list.get(i)) continue;
            int low = i + 1;
            int high = list.size() - 1;
            int a = list.get(i);

            while (low < high) {
                int b = list.get(low);
                int c = list.get(high);
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (result == null) {
                        result = sum;
                        last = sum - target;
                    } else {
                        if (sum - target < last) {
                            result = sum;
                            last = sum - target;
                        }
                    }
                    
                    while (high > 0 && list.get(high) == list.get(high - 1)) high--;
                    high--;
                } else {
                    if (result == null) {
                        result = sum;
                        last = target - sum;
                    } else {
                        if (target - sum < last) {
                            result = sum;
                            last = target - sum;
                        }
                    }

                    while (low < list.size() - 1 && list.get(low) == list.get(low + 1)) low++;
                    low++;
                }
            }

        }

        return result;
    }
}
