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
            return;
        }

        for(int i=0;i<4;i++){
            if(pos[i]==40) continue;
            int pre=pos[i];
            int premod=mod[i];
            int tmp=move(next[nindex],i,score[i], mod, pre);
            if(tmp==0) continue;
            for(int j=0;j<4;j++){
                if(j!=i  && tmp!=pos[j]) continue;
            }

            pos[i]=tmp;
            score[i]+=pos[i];
            if(pos[i]==10) mod[i]=1;
            else if(pos[i]==20) mod[i]=2;
            else if(pos[i]==30) mod[i]=3;
            System.out.println(nindex);
            print(score, pos,mod);

            dfs(nindex+1,score,pos,mod);

            mod[i]=premod;
            pos[i]=pre;
            score[i]-=tmp;
        }
    }
    static int move(int n, int idx,int now,int[]mod, int pre){
        int index;
        int ret=0;
        if(now==40) return 0;
        switch(mod[idx]){
            //2씩 증가
            case 0:
                ret=pre+2*n;
                break;
            //10~40
            case 1:
                index=from10.indexOf(pre);
                n+=index;
                if(n>7) n=7;
                ret=from10.get(n);
                break;
            //20~40
            case 2:
                index=from20.indexOf(pre);
                n+=index;
                if(n>6) n=6;
                ret=from20.get(n);
                break;
            //30~40
            case 3:
                index=from30.indexOf(pre);
                n+=index;
                if(n>7) n=7;
                ret=from30.get(n);
                break;
        }
        return ret;
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
