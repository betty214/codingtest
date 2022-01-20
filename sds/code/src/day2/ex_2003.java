package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2003 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day2/2003.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] arr=new int[N];
        int sum=0;
        for(int i=0;i<N;i++){
            int now= Integer.parseInt(st.nextToken());
            sum+=now;
            arr[i]=sum;
        }
        int L=0;
        int H=0;
        int count=0;
        while(H<N){
            int s;
            if(L==0) {
                s=arr[H];
            }else{
                s=arr[H]-arr[L-1];
            }
            if(s<M) H++;
            else if(s==M) {
                count++;
                L++;
                H=L;
            }
            else L++;
        }
        System.out.println(count);
    }
}
