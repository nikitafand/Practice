package coding.dsa;

public class SearchMatrixII {

    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println( SearchTargetInMatrix(matrix, target));

    }

    private static Boolean SearchTargetInMatrix(int[][] matrix, int target) {


        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }


        return false;

    }
}
