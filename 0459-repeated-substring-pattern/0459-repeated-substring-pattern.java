class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n <= 1){
            return false;
        }
        String doubled = s + s;
        String check = doubled.substring(1, 2 * n - 1);

        return check.contains(s);
    }
}