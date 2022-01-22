package day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex_14476 {
    public static void main(String[] args)  throws IOException {
        System.setIn(new FileInputStream("code/src/day4/14476.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []arr=new int[N];int []left=new int[N];int []right=new int[N];int []diff=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(i==0) left[i]=arr[i];
            else left[i]=gcd(left[i-1],arr[i]);
        }
        for(int i=N-1;i>=0;i--){
            if(i==N-1) right[i]=arr[i];
            else right[i]=gcd(right[i+1],arr[i]);
        }
        int max=0;
        int maxIndex=-1;
        diff[0]=right[1];
        if(diff[0]>max){
            max=diff[0];
            maxIndex=0;
        }
        diff[N-1]=left[N-2];
        if(diff[N-1]>max){
            max=diff[N-1];
            maxIndex=N-1;
        }
        for(int i=1;i<N-1;i++){
            diff[i]=gcd(left[i-1],right[i+1]);
            if(diff[i]>max){
                max=diff[i];
                maxIndex=i;
            }
        }
        if(arr[maxIndex]%max==0) System.out.println(-1);
        else System.out.println(max+" "+arr[maxIndex]);
    }static int gcd(int a, int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}
