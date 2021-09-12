package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
            String change = "";
            while (n > 0) {
                change = Integer.toString(n % k) + change;
                n /= k;
            }
            int answer = 0;
            String temp = "";
            for (int i = 0; i < change.length(); i++) {
                if (change.charAt(i) == '0') {
                    if (temp != "") {
                        if (prime(Integer.parseInt(temp))) {
                            answer++;
                        }
                    }
                    temp = "";
                } else {
                    temp += change.charAt(i);
                }
            }
            if (temp != "") {
                if (prime(Integer.parseInt(temp))) {
                    answer++;
                }
            }
            System.out.println(answer);
    }static boolean prime(int num){
        if(num<2){
            return false;
        }else if(num==2){
            return true;
        }else{
            for(int i=2;i<num;i++){
                if(num%i==0){
                    return false;
                }
            }return true;
        }
    }
}
