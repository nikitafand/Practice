package coding.dsa;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,4,3},{2,5, 7}};//{{-5}};
        boolean b = searchMatrix(matrix, 2);
        System.out.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m * n - 1, low = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int row= mid/n;
            int col= mid%n;
            int midval= matrix[row][col];
            if (midval == target) {
                return true;
            } else if (midval > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}