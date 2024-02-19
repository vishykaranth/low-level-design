package arrays;

public class Seperate0s1sNumbers {
    public static void seperate0s1sNumbers(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int left, right;
        left = 0;
        right = arr.length - 1;

        while (left < right) {
            while (arr[left] % 2 == 0 && left < right) {
                left++;
            }

            while (arr[right] % 2 == 1 && left < right) {
                right--;
            }

            if (left < right) {
                int x = arr[left];
                arr[left] = arr[right];
                arr[right] = x;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1};

        Seperate0s1sNumbers.seperate0s1sNumbers(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
