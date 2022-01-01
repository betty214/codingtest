/*
class Solution {
    int t,g,up;
    public int solution(int time, int gold, int[][] upgrade) {
        int answer = 0;
        t=time;
        g=gold;
        up=upgrade.length;
        for(int i=0;i<upgrade.length;i++){
            int ans=dig(i,upgrade);
            if(ans>answer){
                answer=ans;
            }
        }
        return answer;
    }int dig(int upper_bound,int[][] upgrade){
        int time = t;
        int gold = g;
        boolean flag=false;
        int gok = upgrade[0][1];
        int money =upgrade[0][0];
        int ans=0;
        int index=1;
        int next_money=upgrade[index][0];
        if(upper_bound==0){
            while(time>=gok){
                ans+=gold;
                time-=gok;
            }
        }else{
            while(time>=gok){
                while(ans<next_money && time<gok){
                    ans+=gold;
                    time-=gok;
                }
                if(!flag && time>=gok){
                    while(ans-next_money>=0){
                        if(index>upper_bound){
                            while(time<gok){
                                ans+=gold;
                                time-=gok;
                            }
                        }else{
                            ans-=next_money;
                            gok=upgrade[index][1];
                            index++;
                            if(index>=up){
                                flag=true;
                                break;
                            }
                            next_money=upgrade[index][0];
                        }
                    }
                }
            }

        }

        return ans;
    }
}
import java.util.ArrayList;
class Solution {
    int player_health,player_attack,player_defense;
    public String solution(String character, String[] monsters) {
        String []player=character.split(" ");
        int len=monsters.length;
        ArrayList<String> mob_name = new ArrayList<>();
        ArrayList<Float> mob_exp = new ArrayList<>();
        ArrayList<Integer> mob_total = new ArrayList<>();
        String answer = "";
        player_health=Integer.parseInt(player[0]);
        player_attack=Integer.parseInt(player[1]);
        player_defense=Integer.parseInt(player[2]);
        float max=-1;
        int max_total=-1;
        for(int i=0;i<len;i++){
            String []temp =monsters[i].split(" ");
            int[] now=play(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
            float time=now[1];
            float exp=now[0];
            if(now[0]>0){
                float now_exp=exp/time;
                if(now_exp>max){
                    max=now_exp;
                    max_total=now[0];
                    answer=temp[0];
                }else if(now_exp==max){
                    if(max_total<now[0]){
                        max=now_exp;
                        max_total=now[0];
                        answer=temp[0];
                    }
                }
            }
        }
        return answer;
    }int[] play(String name, int exp, int h, int a, int d){
        int []ans=new int[2];
        int p_health=player_health;
        int time=0;
        while(p_health>0 && h>0){
            p_health=player_health;
            int p_attack=player_attack-d;
            if(p_attack>0){
                h-=p_attack;
                time++;
            }
            if(h<=0){
                break;
            }
            int mob_attack=a-player_defense;
            if(mob_attack>0){
                p_health-=mob_attack;
            }
            if(p_attack<=0){
                p_health=-1;
                break;
            }
        }
        if(p_health<=0){
            ans[0]=0;
        }else{
            ans[0]=exp;
        }
        ans[1]=time;
        return ans;
    }
}*/