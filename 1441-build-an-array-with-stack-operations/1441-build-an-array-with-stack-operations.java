class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();

        int current = 1;
        int index = 0;

        while(index < target.length && current <= n){
            operations.add("Push");

            if(current == target[index]){
                index++;
            }else{
                operations.add("Pop");
            }
            current++;
        }
        return operations;
    }
}