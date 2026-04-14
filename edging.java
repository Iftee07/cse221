import java.io.*;
import java.util.StringTokenizer;

public class edging {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] out = new int[n + 1];
        int[] in = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            out[a]++;
            in[b]++;
        }
        for (int i = 1; i <= n; i++) {
            pw.print(in[i] - out[i] + " ");
        }
        pw.flush();
    }
}
