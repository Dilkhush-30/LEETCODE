class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] t = new char[s.length() * 2 + 1];
        t[0] = '#';
        for(int i = 0; i < s.length(); i++){
            t[2 * i + 1] = s.charAt(i);
            t[2 * i + 2] = '#';
        }
        int n = t.length;
        int[] p = new int[n];
        int center = 0; 
        int right = 0;
        int maxCenter = 0; 
        int maxRadius = 0;

        for(int i = 0; i < n; i++){
            if(i < right){
                int mirror = 2 * center - i;
                p[i] = Math.min(right - i, p[mirror]);
            }
            int leftIndex = i - (1 + p[i]);
            int rightIndex = i + (1 + p[i]);
            while(leftIndex >= 0 && rightIndex < n && t[leftIndex] == t[rightIndex]){
                p[i]++;
                leftIndex--;
                rightIndex++;
            }
            if(i + p[i] > right){
                center = i;
                right = i + p[i];
            }
            if(p[i] > maxRadius){
                maxRadius = p[i];
                maxCenter = i;
            }
        }
        int start = (maxCenter - maxRadius) / 2;
        return s.substring(start, start + maxRadius);
    }
}