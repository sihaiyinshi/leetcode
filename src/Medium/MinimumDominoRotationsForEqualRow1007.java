package Medium;

public class MinimumDominoRotationsForEqualRow1007 {


    public static void main(String[] args) {

        //System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2},new int[]{5,2,6,2,3,2}));

        //System.out.println(minDominoRotations(new int[]{3,5,1,2,3},new int[]{3,6,3,3,4}));

        //System.out.println(minDominoRotations(new int[]{2,2,2,2,1},new int[]{1,1,2,1,2}));

        System.out.println(minDominoRotations(new int[]{1,2,1,1,1,2,2,2},new int[]{2,1,2,2,2,2,2,2}));

    }


    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int minDomino=tops.length;

        for(int i=1;i<=6;i++){
            minDomino=Math.min(minDomino,minDominoRotations(tops,bottoms,i));
        }

        if(minDomino==tops.length){
            return -1;
        }

        return minDomino;
    }

    public static int minDominoRotations(int[] tops, int[] bottoms, int target){
            int count=0;
            for(int i=0;i<tops.length;i++){
                if(bottoms[i]!=target && tops[i]!=target){
                    return tops.length;
                }
                else if(bottoms[i]==target && tops[i]!=target){
                    count++;
                }
            }
            return Math.min(count,tops.length-count);
    }




}
