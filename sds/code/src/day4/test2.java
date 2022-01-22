package day4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
디렉터리 안에 있는 모든 파일들의 크기의 합을 계산하는 함수를 작성해 주세요.
* */
public class test2 {
    static private class Dir{
        ArrayList<Dir> childD=new ArrayList<>();
        ArrayList<File> childF=new ArrayList<>();
        public Dir(){}
    }
    static private class File{
        int size;
        public File(int size){
            this.size=size;
        }
    }
    public static void main(String[] args) {
        Dir root = new Dir();
        Dir firstDir = new Dir();
        root.childD.add(firstDir);
        firstDir.childF.add(new File(100));

        int answer=0;
        Queue<Dir>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Dir now= q.poll();
            if(!now.childF.isEmpty()){
                for(int i=0;i<now.childF.size();i++){
                    answer+=now.childF.get(i).size;
                }
            }
        }
    }
}
