package day10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14003 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day10/5582.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []A=new int[N];
        int []index=new int[N];
        StringTokenizer st= new StringTokenizer(br.readLine());
        int []LIS=new int[N];
        int min=0;
        int j=0;
        int lindex=0;
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
            if(min<A[i]) {
                index[i]=j++;
                LIS[lindex]=A[i];
                min=A[i];
            }else{
            }
        }
    }
}
