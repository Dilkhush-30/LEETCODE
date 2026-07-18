class Solution {
    public int evalRPN(String[] tokens) {
        int[]stack = new int[tokens.length];
        int top = -1;

        for(String token : tokens){
            if(token.equals("+")){
                int b = stack[top--];
                int a = stack[top--];
                stack[++top]= a+b;
            }else if(token.equals("-")){
                int b = stack[top--];
                int a = stack[top--];
                stack[++top]= a-b;
            }else if(token.equals("*")){
                int b = stack[top--];
                int a = stack[top--];
                stack[++top]= a*b;
            }else if(token.equals("/")){
                int b = stack[top--];
                int a = stack[top--];
                stack[++top]= a/b;
            }else{
                stack[++top] = Integer.parseInt(token);
            }
        }
        return stack[top];
    }
}