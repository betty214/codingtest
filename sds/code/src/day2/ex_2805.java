package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_2805 {
    static long[]arr;
    static long M;
    static int N;
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day2/2805.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr=new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long start=0;
        long end=arr[N-1];
        long mid=(start+end)/2;
        long answer=0;
        long height=Long.MAX_VALUE;
        long pre=answer;
        while(start<end){
            long now=wood(mid);
            if(pre==now) break;
            if(now>=M){
                if(height>now){
                    answer=mid;
                }
                start=mid;
                mid=(start+end)/2;
                pre=now;
            }else{
                end=mid;
                mid=(start+end)/2;
            }

        }
        System.out.println(answer);
    }static long wood(long h){
        int i=N-1;
        long sum=0;
        while(h<arr[i] && i>0){
            //System.out.println(arr[i]);
            sum+=arr[i]-h;
            i--;
        }
        if(i==0) sum+=arr[0]-h;
        //System.out.println(h+" "+sum);
        return sum;
    }
}
