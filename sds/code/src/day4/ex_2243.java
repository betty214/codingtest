package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_2243 {
    static long[]indexed_tree;
    static int node;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day4/2243.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long max=0;
        indexed_tree=new long[2000000];
        node=1000000;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            if(A==2) {
                long C = Long.parseLong(st.nextToken());
                max=Math.max(B,max);
                int index= (int) (node+B-1);
                if(C==-1) indexed_tree[index]--;
                else indexed_tree[index]=C;
                index/=2;
                while(index>0){
                    indexed_tree[index]+=C;
                    index/=2;
                }
            }else out(B);
        }

    }static void out(long rank){
        int index=1;
        while(index<node){
            if(indexed_tree[index]>=rank) {
                indexed_tree[index]--;
                index*=2;
            }
            else {
                indexed_tree[index]--;
                index++;
            }
        }
        System.out.println(index-node+1);
        indexed_tree[index]--;
    }
}
