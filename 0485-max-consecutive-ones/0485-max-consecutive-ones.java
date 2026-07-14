class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCouunt = 0;
        int currentCount = 0;

        for(int num : nums){
            if(num == 1){
                currentCount++;
                maxCouunt = Math.max(maxCouunt, currentCount);
            }else{
                currentCount = 0;
            }
        }
        return maxCouunt;
    }
}