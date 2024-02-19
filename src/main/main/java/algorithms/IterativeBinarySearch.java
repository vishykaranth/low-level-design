package algorithms;

public class IterativeBinarySearch {
    public static Integer binarySearch(int[] input, int target) {
        int first = 0;
        int last = input.length - 1;

        while (first <= last) {
            int mid = (first + last) / 2;

            if (input[mid] == target) {
                return mid;
            } else if (input[mid] < target) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] data = {10, 14, 23, 56};
        System.out.println(binarySearch(data, 23));
        System.out.println(binarySearch(data, 24));
    }
}