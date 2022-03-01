public class Solution {
    public long solution(int[][] land, int P, int Q) {
        int N=land.length;
        int max=-1;
        int min=1000000001;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(land[i][j]<min){
                    min=land[i][j];
                }if(land[i][j]>max){
                    max=land[i][j];
                }
            }
        }
        long DP[]=new long[max-min+1];
        int DP_now=min;
        int DP_index=0;
        long answer = Long.MAX_VALUE;
        while(DP_index<DP.length){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(land[i][j]>DP_now){
                    DP[DP_index]+=(land[i][j]-DP_now)*Q;
                }else if(land[i][j]<DP_now){
                    DP[DP_index]+=(DP_now-land[i][j])*P;
                }
            }
        }
            answer=Math.min(answer,DP[DP_index]);
            DP_index++;
            DP_now++;
        }
        
        return answer;
    }
}