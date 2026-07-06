class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String firstStr = strs[0];

        int minLength = firstStr.length();
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < minLength){
                minLength = strs[i].length();
            }
        }
        int prefixLength = 0;
        for(int i = 0; i < minLength; i++){
            char currentChar = firstStr.charAt(i);

            boolean allMatch = true;
            for(int j = 0; j < strs.length; j++){
                if(strs[j].charAt(i) != currentChar){
                    allMatch = false;
                    break;
                }
            }
            if(allMatch){
                prefixLength++;
            }else{
                break;
            }
        }
        return firstStr.substring(0, prefixLength);
    }
}