package coding.dsa;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights= new int[]{1,8,6,2,5,4,8,3,7};
       int maxWater=  maxArea(heights);
        System.out.println(maxWater);
    }
    private static int maxArea(int[] height) {

        int maxWater= 0;
        int left=0, right= height.length-1, currentWater;

        while(left < right){
            int width= right-left;
            int minHeight= Math.min(height[left], height[right]);
            currentWater= width * minHeight;
            maxWater= Math.max(maxWater, currentWater);

            if(height[left]< height[right]){
                left++;
            }else {
                right--;
            }

        }
         return maxWater;
    }
}
