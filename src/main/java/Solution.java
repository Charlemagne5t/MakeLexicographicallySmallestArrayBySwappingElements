import java.util.*;
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] res = new int[n];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt( (int[] a) -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        pq.offer(arr[0][1]);
        q.offer(arr[0][0]);
        for(int i = 1; i < n; i++) {
            if(arr[i][0] - arr[i - 1][0] <= limit){
                pq.offer(arr[i][1]);
                q.offer(arr[i][0]);
            }else {
                while(!pq.isEmpty()){
                    res[pq.poll()] = q.poll();
                }
                pq.offer(arr[i][1]);
                q.offer(arr[i][0]);
            }
        }
        while(!pq.isEmpty()){
                    res[pq.poll()] = q.poll();
                }

        return res;
    }
}