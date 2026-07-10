class Solution {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        char[] path = new char[digits.length()];
        backtrack(digits, 0, path, result);
        return result;
    }
    private void backtrack(String digits, int idx, char[] path, List<String> result){
        if(idx == digits.length()){
            result.add(new String(path));
            return;
        }
        String letters = MAP[digits.charAt(idx) - '0'];
        for(int i = 0; i < letters.length(); i++){
            path[idx] = letters.charAt(i);
            backtrack(digits, idx + 1, path, result);
        }
    }
}