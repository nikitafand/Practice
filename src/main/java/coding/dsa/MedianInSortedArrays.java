package coding.dsa;

public class MedianInSortedArrays {

    public static void main(String[] args) {
       int[] nums1 = {1,2};
       int[] nums2 = {3,4};
        Double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    private static Double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m= nums1.length,n=nums2.length;
        int[] res= new int[m+n];
        int i =0, j=0, k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
              res[k++]=nums1[i++];
            }else {
                res[k++]=nums2[j++];
            }
        }
        while(i<m){
            res[k++]=nums1[i++];
        }while(j<n){
            res[k++]=nums2[j++];
        }

        if(res.length%2==0){
            int z= res.length/2;
            return (double) (res[z]+ res[z-1])/2;

        }else if(res.length%2==1) {
            int z = res.length / 2;
            return (double) res[z];
        }
      return 0.0;

    }

}
