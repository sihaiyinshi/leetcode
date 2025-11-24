package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore981 {



    public static void main(String[] args) {


        TimeMap map=new TimeMap();




        map.set("l","h",10);
        map.set("l","low",20);
        System.out.println(map.get("l",5));
        System.out.println(map.get("l",10));
        System.out.println(map.get("l",15));
        System.out.println(map.get("l",20));
        System.out.println(map.get("l",25));

        //map.set("ct", "zt", 1);
        //map.set("vr", "hw", 2);
        //map.set("gs", "zt", 3);
        //map.set("ct", "gs", 4);

        //System.out.println(map.get("gs", 5));
        //System.out.println(map.get("ct", 6));


        //map.set("ll", "h", 10);
        //map.set("ll", "l", 20);
        //map.set("foo", "bar", 10);
        //map.set("foo", "bar2", 15);
        //System.out.println(map.get("ll", 5));
        //System.out.println(map.get("ll", 10));
        //System.out.println(map.get("ll", 15));
        //System.out.println(map.get("ll", 20));
        //System.out.println(map.get("ll", 25));


        //map.set("foo", "bar", 10);
        //System.out.println(map.get("foo", 1));
        //System.out.println(map.get("foo", 3));
        //map.set("foo", "bar2", 15);
        //System.out.println(map.get("foo", 15));
        //System.out.println(map.get("foo", 12));
        //System.out.println(map.get("foo", 5));
        //System.out.println(map.get("hol", 5));

    }


    public static class TimeMap {

        HashMap<String, TreeMap<Integer, String>> map=new HashMap<>();

        public TimeMap() {

        }


        public void set(String key, String value, int timestamp) {

            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);

        }

        public String get(String key, int timestamp) {

            if (!map.containsKey(key)) return "";
            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();

        }


        /*Notes:
        *
        * Unknown:
        * 1. HashMap is able to put object as value, and object can also be another hashmap/treemap
        * 2. TreeMap
        * 3. Method of floorEntry
        *
        *
        * */









        /*

        ArrayList<String> key=new ArrayList<>();
        ArrayList<String> value=new ArrayList<>();
        ArrayList<Integer> timeStamp=new ArrayList<>();



        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {

            int index=findFirstKey(key);


            if(index!=-1){
                index=findLocForInsert(index,key,timestamp);
                this.key.add(index,key);
                this.value.add(index,value);
                this.timeStamp.add(index,timestamp);
            }
            else{
                this.key.add(key);
                this.value.add(value);
                this.timeStamp.add(timestamp);
            }

        }

        public String get(String key, int timestamp) {

            int index=findFirstKey(key);
            if(index==-1){
                return "";
            }

            index=findLocForRead(index, key, timestamp);
            return index==-1?"":this.value.get(index);


        }


        private int findFirstKey(String key) {

            for(int i=0;i<this.key.size();i++){
                if(this.key.get(i).equals(key)){
                    return i;
                }
            }
           return -1;

        }

        private int findLocForInsert(int index, String key, int timestamp) {


            for(int i=index;i<this.key.size();i++){

                if(i==this.key.size()-1){
                    return this.key.size();
                }
                else if(!this.key.get(i+1).equals(key)){
                    return i+1;
                }
                else if(this.timeStamp.get(i)<=timestamp && this.timeStamp.get(i+1)>timestamp){
                    return i+1;
                }

            }

            return -1;
        }


        private int findLocForRead(int index, String key, int timestamp) {

            if(this.timeStamp.get(index)> timestamp){
                return -1;
            }

            for(int i=index;i<this.key.size();i++){

                if(i==this.key.size()-1){
                    return this.key.size()-1;
                }
                else if(!this.key.get(i+1).equals(key)){
                    return i;
                }
                else if(this.timeStamp.get(i)<=timestamp && this.timeStamp.get(i+1)>timestamp){
                    return i;
                }

            }
            return -1;

        }

*/

    }







}
