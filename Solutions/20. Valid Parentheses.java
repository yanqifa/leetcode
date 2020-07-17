import java.util.*;
import java.lang.*;
class Solution {
    
    //边界！！！！！！注意边界！！！！
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                if(c == ')')
                {
                    char p = stack.peek();
                    if(p == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                else if(c == '}')
                {
                    char p = stack.peek();
                    if(p == '{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
                else if(c == ']')
                {
                    char p = stack.peek();
                    if(p == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty())return true;
        else return false;
    }
}