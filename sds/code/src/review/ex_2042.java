package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2042 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/2042.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long [] segment = new long[N];
        for(int i=0;i<N;i++){
            segment[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<K+M;i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1) update(b,c);
            else sum(b,c);
        }
    }static void update(long index, long next){

    }static void sum(long start, long end){

    }
}
