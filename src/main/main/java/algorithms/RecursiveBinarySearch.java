package algorithms;

public class RecursiveBinarySearch {
    public static int binarySearch(int[] input, int target, int start, int end) {
        if (start >= end) {
            return -1;
        } else {
            int mid = start + (end - start) / 2;

            if (target < input[mid]) {
                return binarySearch(input, target, start, mid - 1);
            } else if (target > input[mid]) {
                return binarySearch(input, target, mid + 1, end);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 14, 23, 56};
        System.out.println(binarySearch(data, 23, 0, data.length - 1));
        System.out.println(binarySearch(data, 24, 0, data.length - 1));
    }
}