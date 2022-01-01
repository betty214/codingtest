package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex_10799 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int raser = 0;
        int answer=0;
        Stack<Integer> pipe = new Stack<>();
        char pre= input.charAt(0);
        pipe.push(raser);
        for(int i=1;i<input.length();i++){
            char now= input.charAt(i);
           if(now==')'){
               if(pre=='('){
                   raser++;
                   if(!pipe.isEmpty()) pipe.pop();
               }else {
                   if(!pipe.isEmpty()){
                       int index=pipe.pop();
                       answer+=(raser-index+1);
                   }
               }
            }else{
               pipe.push(raser);
           }
           pre=now;
        }
        System.out.println(answer);
    }
}
