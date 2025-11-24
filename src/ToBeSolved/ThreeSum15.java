package ToBeSolved;

import java.util.*;

public class ThreeSum15 {



    public static void main(String[] args) {

        //System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
        //System.out.println(threeSum(new int[]{0,0,0}));



        //System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));


        System.out.println(sumEqualTo(new int[]{-1, 0, 0, 1, 2, -1, -4},0));

    }



    public static List<List<Integer>> threeSum(int[] nums) {





        return null;





        /*
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> hashvalue = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            List<HashSet<Integer>> list = sumEqualTo(Arrays.copyOfRange(nums,i,nums.length), -nums[i]);
            if(!list.isEmpty()) {

                for(HashSet<Integer> set : list) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(set);

                    if(!hashvalue.contains(temp.hashCode())) {
                        res.add(temp);
                        hashvalue.add(nums[i]);
                    }

                }


            }


        }
        return res;*/




    }


    public static List<HashSet<Integer>> sumEqualTo(int[] nums, int target) {


        Map<Integer, Integer> freq = new HashMap<>();
        List<HashSet<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int complement = target - num;

            if (freq.getOrDefault(num, 0) > 0 && freq.getOrDefault(complement, 0) > 0) {
                if (num == complement && freq.get(num) < 2) continue;

                HashSet<Integer> pair = new HashSet<>(Arrays.asList(num, complement));
                if (!result.contains(pair)) result.add(pair);

                freq.put(num, freq.get(num) - 1);
                freq.put(complement, freq.get(complement) - 1);
            }
        }

        return result;

        /*
        HashMap<Integer, Integer> map = new HashMap<>();
        List<HashSet<Integer>> res = new ArrayList<>();

        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i:nums){
            if(map.containsKey(target - i)){
                if(i == target/2){
                    if(map.get(target - i) == 2){
                        map.remove(target - i);
                    }
                    else{
                        map.put(target - i, map.get(target - i) - 2);
                    }
                }
                else if(map.get(target - i)==1){
                    map.remove(target - i);
                }
                else{
                    map.put(target - i, map.get(target - i) - 1);
                }
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                set.add(target-i);
                if(!res.contains(set)) {
                    res.add(set);
                }
            }
        }
        return res;*/
    }




































    public static List<List<Integer>> threeSum2(int[] nums) {


        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            int finalI = i;
            List<int[]> array=twoSum(java.util.stream.IntStream.range(0, nums.length).filter(j -> j != finalI).mapToObj(j -> nums[j]).toArray(Integer[]::new), -nums[i]);

            if(!array.isEmpty()) {

                for(int[] a:array) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(a[0]);
                    list.add(a[1]);

                    if(!existInList(res, list)) {
                        res.add(list);
                    }

                }

            }


        }



        return res;


    }


    private static List<int[]> twoSum(Integer[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res.add(new int[]{target - nums[i], nums[i]});
            }
            map.put(nums[i], i);
        }

        return res;


    }





    //method runs with O(N^3)

    /*
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if(!existInList(res, list)){
                            res.add(list);
                        }



                    }
                }
            }
        }

        return res;

    }*/

    public static boolean existInList(List<List<Integer>> lists, List<Integer> nums) {


        HashSet<Integer> set = new HashSet<>(nums);

        for(int j = 0; j < lists.size(); j++) {
                HashSet<Integer> temp = new HashSet<>(lists.get(j));

                if(set.equals(temp)) {
                    return true;
                }


        }


        return false;
    }









}
