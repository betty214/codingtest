package day2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ex_2143 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day2/2143.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T=Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long []A=new long[n];
        long sumA=0;
        for(int i=0;i<n;i++){
            sumA+=Long.parseLong(st.nextToken());
            A[i]=sumA;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long []B=new long[m];
        long sumB=0;
        for(int i=0;i<m;i++){
            sumB+=Long.parseLong(st.nextToken());
            B[i]=sumB;
        }
        ArrayList<Long>subA=new ArrayList<>();
        for(int i=0;i<n;i++){
            subA.add(A[i]);
            for(int j=i+1;j<n;j++){
                if(i==j) continue;
                subA.add(A[j]-A[i]);
            }
        }
        ArrayList<Long>subB=new ArrayList<>();
        for(int i=0;i<m;i++){
            subB.add(B[i]);
            for(int j=i+1;j<m;j++){
                if(i==j) continue;
                subB.add(B[j]-B[i]);
            }
        }
        Collections.sort(subB);Collections.sort(subA);
        int indexA=0;
        int indexB=subB.size()-1;
        int count=0;
        while(indexA<subA.size() && indexB>=0){
            long sum=subA.get(indexA)+subB.get(indexB);
            if(sum<T){
                indexA++;
            }else if(sum>T){
                indexB--;
            }else{
                long pre=subA.get(indexA);
                int numA=0;
                while(subA.get(indexA)==pre && indexA<subA.size()){
                    indexA++;
                    numA++;
                }
                pre=subB.get(indexB);
                int numB=0;
                while(subB.get(indexB)==pre && indexB>0){
                    indexB--;
                    numB++;
                }
                indexB=subB.size()-1;
                if(numA==0) count+=numB;
                if(numB==0) count+=numA;
                count+=numA*numB;
            }
        }
        System.out.println(count);
    }
}
