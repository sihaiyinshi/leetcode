package Medium;
/**
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 *
 *
 * Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 * */


public class SortColors75 {

        public static void main(String[] args) {



            //int[] array=new int[]{2,0,2,1,1,0,0,1,2,0};
            int[] array = {2,2,0};
            sortColors(array);
            for (int i : array) {
                System.out.print(i+" ");
            }

        }




        public static void sortColors(int[] nums) {


            int pointer0 = 0;
            int pointer2 = nums.length - 1;


            for(int i = 0; i < nums.length; i++){


                if(nums[i] == 0){

                    if(i==pointer0){
                        pointer0++;
                    }
                    else{
                        int temp = nums[pointer0];
                        nums[pointer0]=nums[i];
                        nums[i]=temp;
                        pointer0++;

                    }
                }
                else if(nums[i]==2){



                    while(nums[pointer2]==2&&pointer2>0){

                        pointer2--;
                    }

                    if(i>=pointer2){
                        break;
                    }

                    if(nums[pointer2]==0){
                        nums[pointer2--]=2;
                        nums[i]=0;
                        int temp = nums[pointer0];
                        nums[pointer0++]=nums[i];
                        nums[i]=temp;
                    }
                    else{
                        nums[i]=1;
                        nums[pointer2]=2;
                    }




                }





            }




        }












        public static void quickSort(int[] array){
            quickSort(array, 0, array.length-1);
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
                if(array[j]<pivot){
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

        /*Notes:
        * It is actually a simplified version of quicksort
        *
        *
        * */




}
