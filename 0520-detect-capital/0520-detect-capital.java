class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        if(n <= 1){
            return true;
        }
        char first = word.charAt(0);
        char second = word.charAt(1);

        if(first >= 'A' && first <= 'Z' && second >= 'A' && second <= 'Z'){
            for(int i = 2; i < n; i++){
                if(word.charAt(i) < 'A' || word.charAt(i) >'Z'){
                    return false;
                }
            }
            return true;
        }
        else if(first >= 'A' && first <= 'Z'){
            for(int i = 1; i < n; i++){
                if(word.charAt(i) < 'a' || word.charAt(i) >'z'){
                    return false;
                }
            }
            return true;
        }
        else {
            for(int i = 0; i < n; i++){
                if(word.charAt(i) < 'a' || word.charAt(i) >'z'){
                    return false;
                }
            }
            return true;
        }
    }
}