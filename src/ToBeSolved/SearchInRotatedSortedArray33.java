package ToBeSolved;

public class SearchInRotatedSortedArray33 {


    public static void main(String[] args) {


        System.out.println(search(new int[]{2,4,5,6,7,0,1},0));
        //System.out.println(search(new int[]{2,4,5,6,7,0,1},3));
        //System.out.println(search(new int[]{1},0));
        System.out.println(search(new int[]{2,3,5,0,1},3));

    }


    public static int search(int[] nums, int target) {


        int p1=0;
        int p2=nums.length-1;

        while(p1<=p2){

            int mid=(p1+p2)/2;
            if(nums[mid]==target){
                return mid;
            }




            if(target<nums[mid]){

                if(nums[p1]>nums[p2]){
                    p1=mid+1;
                }
                else{
                    p2=mid-1;
                }

            }
            else{

                if(nums[p2]<nums[p1]){
                    p2 = mid-1;
                }
                else{
                    p1= mid + 1;
                }

            }


        }

        return -1;





        /*
        int p1=0;
        int p2=nums.length-1;
        int mid=(p1+p2)/2;

        while(mid>p1){

            if(nums[mid]>target){
                p2=p2-((p2-p1)/2);
            }
            else{
                p1=p1+((p2-p1)/2);
            }
            mid=(p2+p1)/2;

        }


        if(nums[mid]!=target){

            if(mid==0){

                p2=nums.length-1;
                p1=p2/2;
                mid=(p1+p2)/2;


            }
            else if(mid==nums.length-1){

            }

        }


        return mid;*/



    }

}
