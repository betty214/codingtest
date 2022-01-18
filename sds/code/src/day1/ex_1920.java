package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1920 {
    static int[]A;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day1/1920.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(A);
        for(int i=0;i<M;i++){
            int input=Integer.parseInt(st.nextToken());
            if(binary(input)) System.out.println(1);
            else System.out.println(0);
        }
    }static boolean binary(int num){
        int start=0;
        int end=N-1;
        while(start<=end){
            int now_index=(start+end)/2;
            int now=A[now_index];
            if(now==num) return true;
            else if(now>num){
                end=now_index-1;
            }else if(now<num){
                start=now_index+1;
            }
        }
        return false;
    }
}
