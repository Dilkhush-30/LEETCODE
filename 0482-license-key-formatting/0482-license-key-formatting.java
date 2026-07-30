class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == '-'){
                continue;
            }
            if(c >= 'a' && c <= 'z'){
                c -= 32;
            }
            sb.append(c);

            if(sb.length() % (k + 1) == k){
                sb.append('-');
            }
        }
        sb.reverse();
        if(sb.length() > 0 && sb.charAt(0) == '-'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}