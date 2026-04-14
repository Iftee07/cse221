import java.io.*;
import java.util.*;

public class adjMat {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] adjMat = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            adjMat[u - 1][v - 1] = x;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pw.print(adjMat[i][j] + " ");
            }
            pw.println();
        }

        pw.flush();
    }
}
