
import java.io.*;
import java.util.*;

public class konigsberg {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            degree[a]++;
            degree[b]++;
        }

        int oddCount = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount == 0 || oddCount == 2) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }
        pw.flush();
    }
}
