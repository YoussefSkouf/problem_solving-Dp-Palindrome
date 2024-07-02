import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    static int n, k;
    static int[] a = new int[10000];
    static int[][][] vis = new int[10000][21][21];

    public static int solve(int i, int k1, int k2) {
        int j = n - i - 1 - k1 + k2;
        if (i >= j) return 0;
        if (vis[i][k1][k2] != -1) return vis[i][k1][k2];
        if (k1 + k2 > k) return 30;
        if (a[i] == a[j]) return vis[i][k1][k2] = solve(i + 1, k1, k2);
        return vis[i][k1][k2] = 1 + Math.min(solve(i + 1, k1, k2 + 1), solve(i, k1 + 1, k2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, ans;
        t = sc.nextInt();
        for (int T = 1; T <= t; T++) {
            for (int[][] matrix : vis) {
                for (int[] row : matrix) {
                    Arrays.fill(row, -1);
                }
            }
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            ans = solve(0, 0, 0);
            if (ans == 0) {
                System.out.printf("Case %d: Too easy\n", T);
            } else if (ans > k) {
                System.out.printf("Case %d: Too difficult\n", T);
            } else {
                System.out.printf("Case %d: %d\n", T, ans);
            }
        }
        sc.close();
    }
}
