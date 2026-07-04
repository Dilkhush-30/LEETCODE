class Solution {
    public int romanToInt(String s) {
        int[] values = new int[128];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int result = 0;
        int n = s.length();
        char[] chars = s.toCharArray();

        for(int i = 0; i < n; i++){
            int curr = values[chars[i]];
            if(i + 1 < n && curr < values[chars[i + 1]]){
                result -= curr;
            }else{
                result += curr;
            }
        }
        return result;
    }
}