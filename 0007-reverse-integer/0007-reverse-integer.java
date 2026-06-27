class Solution {
    public int reverse(int x) {
        int reversed = 0;
        for(; x != 0; x /= 10){
            if(reversed < Integer.MIN_VALUE / 10 || reversed > Integer.MAX_VALUE / 10){
                return 0;
            }
            reversed = reversed * 10 + x % 10;
        }
        return reversed;
    }
}