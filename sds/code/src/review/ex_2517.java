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
        init();
        for(int i=0;i<N;i++){
            System.out.println(run(index[i]));
        }
    }static long run(int i){
        int now = sort.indexOf(i);
        long count=query(0,0,N-1,now+1,N-1);
        update(0,0,N-1,now);
        return count+1;
    }static void init() {
        double treeHeight = Math.ceil(Math.log(N)/Math.log(2))+1;
        long treeNodeCount = Math.round(Math.pow(2, treeHeight));
        segment = new long[Math.toIntExact(treeNodeCount)];
    }static long query(int node, int start, int end, int left, int right) {
        if (end < left || right < start) return 0;
        else if (left <= start && end <= right) return segment[node];
        else {
            return query(node*2, start, (start+end)/2, left, right) + query(node*2+1, (start+end)/2+1, end, left, right);
        }
    }static void update(int node, int start, int end, int index) {
        if (index < start || end < index)  return;
        else {
            segment[node] = segment[node] + 1;
            if (start != end) {
                update(node*2, start, (start+end)/2, index) ;
                update(node*2+1, (start+end)/2+1, end, index) ;
            }
        }
    }
}
