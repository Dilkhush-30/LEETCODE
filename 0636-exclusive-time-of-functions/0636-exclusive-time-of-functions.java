class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack =new ArrayDeque<>();
        int prevTime = 0;

        for(String log : logs){
            String[] parts = log.split(":");
            int funcId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if(type.equals("start")){
                if(!stack.isEmpty()){
                    result[stack.peek()] += timestamp - prevTime;
                }
                stack.push(funcId);
                prevTime = timestamp;
            }else{
                result[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }
        return result;
    }
}