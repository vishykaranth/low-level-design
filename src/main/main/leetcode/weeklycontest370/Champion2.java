package weeklycontest370;

public class Champion2 {
    public int findChampion(int n, int[][] edges) {
        int[] result = new int[n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            for (int j = 0; j <= edge[0]; j++) {
                result[j] += 1;
            }

        }

        for (int i = 0; i < result.length; i++) {

            if (result[i] == n - 1) {
                return i;
            }
//            System.out.println(result[i]);
        }

        return -1;
    }

    public static void main(String[] args) {
        Champion2 champion = new Champion2();

//        int[][] val = {{0, 1}, {1, 2}};
        int[][] val = {{0, 2}, {1, 3}, {1, 2}};
        int champion1 = champion.findChampion(4, val);
        System.out.println(champion1);
    }
}


