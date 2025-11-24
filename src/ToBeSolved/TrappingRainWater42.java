package ToBeSolved;

public class TrappingRainWater42 {


    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        //System.out.println(trap(new int[]{4,2,0,3,2,5}));
        //System.out.println(trap(new int[]{0,1}));
        //System.out.println(trap(new int[]{4,2,3}));

    }


    public static int trap(int[] height) {


        if(height.length <3){
            return 0;
        }


        boolean isTrap = false;
        int localMax =0;
        int totalWater=0;

        int slow=1;

        for (int fast = 0; fast < height.length-1; fast++) {

            if(isTrap && height[fast]>=height[slow] ){

                for(int i=slow;i<fast;i++){
                    totalWater+=(height[slow]-height[i]);
                }
                isTrap = false;
                slow=fast;

            }

            if(!isTrap && height[fast+1] < height[fast] ){

                isTrap = true;
                slow=fast;

            }


        }

        return totalWater;

    }


}
