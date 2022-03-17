package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_16235 {
    static ArrayList<Tree>t,dead,temp;
    static int [][]A,land;
    static int N;
    static int[]dx={1,-1,0,0,1,1,-1,-1};
    static int[]dy={0,0,1,-1,1,-1,1,-1};
    static class Tree implements Comparable<Tree>{
        int year;
        int x;
        int y;
        boolean death=false;
        public Tree(int x, int y,int year){
            this.year=year;
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Tree o) {
            return this.year-o.year;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "year=" + year +
                    ", x=" + x +
                    ", y=" + y +
                    ", death=" + death +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/16235.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        A =new int[N][N];
        land=new int[N][N];
        t = new ArrayList<>();
        dead=new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                land[i][j]=5;
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            t.add(new Tree(x,y,z));
        }
        for(int i=0;i<K;i++){
            Collections.sort(t);
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(t.size());
    }static void spring(){
        temp = new ArrayList<>();
        for(int i=0;i<t.size();i++){
            Tree now = t.get(i);
            if(land[now.x-1][now.y-1]<now.year) now.death=true;
            else {
                land[now.x-1][now.y-1]-=now.year;
                now.year++;
            }
        }
        for(int i=0;i< t.size();i++){
            Tree now = t.get(i);
            if(now.death){
                dead.add(now);
            }else{
                temp.add(now);
            }
        }
        t.clear();
        t.addAll(temp);
    }static void summer(){
        for(int i=0;i< dead.size();i++){
            Tree now = dead.get(i);
            land[now.x-1][now.y-1]+=(int)(now.year/2);
        }
        dead.clear();
    }static void autumn(){
        for(int i=0;i<t.size();i++) {
            Tree now = t.get(i);
            if(now.year%5==0){
                for(int j=0;j<8;j++){
                    int cx=now.x+dx[j];
                    int cy=now.y+dy[j];
                    if(check(cx-1,cy-1)){
                        t.add(new Tree(cx,cy,1));
                    }
                }
            }
        }
    }static void winter(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                land[i][j]+=A[i][j];
            }
        }
    }static boolean check(int x, int y){
        if(x<0||y<0||x>=N||y>=N) return false;
        return true;
    }
    static void print(){
        for(int i=0;i<t.size();i++) {
            System.out.print(t.get(i));
        }
    }
}
