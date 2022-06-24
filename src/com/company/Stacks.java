package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Stacks {
    private final List<Character> rightbrackets = Arrays.asList(')','}',']','>');
    private final List<Character> leftbrackets1 = Arrays.asList('(','{','[','<');

    public String reverse(String word){
        Stack<Character> stack= new Stack<>();
        for (var i=0;i<word.length();i++){
            stack.push(word.charAt(i));
        }
        StringBuilder build= new StringBuilder();
        while (!stack.isEmpty())
            build.append(stack.pop());
    return build.toString();
    }
    public boolean isbalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (var ch:expression.toCharArray()) {
            if (isleftexpression(ch))
                stack.push(ch);
            else if (isrightexpresion(ch)) {
                if (stack.isEmpty())
                    return false;

                var top = stack.pop();
                if (!bracketMatch(top,ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isleftexpression(char ch){
        return leftbrackets1.contains(ch);
    }
    private boolean isrightexpresion(char ch){
        return rightbrackets.contains(ch);
    }
    private boolean bracketMatch(char left,char right){
          return leftbrackets1.indexOf(left)==rightbrackets.indexOf(right);
    }
}
