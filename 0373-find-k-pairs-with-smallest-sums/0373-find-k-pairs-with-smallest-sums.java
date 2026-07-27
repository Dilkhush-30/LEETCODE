class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        var res = new java.util.ArrayList<java.util.List<Integer>>(k);

        if(nums1.length == 0 || nums2.length == 0 || k ==0) {
            return res;
        }
        var pq = new java.util.PriorityQueue<int[]>((a,b) ->
            Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));

        int m = Math.min(nums1.length,k);
        for(int i = 0; i < m; i++){
            pq.offer(new int[]{i,0});
        }

        while(k-- > 0 && !pq.isEmpty()){
            int[] idx = pq.poll();
            res.add(java.util.List.of(nums1[idx[0]], nums2[idx[1]]));

            if(idx[1] + 1<nums2.length){
                pq.offer(new int[]{idx[0], idx[1] +1});
            }
        }
        return res;
    }
}