package heap_priqueue.priqueueinjava;/// 347. Top K Frequent Elements
/// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {

    private class Freq implements Comparable<Freq>{

        public int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        public int compareTo(Freq another){/*定义比较的方式*/
            if(this.freq < another.freq)
                return -1;/*本身是最小堆了，所以就按照默认的这个优先级来*/
            else if(this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key: map.keySet()){
            if(pq.size() < k)/*如果元素还没超要排的个数*/
                pq.add(new Freq(key, map.get(key)));/*入队*/
            else if(map.get(key) > pq.peek().freq){/*超过了，需要对这些进行比较*/
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.remove().e);
        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
}
