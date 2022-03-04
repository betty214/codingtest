package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_14888 {
    static int N,min,max;
    static int []number,op;
    static boolean[]visited;
    static ArrayList<String>c;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/14888.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        number = new int[N];
        op = new int[N-1];
        visited=new boolean[N-1];
        c=new ArrayList<>();
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int index=0;
        for(int i=0;i<4;i++){
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                op[index]=i;
                index++;
            }
        }

        comb("",0);
        System.out.println(max);
        System.out.println(min);
    }static void comb(String calc, int depth) {
        if (depth == N - 1) {
            int index=0;
            int numNow=number[index++];
            for(int j=0;j<N-1;j++){
                char opNow = calc.charAt(j);

                switch(opNow){
                    case '0':
                        numNow+=number[index];
                        break;
                    case '1':
                        numNow-=number[index];
                        break;
                    case '2':
                        numNow*=number[index];
                        break;
                    case '3':
                        numNow/=number[index];
                        break;
                }
                index++;
            }
            min=Math.min(numNow,min);
            max=Math.max(numNow,max);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(calc + Integer.toString(op[i]), depth + 1);
                visited[i] = false;
            }
        }
    }
}
