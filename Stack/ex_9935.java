package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        String bomb = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for(char ch : stack) {
            sb.append(ch);
        }
        if(sb.length()==0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb.toString());
        }
    }
}
