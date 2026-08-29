import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] ind = new int[n][2];
        for (int i = 0; i < n; i++) {
            ind[i][0] = nums[i];
            ind[i][1] = i;
        }

        Arrays.sort(ind, Comparator.comparingInt((int[] a) -> a[0]));

        int[] res = new int[n];
        PriorityQueue<Integer> pqI = new PriorityQueue<>();
        PriorityQueue<Integer> pqVal = new PriorityQueue<>();
        pqVal.offer(ind[0][0]);
        pqI.offer(ind[0][1]);
        for (int i = 1; i <= n; i++) {
            if (i == n || ind[i][0] - ind[i - 1][0] > limit) {
                while (!pqI.isEmpty()) {
                    res[pqI.poll()] = pqVal.poll();
                }
            }
            if (i != n) {
                pqVal.offer(ind[i][0]);
                pqI.offer(ind[i][1]);
            }
        }

        return res;
    }
}