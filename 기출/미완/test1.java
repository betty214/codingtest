package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class test1 {
    static int [][] dist;
    static int len;
    static ArrayList<int[]>answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hmap = new HashMap<>();
        len=5;
        dist = new int [len][len];

        for(int i=0;i<len;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<len;j++){
                dist[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        answer=new ArrayList<>();
        comb(new ArrayList<>());
        for(int i=0;i<2;i++){
            for(int j=0;j<len;j++){
                System.out.print(answer.get(i)[j]+" ");
            }
            System.out.println();
        }
    }static void comb(ArrayList<Integer>order){
        if(order.size()==len){
            makeDiff(order);
            return;
        }

        for(int i=0;i<len;i++){
            if(!order.contains(i)){
                order.add(i);
                comb(order);
                order.remove(order.size()-1);
            }
        }
    }static void makeDiff(ArrayList<Integer>order){
        int[]diff=new int[len-1];
        int now = order.get(0);
        for(int i=1;i<len;i++){
            diff[i-1]=dist[now][order.get(i)];
            now=order.get(i);
        }
        check(diff,order);
    }static void check(int[]diff, ArrayList<Integer>order){
        boolean flag =true;
        for(int i=0;i<len;i++){
            int now=0;
            for(int j=i+1;j<len;j++){
                now+=diff[j-1];
                if(now!=dist[order.get(i)][order.get(j)]){
                    flag=false;
                    break;
                }
            }
            if(!flag) break;
        }
        if(flag) {
            int[]ans=new int[len];
            for(int i=0;i<len;i++){
                ans[i]=order.get(i);
            }
            answer.add(ans);
        }
    }
}
