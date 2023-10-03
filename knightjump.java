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
        char[][] board = new char[n][n];
        Queue<Pair> q = new LinkedList<>();
        HashSet<Pair> visited = new HashSet<>();

        //Indexes of our start
        Pair K = new Pair();
        for (int i = 0; i < n; i++) {
            String s = scnr.next();
            for (int j = 0; j < n; j++) {
                char ch = s.charAt(i);
                board[i][j] = ch;
                if (ch == 'K') {
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
        boolean runLoop = true;
        while (q.size() != 0 && runLoop) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair pair = q.remove();
                if (K.x == pair.x && K.y == pair.y) {
                    System.out.println(count);
                    runLoop = false;
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int x = xArr[j] + pair.x;
                    int y = yArr[j] + pair.y;
                    Pair curr = new Pair(x, y);
                    if (!visited.contains(curr)
                        && (x < n && x >= 0 && y < n && y >= 0)
                        && board[x][y] != '#') {
                        q.add(curr);
                        visited.add(curr);
                    }
                }
            }
            count++;
        }
        if (runLoop) System.out.println(-1);
    }
}
