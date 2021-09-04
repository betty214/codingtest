package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer> heap=new ArrayList<>();
        for(int i=0;i<N;i++){
            int input=Integer.parseInt(br.readLine());
            System.out.println(heap);
            if(input==0){
                if(heap.size()==0) {
                    System.out.println(0);
                }else if(heap.size()==1){
                    System.out.println(heap.get(0));
                    heap.remove(0);
                }else{
                    int deleteitem = heap.get(1);
                    heap.set(1,heap.get(heap.size()-1));
                    heap.remove(heap.size()-1);

                    int pos = 1;
                    while((pos*2)<heap.size()) {
                        int min = heap.get(pos*2);
                        int minPos = pos*2;

                        if(((pos*2+1)<heap.size()) && min > heap.get(pos*2+1)) {
                            min = heap.get(pos*2 +1);
                            minPos = pos*2 +1;
                        }
                        if(min > heap.get(pos))
                            break;
                        int tmp = heap.get(pos);
                        heap.set(pos,heap.get(minPos));
                        heap.set(minPos, tmp);
                        pos = minPos;
                    }
                    System.out.println(deleteitem);
                }
            }else{
                heap.add(input);
                int p = heap.size()-1;
                while(p>1 && heap.get(p/2)>heap.get(p)) {
                    int tmp = heap.get(p/2);
                    heap.set(p/2, input);
                    heap.set(p, tmp);
                    p /= 2;
                }
            }
        }
    }
}
