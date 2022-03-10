package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex_15685 {
    static int N;
    static boolean[][] fillX, fillY;
    static ArrayList<Node>now;
    private static class Node{
        int x;
        int y;
        int dir;
        public Node(int x,int y,int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/15685.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fillX = new boolean[100][100];
        fillY = new boolean[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            now=new ArrayList<>();
            now.add(new Node(x,y,d));
            makeG(0,g);
        }
    }static void makeG(int depth, int g){
        if(depth==g) return;

        Node n = now.get(now.size()-1);
        int nowX=n.x;
        int nowY=n.y;
        ArrayList<Node>temp=new ArrayList<>();
        for(int i=0;i<now.size();i--){
            n = now.get(i);
            switch (n.dir) {
                case 0:
                    fillX[nowY][nowX] = true;
                    nowX=n.x+1;
                    nowY=n.y;
                    break;
                case 1:
                    fillY[nowY - 1][nowX] = true;
                    nowX=n.x;
                    nowY=n.y;
                    break;
                case 2:
                    fillX[nowY][nowX - 1] = true;
                    nowX=n.x;
                    nowY=n.y;
                    break;
                case 3:
                    fillY[nowY][nowX] = true;
                    nowX=n.x;
                    nowY=n.y+1;
                    break;
            }

            int nowD=n.dir;
            if(g!=1) nowD++;
            if(nowD==4) nowD=0;
            now.add(new Node(nowX,nowY,nowD));
        }makeG(depth+1,g);
    }
    static void print(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(fillX[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(fillY[i][j]+" ");
            }
            System.out.println();
        }
    }
}
