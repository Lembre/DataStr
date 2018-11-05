package Set_Map.leetcode;/// Leetcode 349. Intersection of Two Arrays
/// https://leetcode.com/problems/intersection-of-two-arrays/description/

import java.util.ArrayList;
import java.util.TreeSet;

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums1)
            set.add(num);

        ArrayList<Integer> list = new ArrayList<>();/*动态数组记录下来*/
        for(int num: nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);/*这样集合中就已经不存在这个数了，所以不需要对sum2进行去掉重复*/
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i ++)
            res[i] = list.get(i);
        return res;/*将动态数组转化成静态数组*/
    }
}
