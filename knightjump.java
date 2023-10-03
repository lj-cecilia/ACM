import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class knightjump {
    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pair() {}
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        String[][] board = new String[n][n];
        Queue<Pair> q = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();

        //Indexes of our start
        Pair K = new Pair();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String s = scnr.next();
                board[i][j] = s;
                if (s.equals("K")) {
                    K.x = i;
                    K.y = j;
                }
                //if (s.equals("#")) board[i][j] = "#";
            }
        }
        //BFS
        int[] xArr = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
        int[] yArr = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
        int count = 0;
        q.add(new Pair(0,0));
        while (q.size() != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.remove();
                if (K.x == pair.x && K.y == pair.y) {
                    System.out.println(count);
                }
                for (int j = 0; j < 8; j++) {
                    int x = xArr[j] + pair.x;
                    int y = yArr[j] + pair.y;
                    Pair curr = new Pair(x, y);
                    if (!board[x][y].equals("K") && visited.contains(curr)
                            && (x < n && x >= 0 || y < n && y >= 0)) {
                        q.add(curr);
                        visited.add(curr);
                    }
                }
            }
            count++;
        }
        System.out.println(-1);
    }
}
