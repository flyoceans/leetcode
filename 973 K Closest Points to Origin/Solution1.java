class Solution {
    Random random = new Random();
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void quickSelect(int[][] points, int leftBound, int rightBound, int k) {
        if (leftBound >= rightBound) {
            return;
        }
        int middle = partition(points, leftBound, rightBound);
        if (middle == k) {
            return;
        } else if (middle > k) {
            quickSelect(points, leftBound, middle - 1, k);
        } else {
            quickSelect(points, middle + 1, rightBound, k);
        }
    }
    
    private int partition(int[][] points, int leftBound, int rightBound) {
        int pivotIndex = leftBound + random.nextInt(rightBound - leftBound);
        int[] pivot = points[pivotIndex];
        swap(points, rightBound, pivotIndex);
        int left = leftBound, right = rightBound - 1;
        while (left <= right) {
            while (left <= right && compare(points[left], pivot) <= 0) {
                left++;
            }
            while (left <= right && compare(points[right], pivot) > 0) {
                right--;
            }
            if (left < right) {
                swap(points, left, right);
            }
        }
        swap(points, left, rightBound);
        return left;
    }
    
    private int compare(int[] point1, int[] point2) {
        return distance(point1) - distance(point2);
    }
    
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}