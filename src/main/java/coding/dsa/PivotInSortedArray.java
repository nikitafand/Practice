package coding.dsa;

import java.util.ArrayList;
import java.util.List;

public class  PivotInSortedArray {
    public static void main(String[] args) {
 List<Integer> list = new ArrayList<>(List.of(1,2,3));
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        // create int array
//
//        int[] arr = new int[n];
//
//        // input elements
//
//        for (int i = 0; i < n; i++) {
//
//            arr[i] = sc.nextInt();
//
//        }
//
//        System.out.println(Arrays.toString(arr));


        int[] nums= {4,5,6,7,0,1,2,3};
        int[] nums1= {1,2,3,4,5};
        int[] nums2= {4};
        int pivotInArray = findPivotInArray(nums2);
        System.out.println(pivotInArray);
    }

    private static int findPivotInArray(int[] input) {

        if (input == null || input.length == 0) {

            return 0;

        }
      int n = input.length/2;
      int len=input.length;

      int low= 0 , high= len-1;
      while(low<high){
          int mid = low+ (high-low)/2;
          if(input[mid]>input[high]){
              low = mid+1;
          }else {
              high = mid;
          }

      }
        System.out.println(input[low]);
       return input[low];
    }
}
