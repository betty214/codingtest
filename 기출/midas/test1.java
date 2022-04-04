package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1 {
    static int []temp;
    static int len;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input/test1.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        temp=new int[1];
        len=1;
        int high=0;

        for(int i=0;i<1;i++){
            temp[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0;i<len;i++){
            high=Math.max(high,temp[i]);
        }

        long[][] answer = new long[high][2];
        for(int i=1;i<=high;i++){
            answer[i-1][0]=i;
            answer[i-1][1]=check(i);
            System.out.println(i+" : "+answer[i-1][1]);
        }

    }static int check(int now){
        int count=0;
        for(int i=0;i<len;i++){
            int m=temp[i];
            for(int j=i;j<len;j++){
                for(int k=i;k<=j;k++){
                    m=Math.min(m,temp[k]);
                }
                if(now==m) {
                    count++;
                }
                System.out.println();
            }
        }
        return count;
    }
}
