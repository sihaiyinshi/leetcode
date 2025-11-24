package Medium;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 *
 * */

public class LargestNumber179 {


    public static void main(String[] args) {

        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{432,43243}));



    }


    public static String largestNumber(int[] nums) {


        quickSort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for(int i=nums.length-1;i>=0;i--){
                sb.append(nums[i]);
            }


        if(sb.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }





    public static void quickSort(int[] array, int left, int right){
        if(left>=right){
            return;
        }

        int part=partition(array, left, right);
        quickSort(array, left, part-1);
        quickSort(array, part+1, right);


    }


    public static int partition(int[] array, int left, int right){
        int pivot = array[right];
        int i = left;


        for(int j=left;j<right;j++){
            if(compare(array[j],pivot)){
                if(i==j){
                    i++;
                }
                else{
                    int temp= array[i];
                    array[i++]=array[j];
                    array[j]=temp;
                }
            }
        }


        int temp= array[i];
        array[i]=array[right];
        array[right]=temp;
        return i;

    }

    public static boolean compare(int a, int b){

        if(a==1000000000 && b==1000000000){
            return true;
        }


        String c=Integer.toString(a);
        String d=Integer.toString(b);
        return Long.parseLong(c+d)<=Long.parseLong(d+c);


    }


    /*Note:
    * Very difficult before I got it...
    * Only a problem of sort with special algorithm and considering some special cases cuz I am using Java
    *
    * */



}
