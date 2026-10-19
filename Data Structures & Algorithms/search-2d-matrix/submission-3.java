class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int size = rowSize * colSize;
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int row = mid / colSize;
            int col = mid % colSize;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
