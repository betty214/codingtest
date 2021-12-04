package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ex_10610 {
    static boolean flag=false;
    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N =br.readLine();
        boolean zero_flag=false;
        Integer[]number =new Integer[N.length()];
        int index=0;
        for(int i=0;i<N.length();i++){
            int now =Integer.parseInt(N.substring(i,i+1));
            if(now==0 && !zero_flag){
                zero_flag=true;
            }else{
                number[index]=now;
                index++;
            }
        }
        if(!zero_flag) System.out.println(-1);
        else{
            Integer[]num=new Integer[N.length()-1];
            for(int i=0;i<N.length()-1;i++){
                num[i]=number[i];
            }
            Arrays.sort(num, Comparator.reverseOrder());
            answer=new ArrayList<>();
            perm(num,N.length()-1,0);
            Collections.sort(answer, Collections.reverseOrder());
            System.out.println(answer.get(0));
        }
    }static void perm(Integer[]num,int n,int d){
        if (d == n) {
            int now = 0;
            int dec=1;
            for (int i = d-1; i >= 0; i--){
                now+=num[i]*dec;
                dec*=10;
            }
            if(now%3==0){
                if(!answer.contains(now*10)){
                    answer.add(now*10);
                }
            }
            return;
        }
        for (int i=d; i<n; i++) {
            swap(num, d, i);
            perm(num, n, d + 1);
            swap(num, d, i);
        }
    }static void swap(Integer[]num, int depth, int i) {
        int temp = num[depth];
        num[depth] = num[i];
        num[i] = temp;
    }
}
