package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_3425 {
    static ArrayList <String> command;
    static String[]name={"POP","INV","DUP","SWP","ADD","SUB","MUL","DIV","MOD"};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/3425.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String com =st.nextToken();
        while(!com.equals("QUIT")){
            command=new ArrayList<>();
            while(!com.equals("END")){
                if(com.equals("NUM")){
                    String X = st.nextToken();
                    command.add(X);
                }else command.add(com);
                st = new StringTokenizer(br.readLine());
                com=st.nextToken();
            }
            int n = Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                int input = Integer.parseInt(br.readLine());
                System.out.println(calc(input));
            }
            st = new StringTokenizer(br.readLine());
            st = new StringTokenizer(br.readLine());
            com =st.nextToken();
        }
    }static int calc(int input){
        ArrayList<Integer>stack=new ArrayList<>();
        stack.add(input);
        for(int i=0;i< command.size();i++){
            System.out.println(Arrays.asList(name).indexOf(command.get(i)));
        }
        return 0;
    }
    /*
NUM X: X를 스택의 가장 위에 저장한다. (0 ≤ X ≤ 109)
POP: 스택 가장 위의 숫자를 제거한다.
INV: 첫 번째 수의 부호를 바꾼다. (42 -> -42)
DUP: 첫 번째 숫자를 하나 더 스택의 가장 위에 저장한다.
SWP: 첫 번째 숫자와 두 번째 숫자의 위치를 서로 바꾼다.
ADD: 첫 번째 숫자와 두 번째 숫자를 더한다.
SUB: 첫 번째 숫자와 두 번째 숫자를 뺀다. (두 번째 - 첫 번째)
MUL: 첫 번째 숫자와 두 번째 숫자를 곱한다.
DIV: 첫 번째 숫자로 두 번째 숫자를 나눈 몫을 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
MOD: 첫 번째 숫자로 두 번째 숫자를 나눈 나머지를 저장한다. 두 번째 숫자가 피제수, 첫 번째 숫자가 제수이다.
* */
}
