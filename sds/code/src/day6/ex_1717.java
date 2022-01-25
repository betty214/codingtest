package day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1717 {
    static int []group;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day6/1717.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        group=new int[n+1];
        for(int i = 0 ; i<= n ; i++) {
            group[i] = i;
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(op==0)add(first,second);
            else{
                if(find(first)==find(second)) System.out.println("YES");
                else System.out.println("NO");
            };
        }
    }static void add(int x, int y){
        int gx=find(x);
        int gy=find(y);
        group[gx]=gy;
    }static int find(int x){
        if(group[x]==x) return x;
        return group[x]=find(group[x]);
    }
}
