package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_3109 {
    static int R,C,count;
    static boolean flag;
    static boolean isVisited[][];
    static char pipe[][];
    static int dy[] = {-1,0,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        pipe=new char[R][C];
        isVisited=new boolean[R][C];
        for(int i=0;i<R;i++){
            String s=br.readLine();
            pipe[i]=s.toCharArray();
        }
        count=0;
        for (int i = 0; i < R; i++) {
            flag = false;
            DFS(i, 0);
        }
        System.out.println(count);
    }
    static void DFS(int y, int x){
        if(x==C-1){
            flag=true;
            count++;
            return;
        }else{
            for(int i = 0; i < 3; i++) {
                int row = y + dy[i];
                int col = x + 1;
                if(isRangeTrue(row, col)){
                    if (isVisited[row][col] == false && pipe[row][col] == '.') {
                        isVisited[row][col] = true;
                        DFS(row, col);
                        if(flag){
                            return;
                        }
                    }
                }
            }
        }
    }
    static boolean isRangeTrue(int x, int y){
        if (x < 0 ||x >= R || y< 0 || y >= C) {
            return false;
        }
        return true;
    }
}
