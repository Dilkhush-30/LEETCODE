class Solution {
    public int lastStoneWeight(int[] stones) {
        while(true){
            int max1 = -1, max2 = -1;
            int idx1 = -1, idx2 = -1;

            for(int i = 0; i < stones.length; i++){
                if(stones[i] > 0){
                    if(stones[i] > max1){
                        max2 = max1;
                        idx2 = idx1;
                        max1 = stones[i];
                        idx1 = i;
                    }else if(stones[i] > max2){
                        max2 = stones[i];
                        idx2 = i;
                    }
                }   
            }
            if(max2 == -1){
                return max1 == -1 ? 0 : max1;
            }
            if(max1 == max2){
                stones[idx1] = 0;
                stones[idx2] = 0;
            }else{
                stones[idx1] = max1 - max2;
                stones[idx2] = 0;
            }
        }
    }
}