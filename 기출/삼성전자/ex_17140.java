package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_17140 {
    static int lenR,lenC;
    static int[][]A;
    private static class Node implements Comparable<Node>{
        int num;
        int count;
        Node(int num, int count){
            this.num=num;
            this.count=count;
        }

        @Override
        public int compareTo(Node o) {
            if(o.count==this.count) return this.num-o.num;
            return this.count-o.count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17140.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        lenR=3;
        lenC=3;
        A=new int[100][100];

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer=0;
        while(true){
            if(A[r-1][c-1]==k) break;
            if(answer>100){
                answer=-1;
                break;
            }
            answer++;
            if(lenR>=lenC){
                sortR();
            }else{
                sortC();
            }
        }
        System.out.println(answer);
    }static void sortR(){
        int maxC=0;
        for(int i=0;i<lenR;i++){
            int []temp=new int[101];
            int m=0;
            int index=0;
            ArrayList<Node>arr=new ArrayList<>();

            for(int j=0;j<lenC;j++){
                temp[A[i][j]]++;
                m=Math.max(m,A[i][j]);
                A[i][j]=0;
            }
            for(int j=1;j<=m;j++){
                if(temp[j]!=0) arr.add(new Node(j,temp[j]));
            }
            Collections.sort(arr);
            for(int j=0;j< arr.size()*2;j+=2){
                A[i][j]=arr.get(index).num;
                A[i][j+1]=arr.get(index).count;
                index++;
            }
            maxC=Math.max(maxC,arr.size()*2);
        }
        lenC=maxC;
    }static void sortC(){
        int maxR=0;
        for(int i=0;i<lenC;i++){
            int []temp=new int[101];
            int m=0;
            int index=0;
            ArrayList<Node>arr=new ArrayList<>();

            for(int j=0;j<lenR;j++){
                temp[A[j][i]]++;
                m=Math.max(m,A[j][i]);
                A[j][i]=0;
            }
            for(int j=1;j<=m;j++){
                if(temp[j]!=0) arr.add(new Node(j,temp[j]));
            }
            Collections.sort(arr);
            for(int j=0;j< arr.size()*2;j+=2){
                A[j][i]=arr.get(index).num;
                A[j+1][i]=arr.get(index).count;
                index++;
            }
            maxR=Math.max(maxR,arr.size()*2);
        }
        lenR=maxR;
    }static void print(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
}
