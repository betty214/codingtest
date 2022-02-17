package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_2580 {
    static int[][]sudoku,origin;
    static ArrayList<Node>blank;
    static private class Node{
        int x;
        int y;
        ArrayList<Integer>cand=new ArrayList<>();
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/2580.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku=new int[9][9];
        origin=new int[9][9];
        blank=new ArrayList<Node>();
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                origin[i][j]=Integer.parseInt(st.nextToken());
                sudoku[i][j]=origin[i][j];
                if(sudoku[i][j]==0) {
                    blank.add(new Node(i,j));
                }
            }
        }
        dfs(0, 0);
    }static void dfs(int index, int depth){
        if(depth==blank.size()) print();
        else{
            Node now=blank.get(index);
            find(index,now.x,now.y);
            if(blank.get(index).cand.size()==0){
                init();
            }else{
                sudoku[now.x][now.y]=blank.get(index).cand.get(0);
                dfs(index+1,depth+1);
            }
        }
    }static void print(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }static void find(int index, int x, int y){
        boolean[]out=new boolean[10];
        Arrays.fill(out,false);
        for(int i=0;i<9;i++){
            if(i!=y){
                out[sudoku[x][i]]=true;
            }if(i!=x){
                out[sudoku[i][y]]=true;
            }
        }
        int istart=(x/3)*3;
        int jstart=(y/3)*3;
        for(int i=istart;i<istart+3;i++){
            for(int j=jstart;j<jstart+3;j++){
                if(i==x&&j==y) continue;
                out[sudoku[i][j]]=true;
            }
        }
        for(int i=1;i<=9;i++){
            if(!out[i]) blank.get(index).cand.add(i);
        }
    }static void init(){
        for(int i=0;i<blank.size();i++){
            if(blank.get(i).cand.size()>0) blank.get(i).cand.remove(0);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku[i][j]=origin[i][j];
            }
        }
    }
}
