package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ex_17825 {
    static int answer;
    static int []next;
    static List<Integer> from10 = Arrays.asList(10, 13, 16, 19, 25, 30, 35, 40);
    static List<Integer> from20 = Arrays.asList(20, 22, 24, 25, 30, 35, 40);
    static List<Integer> from30 = Arrays.asList(30, 28, 27, 26, 25, 30, 35, 40);

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/17825.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        next=new int[10];
        answer=0;

        for(int i=0;i<10;i++){
            next[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,new int[4],new int[4],new int[4]);

        System.out.println(answer);
    }static void dfs(int nindex, int []score,int[]pos, int []mod){
        int sum=0;
        for(int i=0;i<4;i++){
            sum+=score[i];
        }
        answer=Math.max(answer,sum);
        if(nindex>9){
            System.out.println();
            return;
        }

        for(int i=0;i<2;i++){ //현재 상황에서 어떤 말을 움직일지 다 시험해보기
            if(pos[i]==40) continue; //도착한 말은 움직이지 않기
            //이전 상태 기록해 두기
            int pre=pos[i];
            int premod=mod[i];
            int nextPos=move(next[nindex],premod, pre);//이동한 위치

            //이동할 곳에 누가 있으면 이동 안함
            boolean flag=true;
            for(int j=0;j<4;j++){
                if(nextPos==pos[j] && nextPos!=40) flag=false;
            }
            if(flag && nextPos>0) {
                //실제로 이동시킴
                pos[i]=nextPos;
                if(pos[i]!=40) score[i]+=pos[i];
                //다른 루트를 타면 모드를 변경 시켜줌
                if(pos[i]==10) mod[i]=1;
                else if(pos[i]==20) mod[i]=2;
                else if(pos[i]==30 && mod[i]!=1) mod[i]=3;
                dfs(nindex+1,score,pos,mod); //다음 이동으로 넘어가기

                //원상복구
                mod[i]=premod;
                if(pos[i]!=40) score[i]-=pos[i];
                pos[i]=pre;
            }
        }
    }
    static int move(int n, int nowMod, int nowPos){
        int index;
        int nextPos=0;

        //System.out.println(n+" "+nowMod+" "+nowPos);
        switch(nowMod){
            //2씩 증가
            case 0:
                nextPos=nowPos+2*n;
                if(nextPos>40) nextPos=40;
                break;
            //10~40
            case 1:
                index=from10.indexOf(nowPos);
                n+=index;
                if(n>7) n=7; //도착보다 넘어서면 도착으로 처리
                nextPos=from10.get(n);
                break;
            //20~40
            case 2:
                index=from20.indexOf(nowPos);
                n+=index;
                if(n>6) n=6;
                nextPos=from20.get(n);
                break;
            //30~40
            case 3:
                index=from30.indexOf(nowPos);
                n+=index;
                if(n>7) n=7;
                nextPos=from30.get(n);
                break;
        }
        return nextPos;
    }static void print(int[]score, int[]pos, int[]mod){
        for(int i=0;i<4;i++){
            System.out.print(mod[i]+" ");
        }
        System.out.println();
        for(int i=0;i<4;i++){
            System.out.print(pos[i]+" ");
        }
        System.out.println();
        for(int i=0;i<4;i++){
            System.out.print(score[i]+" ");
        }
        System.out.println();
        System.out.println();
    }
}
