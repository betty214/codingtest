package day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ex_1759 {
    static char[]alpha;
    static ArrayList<String> answer;
    static int L,C;
    static ArrayList<Character> vowel;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day1/1759.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha=new char[C];
        answer=new ArrayList<>();
        vowel=new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++){
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);
        vowel.add('a');vowel.add('e');vowel.add('i');vowel.add('o');vowel.add('u');
        for(int i=0;i<C-3;i++){
            ArrayList<Character>s=new ArrayList<Character>();
            s.add(alpha[i]);
            DFS(i,s);
        }

        for(int i=0;i< answer.size();i++){
            System.out.println(answer.get(i));
        }

    }static void DFS(int start, ArrayList<Character>now){
        if(now.size()==L){ //2.목적지인가?
            String ans="";
            for(int i=0;i<L;i++){
                ans+=now.get(i);
            }
            if(!answer.contains(ans)) {
                int count=0;
                for(int i=0;i<now.size();i++){
                    char n = now.get(i);
                    if(vowel.contains(n)){
                        count++;
                    }
                }
                if(count>0 && count<=L-2) answer.add(ans);
            }
        }else{
            for(int i=start+1;i<C;i++){ //3.연결된 곳 순회
                now.add(alpha[i]);
                DFS(i,now); //5.간다.
                now.remove(now.size()-1);
            }
        }
    }
}
