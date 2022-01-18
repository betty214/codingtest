package day1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex_1065 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day1/1065.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=1;i<=N;i++){
            if(i<100) count++;
            else{
                int first=i/100;
                int second=i%100/10;
                int third=i%100%10;
                if(second-first==third-second) count++;
            }
        }
        System.out.println(count);
    }
}
