package day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex_1927 {
    static ArrayList<Integer>heap;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("code/src/day3/1927.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        heap=new ArrayList<>();
        for(int i=0;i<N;i++){
            int input=Integer.parseInt(br.readLine());
            if(input==0){
                if(heap.isEmpty()) System.out.println(0);
                else heap_delete();
            }else{
                heap.add(input);
                heap_sort();
            }
        }
    }static void heap_sort(){
        int index=heap.size()-1;
        while(index>0){
            if(heap.get(index)<heap.get(index/2)){
                int temp=heap.get(index/2);
                heap.set(index/2,heap.get(index));
                heap.set(index,temp);
                index=index/2;
            }else break;
        }
    }static void heap_delete(){
        System.out.println(heap.get(0));
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int index=0;

        while(index*2<heap.size()){
            int left=index*2;
            int right=index*2+1;

            int min=heap.get(left);
            int minIndex=left;

            if(right<heap.size() && heap.get(right)<min){
                min=heap.get(right);
                minIndex=right;
            }

            if(heap.get(index)>min){
                int temp = heap.get(minIndex);
                heap.set(minIndex,heap.get(index));
                heap.set(index,temp);
                index=minIndex;
            }else break;
        }
    }
}
