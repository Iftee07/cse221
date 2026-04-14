
import java.io.*;
import java.util.*;

public class ajdToMat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            for (int j = 0; j < u; j++) {
                int v = Integer.parseInt(st.nextToken());
                mat[i][v] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pw.print(mat[i][j] + " ");
            }
            pw.println();
        }
        pw.flush();

    }
}
