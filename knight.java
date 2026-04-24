
import java.io.*;
import java.util.*;

public class knight {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new java.io.PrintWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int dist[][] = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dist[i], -1);
        }
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        int moves[][] = {
                { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 },
                { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }
        };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x1, y1 });
        dist[x1][y1] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[0] == x2 && curr[1] == y2) {
                pw.println(dist[curr[0]][curr[1]]);
                pw.close();
                return;
            }

            for (int[] move : moves) {
                int newX = curr[0] + move[0];
                int newY = curr[1] + move[1];

                if (newX >= 1 && newX <= N && newY >= 1 && newY <= N && dist[newX][newY] == -1) {
                    dist[newX][newY] = dist[curr[0]][curr[1]] + 1;
                    q.add(new int[] { newX, newY });
                }
            }
        }
        pw.println(-1);
        pw.close();
    }
}
