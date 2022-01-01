package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_16235 {
    private static class tree implements Comparable<tree>{
        int x;
        int y;
        int year;
        boolean dead=false;
        public tree(int x,int y,int year){
            this.x=x;
            this.y=y;
            this.year=year;
        }

        @Override
        public int compareTo(tree o) {
            return this.year-o.year;
        }
    }
    static int[][]land,add;
    static int N,M,K;
    static ArrayList<tree>tree_list,dead_list,temp_list;
    static int[] dx = {1, -1, 0, 0,1,1,-1,-1};
    static int[] dy = {0, 0, 1, -1,1,-1,1,-1};
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        add=new int[N][N];
        land=new int[N][N];
        tree_list=new ArrayList<>();
        dead_list=new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                add[i][j]=Integer.parseInt(st.nextToken());
                land[i][j]=5;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            tree_list.add(new tree(x,y,z));
        }
        for(int i=0;i<K;i++){
            Collections.sort(tree_list);
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(tree_list.size());
    }
    static void spring(){
        temp_list=new ArrayList<>();
        for(int i=0;i< tree_list.size();i++){
            tree now = tree_list.get(i);
            if(land[now.x-1][now.y-1]<now.year){
                now.dead=true;
            }else{
                land[now.x-1][now.y-1]-=now.year;
                now.year++;
            }
        }
        for(int i=0;i< tree_list.size();i++){
            tree now = tree_list.get(i);
            if(now.dead){
                dead_list.add(now);
            }else{
                temp_list.add(now);
            }
        }
        tree_list.clear();
        tree_list.addAll(temp_list);
    }
    static void summer(){
        for (int i=0;i< dead_list.size();i++){
            tree now = dead_list.get(i);
            land[now.x-1][now.y-1]+=(int)(now.year/2);
        }
        dead_list.clear();
    }
    static void autumn(){
        for(int i=0;i< tree_list.size();i++){
            tree now = tree_list.get(i);
            if(now.year%5==0){
                for(int j=0;j<8;j++){
                    int cx=now.x+dx[j];
                    int cy=now.y+dy[j];
                    if(check(cx-1,cy-1)){
                        tree_list.add(new tree(cx,cy,1));
                    }
                }
            }
        }
    }
    static void winter(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                land[i][j]+=add[i][j];
            }
        }
    }
    static boolean check(int x, int y){
        if(x<0||y<0||x>=N||y>=N){
            return false;
        }else{
            return true;
        }
    }

}
