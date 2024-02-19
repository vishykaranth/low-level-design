package algorithms;

public class LinearSearchExample {
    public static int linearSearch(int[] data, int key) {
        for (int index = 0; index < data.length; index++) {
            if (data[index] == key) {
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {10, 14, 23, 56};
        System.out.println(linearSearch(data, 23));
        System.out.println(linearSearch(data, 24));
    }
}