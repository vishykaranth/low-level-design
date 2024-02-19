package arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = {12, 34, 45, 65, 83};

        BinarySearch obj = new BinarySearch();
        int i = obj.searchIndex(a, 65, 0, a.length - 1);

        System.out.println(i);
    }

    /*
     * It'll search value in array using Binary Search
     */
    public int searchIndex(int[] a, int val, int start, int end) {
        if (a.length == 0 || start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (a[mid] == val) {
            return mid;
        }

        if (val > a[mid]) {
            return searchIndex(a, val, mid + 1, end);
        } else {
            return searchIndex(a, val, start, mid - 1);
        }
    }

}