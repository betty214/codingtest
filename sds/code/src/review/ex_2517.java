package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ex_2517 {
    static ArrayList<Integer>sort;
    static long[]segment;
    static int[]arr;
    static int N;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/2517.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[]index=new int[N];
        sort=new ArrayList<>();
        for(int i=0;i<N;i++){
            index[i]=Integer.parseInt(br.readLine());
            sort.add(index[i]);
        }
        Collections.sort(sort);
        segment=new long[N*4];
        for(int i=0;i<N;i++){
            System.out.println(run(index[i]));
            System.out.println();
        }
    }static void update(int start, int end, int node, int idx) {
        if(idx<start || idx>end) return;
        segment[node]+=1;
        if(start==end) return;
        int mid=(start+end)/2;
        update(start, mid, node*2,idx);
        update(mid+1, end, node*2+1,idx);
    }static long run(int now){
        int index=sort.indexOf(now);
        long ans=sum(0,N-1, index+1, N-1,0);
        update(0,N-1,0,index);
        for(int i=0;i<N;i++){
            System.out.print(segment[i]+" ");
        }
        System.out.println();
        return ans;
    }static long sum(int start, int end, int left, int right,int node){
        if(left>end||right<start) return 0;
        if(left<=start&& right>=end) return segment[node];
        int mid=(start+end)/2;
        return sum(start, mid, left, right, node*2)+sum(mid+1,end, left, right, node*2+1);
    }
}
