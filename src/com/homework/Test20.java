package com.homework;

import java.util.Stack;

public class Test20 {

    
    public static void main(String[] args) {
        Test20 test = new Test20();
        System.out.println(test.isValid("(([]){})"));
    }
    
    /**
     * 只要遇到括号匹配的问题，我们就选择用栈，遇到左括号就进栈，遇到右括号，就判断栈顶元素是否与之匹配，匹配的话就pop出栈，不匹配的话就返回false
     * 
     * @param s
     * @return
     * @author lei.zhang
     * @date 2018年8月27日
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='{' || ch =='[' || ch=='(' ) {
                st.push(ch);
            }else if (ch=='}' || ch ==']' || ch == ')' ){
                if (st.empty()) return false;
                char sch = st.lastElement();
                if ( (sch=='{' && ch =='}') || (sch=='[' && ch==']') || (sch=='(' && ch==')' ) ){
                    st.pop();
                }else {
                    return false;
                }
            }else{
                return false;
            }
        }
        
        return st.empty();
    }
    
}

