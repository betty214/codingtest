package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2003 {
    public static void main(String[] args)throws IOException {
        System.setIn(new FileInputStream("code/src/input/2003.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[]sum=new long[N];
        st = new StringTokenizer(br.readLine());
        int s=0;
        int count=0;
        for(int i=0;i<N;i++){
            s+=Integer.parseInt(st.nextToken());
            sum[i]=s;
            if(s==M) count++;
        }
        int start=1;
        int end=1;
        while(end<N){
            long now=sum[end]-sum[start-1];
            if(now==M) {
                count++;
                start++;
                end=start;
            }
            else if(now<M) end++;
            else start++;
        }
        System.out.println(count);
    }
}
