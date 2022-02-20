package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_1062 {
    static int answer,N,K,bit;
    static String[]word;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/input/1062.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bit = (1<<('a'-'a'))|(1<<('n'-'a'))|(1<<('t'-'a'))|(1<<('i'-'a'))|(1<<('c'-'a'));
        word=new String[N];
        if(K<5) System.out.println(0);
        else if(K==26) System.out.println(N);
        else{
            for(int i=0;i<N;i++){
                String now = br.readLine();
                word[i]=now;
            }
            comb(0,0,bit);
            System.out.println(answer);
        }
    }static void comb(int depth, int start, int bit){
        if(depth==K-5){
            int temp=0;
            for(int i=0;i<N;i++){
                boolean flag=true;
                for(int j=0;j<word[i].length();j++){
                    if((bit & 1 <<(word[i].charAt(j)-'a')) ==0){ //해당되지 않는 알파벳이 섞여있는 단어는 제외
                        flag=false;
                        break;
                    }
                }if(flag) temp++;
            }answer=Math.max(answer,temp);
        }else{
            for(int i=start;i<26;i++){
                if((bit&(1<<i))!=0) continue; //이미 방문한 곳 제외
                comb(depth+1,i+1,bit|1<<i);
            }
        }
    }
}
