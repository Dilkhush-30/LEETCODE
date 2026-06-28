class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        while(i  < n && s.charAt(i) == ' ') i++;
        if(i == n) return 0;
        int sign = 1;
        char c = s.charAt(i);
        if(c == '+' || c =='-'){
            if(c == '-') sign = -1;
            i++;
        }
        int result = 0;
        int MAX_DIV_10 = Integer.MAX_VALUE / 10;

        while(i < n){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') break;

            int digit = ch - '0';
            if(result > MAX_DIV_10 || (result == MAX_DIV_10 && digit > 7)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }
}