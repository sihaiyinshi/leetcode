package ToBeSolved;
import java.util.*;

public class TaskScheduler621 {



    public static void main(String[] args) {



        //System.out.println(leastInterval(new char[]{'A','C','A','B','D','B'},0));
        //System.out.println(leastInterval(new char[]{'A','A','B'},2));
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }


    public static int leastInterval(char[] tasks, int n){

        int[] freq = new int[26];
        int[] freq0 = new int[26];
        Arrays.fill(freq0, 0);

        for(char c : tasks){
            freq[c-'A']++;
        }


        int[] timeslot=new int[26];
        Arrays.fill(timeslot,-100);
        int timestamp=1;
        whileTrue: while(true) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] == 0) {
                    continue;
                }

                if(timestamp-timeslot[i]>n){
                    freq[i]--;
                    timeslot[i]=timestamp;
                }

                if(Arrays.equals(freq,freq0)){
                    break whileTrue;
                }
                else{
                    timestamp++;
                }




            }
        }


        return timestamp;

    }





    public static int leastInterval2(char[] tasks, int n) {


        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }

        List sortedKeys=new ArrayList(map.values());
        Collections.sort(sortedKeys);

        int lastNum=(Integer)sortedKeys.get(0);;
        HashMap<Integer,Integer> map2=new HashMap<>();
        map2.put(map.size(),lastNum);

        for(int i=0;i<sortedKeys.size();i++){

            int curNum=(Integer) sortedKeys.get(i);
            if(curNum==lastNum){
                continue;
            }

            map2.put(sortedKeys.size()-i,curNum-lastNum);
            lastNum=curNum;

        }






        int res=0;
        int index=0;
        for(Map.Entry<Integer,Integer> entry:map2.entrySet()){


            if(entry.getKey()>=n+1){
                res+=entry.getKey()*entry.getValue();
            }
            else if(index!=0){
                res+=entry.getValue()*(n+1);
            }
            else{
                res+=(entry.getValue()-1)*(n+1);
                res+=entry.getKey();
            }

            index++;


        }

        return res;


    }




}
