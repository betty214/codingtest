package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_2042 {
    static long[]arr,segment;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/2042.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new long[N+1];
        for(int i=1;i<=N;i++){
            arr[i]=Long.parseLong(br.readLine());
        }
        segment=new long[N*4];
        init(1, N, 1);
        for(int i=0;i<K+M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a==1) {
                long diff=c-arr[b];
                arr[b]=c;
                update(1,N,1,b,diff);
            }
            else System.out.println(sum(1,N,b,(int)c,1));
        }
    }static long init(int start, int end, int node) {
        if(start==end) return segment[node]=arr[start];
        int mid=(start+end)/2;
        return segment[node]=init(start, mid, node*2)+init(mid+1,end,node*2+1);
    }static long sum(int start, int end, int left, int right, int node) {
        if(left>end||right<start) return 0;
        if(left<=start&& right>=end) return segment[node];
        int mid=(start+end)/2;
        return sum(start,mid,left, right,node*2)+sum(mid+1, end, left,right,node*2+1);
    }static void update(int start, int end, int node, int idx, long diff) {
        if(idx<start || idx>end) return;
        segment[node]+=diff;
        if(start==end) return;
        int mid=(start+end)/2;
        update(start, mid, node*2,idx, diff);
        update(mid+1, end, node*2+1,idx, diff);
    }
}
