class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int max=Math.max(w,h);
        if(check(h)&&check(w)){
            answer=(long)max;
        }else{
            int min=Math.min(w,h);
            answer=(long)(w*h-(max+(int)(min/2)));
        }
        return answer;
    }public boolean check(int x){
        while(true){
            if(x%2==0){
                if(x==2){
                    break;
                }else{
                    x/=2;                   
                }
            }else{
                return false;
            }
        }
        return true;
    }
}