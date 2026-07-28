class Solution {
    public boolean isPossible(int[] target) {
        int n =  target.length;
        if(n == 1){
            return target[0] == 1;
        }
        long total =0;
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>((a,b) -> b -a);
        for(int num : target){
            total += num;
            pq.offer(num);
        }
        while(pq.peek() > 1){
            int max = pq.poll();
            long rest = total - max;

            if(max <= rest){
                return false;
            }
            long prev;
            if(rest == 1){
                prev = 1;
            }else{
                prev = max % rest;
                if(prev == 0){
                    return false;
                }
            }
            total = total - max + prev;
            pq.offer((int) prev);
        }
        return true;
    }
}