package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_13458 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/13458.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]A=new int[N];
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long answer=N;
        for(int i=0;i<N;i++){
            if(A[i]-B>0) answer+=(Math.ceil((float)(A[i]-B)/C));
        }
        System.out.println(answer);
    }
}
