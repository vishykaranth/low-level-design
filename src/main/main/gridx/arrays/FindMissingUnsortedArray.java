package arrays;

public class FindMissingUnsortedArray {
    public int findMissingUnsortedArray(int[] arr, int n) {
        int sum = (n * (n + 1)) / 2;

        for (int i = 0; i < arr.length; i++) {
            sum = sum - arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        FindMissingUnsortedArray a = new FindMissingUnsortedArray();
        int[] arr = {2, 4, 1, 3, 6, 7, 8};

        System.out.println(a.findMissingUnsortedArray(arr, arr.length + 1));
    }
}
