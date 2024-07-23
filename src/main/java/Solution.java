import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int c = map.getOrDefault(nums[i], 0);
            c++;
            map.put(nums[i], c);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]).thenComparing((int[] a) -> -a[1]));
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.offer(new int[]{ e.getValue(), e.getKey()});
        }
        int i = 0;
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            while(p[0] != 0) {
                res[i++] = p[1];
                p[0]--;
            }
        }

        return res;
    }
}