package weeklycontest370;

public class Champion {
    public int findChampion(int[][] grid) {
        int[] result = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int[] gridA = grid[i];
            for (int j = 0; j < gridA.length; j++) {
                result[j] += gridA[j];
            }
        }

        int count = 0;
        int resultIndex = -1;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                ++count;
                resultIndex = i;
            }
        }

        if (count == 1) {
            return resultIndex;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Champion champion = new Champion();

//        int[][] val = {{0, 1}, {0, 0}};
//        int[][] val = {{1, 1}, {0, 0}};
        int[][] val = {{1, 0}, {0, 0}};
        int champion1 = champion.findChampion(val);
        System.out.println(champion1);
    }
}


