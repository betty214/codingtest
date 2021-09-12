package backjun;

public class test_2 {
    /*
    import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int N=id_list.length;
            HashMap<String,String> rep = new HashMap<>();
            HashMap<String,Integer> index = new HashMap<>();
            ArrayList<String> out = new ArrayList<>();
            for(int i=0;i<N;i++){
                rep.put(id_list[i],"");
                index.put(id_list[i],i);
            }
            for(int i=0;i<report.length;i++){
                String start=report[i].split(" ")[0];
                String end=report[i].split(" ")[1];
                if(rep.get(end)!=""){
                    if(!rep.get(end).contains(start)){
                        rep.put(end,rep.get(end)+" "+start);
                    }
                }else{
                    rep.put(end,start);
                }
            }
            Iterator<String> keys = rep.keySet().iterator();
            while( keys.hasNext() ){
                String key = keys.next();
                if(rep.get(key).split(" ").length>=k){
                    out.add(key);
                }
            }
            int[] answer = new int[N];
            for(int i=0;i<out.size();i++){
                String []out_list=rep.get(out.get(i)).split(" ");
                for(int j=0;j<out_list.length;j++){
                    answer[index.get(out_list[j])]++;
                }
            }

            return answer;
        }
    }*/
}
