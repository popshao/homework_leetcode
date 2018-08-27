package com.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test18 {

    public static void main(String[] args) {
        Test18 test = new Test18();
        System.out.println(test.fourSum(new int[] {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492}, 1682));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums.length < 4) return result;
        
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list);
        
        for (int i = 0; i < list.size() - 3; i++) {
            if (i > 0 && list.get(i).equals(list.get(i - 1))) continue; // 排除重复
            Integer a = list.get(i);
            for (int j = i + 1; j < list.size() - 2; j++) {
                if (j > i + 1 && list.get(j).equals(list.get(j - 1))) {
                    continue;
                }
                int b = list.get(j);
                
                int low = j + 1;
                int high = list.size() - 1;
                while (low < high) {
                    int c = list.get(low);
                    int d = list.get(high);
                    if (a + b + c + d == target) {
                        List<Integer> tempList = new ArrayList<Integer>(4);
                        tempList.add(a);
                        tempList.add(b);
                        tempList.add(c);
                        tempList.add(d);
                        
                        result.add(tempList);
                        while(low < list.size() - 1 && list.get(low).equals(list.get(low + 1))) low++;
                        while(high > j + 1 && list.get(high).equals(list.get(high - 1))) high--;
                        low++;
                        high--;
                    } else if (a + b + c + d > target) {
                        while(high > j + 1 && list.get(high).equals(list.get(high - 1))) high--;
                        high--;
                    } else {
                        while(low < list.size() - 1 && list.get(low).equals(list.get(low + 1))) low++;
                        low++;
                    }
                }
            }
        }
        
        return result;
    }
}
