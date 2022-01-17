package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
자연수를 순서대로 이어 적은 무한히 긴 문자열이 있다.
12345678910111213...
k를 입력하면 k번째 숫자가 무엇인지 출력하는 함수를 작성해주세요.
예: f(7) → 7, f(19) → 4
* * */
public class test_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int now=1;
        int i=1;
        int j=0;
        while(i<=k){
            if(now<10){
                i++;
                now++;
            }
            else if(now<100){
                i++;
                if(j>1){
                    j=0;
                    now++;
                }
            }
        }
    }
            /*
        if(k<10) System.out.println(k);
        else if(k<190){
            int index=(k-10)/2;
            if((k-10)%2==0) System.out.println((index+10)/10);
            else System.out.println((index+10)%10);
        }else if(k<1090){
            int index=(k-190)/3;
            int hundred=(index+100)/100;
            int ten=((index+100)%100)/10;
            int one=((index+100)%100)%10;
            if((k-190)%3==0) System.out.println(hundred);
            else if((k-190)%3==1) System.out.println(ten);
            else if((k-190)%3==2) System.out.println(one);
        }*/
}
