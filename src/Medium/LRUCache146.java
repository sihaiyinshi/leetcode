package Medium; /**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 * */
import java.util.*;

public class LRUCache146 {


    public static void main(String[] args) {



        class LRUCache {
                final int capacity;
                HashMap<Integer, Integer> map=new HashMap<>();
                //int tick=0;

                LinkedList<Integer> list=new LinkedList<>();


                //HashMap<Integer, Integer> tickMap=new HashMap<>();
                //TreeSet<Integer> set;


                public LRUCache(int capacity) {
                    this.capacity = capacity;
                }

                public int get(int key){
                    //tick++;
                    if(map.containsKey(key)){
                        //set.add(tick);
                        //tickMap.put(key, tick);
                        list.remove(Integer.valueOf(key));
                        list.addLast(key);
                        //System.out.println(map.get(key));
                        return map.get(key);
                    }
                    //System.out.println(-1);
                    return -1;
                }

                public void put(int key, int value){
                    //tick++;
                    if(map.containsKey(key)){
                        map.put(key, value);
                        list.remove(Integer.valueOf(key));
                    }
                    else if(map.size() < capacity ){
                        map.put(key, value);
                    }
                    else{
                        int MinKey=list.getFirst();
                        map.remove(MinKey);
                        //set.remove(getKeyOfMinimumTick());
                        //tickMap.remove(MinKey);
                        map.put(key, value);
                        list.removeFirst();
                    }
                    list.addLast(key);
                }

            /*
            public int getKeyOfMinimumTick(){
                int minTick = Integer.MAX_VALUE;
                int temp=-1;
                for(Integer key : tickMap.keySet()){
                    if(tickMap.get(key) < minTick){
                        minTick = tickMap.get(key);
                        temp=key;
                    }
                }
                return minTick==Integer.MAX_VALUE?-1:temp;
            }*/


        }




        /*


        class LRUCache {

            final int capacity;
            HashMap<Integer, Integer> map=new HashMap<>();
            Queue<Integer> queue = new LinkedList<Integer>();


            public LRUCache(int capacity) {
                this.capacity = capacity;
            }


            public int get(int key) {
                if(this.map.containsKey(key)) {
                    queue.remove(key);
                    queue.offer(key);
                    return this.map.get(key);
                }
                return -1;


            }

            public void put(int key, int value) {

                if(this.map.size() < this.capacity) {
                        this.map.put(key, value);
                        queue.offer(key);
                }
                else {
                    int first = queue.poll();
                    queue.remove(first);

                    if(!map.containsKey(key)) {
                        map.remove(first);
                    }

                    this.map.put(key, value);
                    queue.offer(key);
                }
            }


        }
*/


        /*
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
*/

        /*
        LRUCache cache=new LRUCache(2);
        cache.get(2);
        cache.put(2,6);
        cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        cache.get(1);
        System.out.println(cache.get(2));
        */


        /*
        LRUCache lRUCache=new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
        */


        LRUCache cache=new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);





    }

    /*Note:
     * Unknown:
     * 1. LinkedList
     *
     * My opinion:
     * use HashMap + ascending tick to make time-counting
     *
     * His opinion:
     * use linkedlist to count the time
     *
     * Hint:
     * Some of the data structure is able to record the order and the time, like queue and Heap, and queue is actually a simple linkedlist and can be used to deduct the time complexity
     * */



}
